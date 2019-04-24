package com.hyz.jsl.structfund;

import com.hyz.jsl.structfund.module.*;
import retrofit2.Call;

import java.io.*;
import java.text.*;
import java.util.*;

public class Main {
    public static final String COMMA = ",";
    public static final int MIN_A_VOLUME = 3;
    public static final int MIN_VOLUME = 30;
    public static final float MIN_PROFIT_RATE = 0.015F;
    private static Map<String, AFund> aFundMap;
    private static Map<String, BFund> bFundMap;
    private static Set<String> applyFailedMFunds = new HashSet<>();
    private static Map<String,Integer> mFundsMinApplyMap = new HashMap<>();
    private static Map<String,Integer> mFundsConfirmMap = new HashMap<>();
    private static final int DEFAULT_MIN_APPLY_VALUE = 1000;
    private static final int DEFAULT_MIN_CONFIRM_VALUE = 1000;

    static {
        //5W申购失败
        applyFailedMFunds.add("163113");//申万证券
        applyFailedMFunds.add("502013");//长盛一带一路
        //1K申购失败
        applyFailedMFunds.add("165515");//信诚300
        applyFailedMFunds.add("502053");//长盛券商分级
        applyFailedMFunds.add("160630");//鹏华国防分级
        //最低限额
        applyFailedMFunds.add("161720");//招商券商分级
        applyFailedMFunds.add("160633");//鹏华券商分级

    }

    static {
        mFundsMinApplyMap.put("502010", 50000);//易方达证券分级，申5W给1K
        mFundsMinApplyMap.put("502003", 50000);//易方达军工分级，申5W给1K
        mFundsMinApplyMap.put("160221", 50000);//国泰有色，限额5W
//        mFundsMinApplyMap.put("160630", ？？？);//鹏华国防分级
        mFundsMinApplyMap.put("161024", 1000);//军工分级
        mFundsMinApplyMap.put("161025", 1000);//移动互联
        mFundsMinApplyMap.put("161027", 1000);//证券分级
        mFundsMinApplyMap.put("163109", 1000);//申万深成

    }

    static {
        mFundsConfirmMap.put("502010", 1000);//易方达证券分级，申5W给1K
        mFundsConfirmMap.put("502003", 50000);//易方达军工分级，申5W给1K
        mFundsConfirmMap.put("160221", 50000);//国泰有色，限额5W
    }

    public static void main(String[] args) throws IOException {
        StructService structService = StructRetrofit.getStructService();

        Call<StructFundResult<AFund>> aFundCall = structService.getAFund();
        List<AFund> aFundList = aFundCall.execute().body().rows;
        aFundMap = AFund.listToMap(aFundList);

        Call<StructFundResult<BFund>> bFundCall = structService.getBFund();
        List<BFund> bFundList = bFundCall.execute().body().rows;
        bFundMap = BFund.listToMap(bFundList);


        Call<StructFundResult<MotherFund>> motherFundsCall = structService.getMotherFund();
        List<MotherFund> motherFundList = motherFundsCall.execute().body().rows;
        List<MotherFund> volumedMotherFundList = new ArrayList<>();
        List<MotherFund> targetMotherFundList = new ArrayList<>();
        for (int i = 0; i < motherFundList.size(); i++) {
            MotherFund motherFund = motherFundList.get(i);
            motherFund.aFund = aFundMap.get(motherFund.cell.fundAId);
            motherFund.bFund = bFundMap.get(motherFund.cell.fundBId);

            float aPrice = Float.parseFloat(motherFund.aFund.cell.fundaCurrentPrice);
            float bPrice = Float.parseFloat(motherFund.bFund.cell.fundbCurrentPrice);
            float motherValue = Float.parseFloat(motherFund.cell.price);

            float indexIncrease = 0;
            NumberFormat percentFormat = NumberFormat.getPercentInstance();
            try {
                indexIncrease = percentFormat.parse(motherFund.aFund.cell.fundaIndexIncreaseRt).floatValue();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            motherFund.estimatedValue = motherValue * (1+indexIncrease);
            motherFund.splitABPrice = (aPrice * motherFund.cell.aRatio + bPrice * motherFund.cell.bRatio) / (motherFund.cell.aRatio + motherFund.cell.bRatio);
            motherFund.splitPremiumRate = (aPrice*motherFund.cell.aRatio + bPrice*motherFund.cell.bRatio) / (motherFund.estimatedValue * (motherFund.cell.aRatio + motherFund.cell.bRatio) ) - 1;

            float aFundVolume = Float.parseFloat(motherFund.aFund.cell.fundaVolume);
            float bFundVolume = Float.parseFloat(motherFund.bFund.cell.fundbVolume);

            float applyFee = 0;
            try {
                applyFee = percentFormat.parse(motherFund.cell.applyFee).floatValue();
            } catch (ParseException e) {
                //ignore
            }
            Integer minApply = mFundsMinApplyMap.containsKey(motherFund.cell.baseFundId) ? mFundsMinApplyMap.get(motherFund.cell.baseFundId) : DEFAULT_MIN_APPLY_VALUE;
            float confirmValue = mFundsConfirmMap.containsKey(motherFund.cell.baseFundId) ? mFundsConfirmMap.get(motherFund.cell.baseFundId) : DEFAULT_MIN_CONFIRM_VALUE;
            float capitalCost = (minApply / 10000F * 2F) / confirmValue;
//                float safesPremiumRate = MIN_PROFIT_RATE + applyFee;
            motherFund.expectedProfitRate = motherFund.splitPremiumRate - applyFee - capitalCost;

            if (aFundVolume > MIN_A_VOLUME && bFundVolume > MIN_VOLUME) {
                volumedMotherFundList.add(motherFund);

                if(!applyFailedMFunds.contains(motherFund.cell.baseFundId) && motherFund.expectedProfitRate > MIN_PROFIT_RATE){
                    targetMotherFundList.add(motherFund);
                }
            }

        }

        Collections.sort(motherFundList);
        File allFile = new File("data/StructFund-all-"
                + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())
                + ".csv");
        saveCsvFile(motherFundList,allFile);

        String limitDesc = "-成交" + MIN_VOLUME+"-";
        String minRateDesc = "收益率阈值" + MIN_PROFIT_RATE +"-";
        Collections.sort(volumedMotherFundList);
        File volumedFile = new File("data/StructFund-volumed-"+limitDesc
                + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())
                + ".csv");
        saveCsvFile(volumedMotherFundList,volumedFile);

        Collections.sort(targetMotherFundList);
        File targetFile = new File("data/StructFund-target-"+limitDesc+minRateDesc
                + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())
                + ".csv");
        saveCsvFile(targetMotherFundList,targetFile);

//        Gson gson = new Gson();
//        String resultString = gson.toJson(motherFundList);
//        File file = new File("StructFund-"
//                + new SimpleDateFormat("yyyy-MM-dd").format(new Date())
//                + ".json");
//        new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))).write(resultString);
    }

    public static void saveCsvFile(List<MotherFund> motherFundList, File outFile) throws IOException {
        System.out.println("符合条件的基金个数：" + motherFundList.size());


        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        bufferedWriter.write("母基代码,母基名称,预期套利收益率,T溢价率,T-1溢价率,T-2溢价率,分拆价,母基估值,母基净值,申购费率" +
                ",A基名称,A基代码,A价格,A涨幅,A净值,A折价率,A新增万份,A成交万元" +
                ",B基名称,B基代码,B价格,B涨幅,B估值,B净值,B溢价率,B新增万份,B成交万元" +
                ",A:B,跟踪指数,指数涨幅");

        DecimalFormat dot4Format = new DecimalFormat("0.0000");
        NumberFormat percent2Format = NumberFormat.getPercentInstance();//获取格式化对象
        percent2Format.setMinimumFractionDigits(2);
        int size = motherFundList.size();
        for (int i = size - 1; i >= 0; i--) {
            bufferedWriter.newLine();

            MotherFund motherFund = motherFundList.get(i);
            AFund aFund = motherFund.aFund;
            BFund bFund = motherFund.bFund;

            StringBuilder sb = new StringBuilder();
            //母基
            sb.append(motherFund.cell.baseFundId).append(COMMA)
                    .append(motherFund.cell.baseFundNm).append(COMMA)
                    .append(percent2Format.format(motherFund.expectedProfitRate)).append(COMMA)
                    .append(percent2Format.format(motherFund.splitPremiumRate)).append(COMMA)
                    .append(aFund.cell.fundaBaseEstDisRtT1).append(COMMA)
                    .append(aFund.cell.fundaBaseEstDisRtT2).append(COMMA)
                    .append(dot4Format.format(motherFund.splitABPrice)).append(COMMA)
                    .append(dot4Format.format(motherFund.estimatedValue)).append(COMMA)
                    .append(motherFund.cell.price).append(COMMA)
                    .append(motherFund.cell.applyFee).append(COMMA)
                    //A基
                    .append(aFund.cell.fundaName).append(COMMA)
                    .append(aFund.cell.fundaId).append(COMMA)
                    .append(aFund.cell.fundaCurrentPrice).append(COMMA)
                    .append(aFund.cell.fundaIncreaseRt).append(COMMA)
                    .append(aFund.cell.fundaValue).append(COMMA)
                    .append(aFund.cell.fundaDiscountRt).append(COMMA)
                    .append(aFund.cell.fundaAmountIncrease).append(COMMA)
                    .append(aFund.cell.fundaVolume).append(COMMA)

                    //B基
                    .append(bFund.cell.fundbName).append(COMMA)
                    .append(bFund.cell.fundbId).append(COMMA)
                    .append(bFund.cell.fundbCurrentPrice).append(COMMA)
                    .append(bFund.cell.fundbIncreaseRt).append(COMMA)
                    .append(bFund.cell.bEstVal).append(COMMA)
                    .append(bFund.cell.fundbValue).append(COMMA)
                    .append(bFund.cell.fundbDiscountRt).append(COMMA)
                    .append(bFund.cell.fundBAmountIncrease).append(COMMA)
                    .append(bFund.cell.fundbVolume).append(COMMA)

                    //其他
                    .append(motherFund.cell.aRatio + ":" + motherFund.cell.bRatio).append(COMMA)
                    .append(aFund.cell.fundaIndexName).append(COMMA)
                    .append(aFund.cell.fundaIndexIncreaseRt).append(COMMA);


            bufferedWriter.write(sb.toString());

        }

        bufferedWriter.flush();
        bufferedWriter.close();

    }

}
