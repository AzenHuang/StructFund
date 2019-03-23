package com.hyz.jsl.structfund;

import com.google.gson.Gson;
import com.hyz.jsl.structfund.module.*;
import retrofit2.Call;

import java.io.*;
import java.text.*;
import java.util.*;

public class Main {
    public static final String COMMA = ",";
    public static final int MIN_VOLUME = 50;
    private static Map<String, AFund> aFundMap;
    private static Map<String, BFund> bFundMap;

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
        List<MotherFund> outputMotherFundList = new ArrayList<>();
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
            motherFund.splitPremiumRate = ((aPrice + bPrice) / motherFund.estimatedValue / 2 - 1);

            float aFundVolume = Float.parseFloat(motherFund.aFund.cell.fundaVolume);
            float bFundVolume = Float.parseFloat(motherFund.bFund.cell.fundbVolume);

            if (aFundVolume > MIN_VOLUME && bFundVolume > MIN_VOLUME) {
                outputMotherFundList.add(motherFund);
            }

        }

        Collections.sort(outputMotherFundList);
        saveCsvFile(outputMotherFundList);

//        Gson gson = new Gson();
//        String resultString = gson.toJson(motherFundList);
//        File file = new File("StructFund-"
//                + new SimpleDateFormat("yyyy-MM-dd").format(new Date())
//                + ".json");
//        new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))).write(resultString);
    }

    public static void saveCsvFile(List<MotherFund> motherFundList) throws IOException {
        System.out.println("符合条件的基金个数：" + motherFundList.size());

        File file = new File("data/StructFund-"
                + new SimpleDateFormat("yyyy-MM-dd").format(new Date())
                + ".csv");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        bufferedWriter.write("母基代码,母基名称,整体溢价率,T-1溢价率,T-2溢价率,母基估值,母基净值,申购费率" +
                ",A基名称,A基代码,A价格,A净值,A折价率" +
                ",B基名称,B基代码,B价格,B估值,B净值,B溢价率" +
                ",跟踪指数,指数涨幅");

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
                    .append(percent2Format.format(motherFund.splitPremiumRate)).append(COMMA)
                    .append(aFund.cell.fundaBaseEstDisRtT1).append(COMMA)
                    .append(aFund.cell.fundaBaseEstDisRtT2).append(COMMA)
                    .append(dot4Format.format(motherFund.estimatedValue)).append(COMMA)
                    .append(motherFund.cell.price).append(COMMA)
                    .append(motherFund.cell.applyFee).append(COMMA)
                    //A基
                    .append(aFund.cell.fundaName).append(COMMA)
                    .append(aFund.cell.fundaId).append(COMMA)
                    .append(aFund.cell.fundaCurrentPrice).append(COMMA)
                    .append(aFund.cell.fundaValue).append(COMMA)
                    .append(aFund.cell.fundaDiscountRt).append(COMMA)
                    //B基
                    .append(bFund.cell.fundbName).append(COMMA)
                    .append(bFund.cell.fundbId).append(COMMA)
                    .append(bFund.cell.fundbCurrentPrice).append(COMMA)
                    .append(bFund.cell.bEstVal).append(COMMA)
                    .append(bFund.cell.fundbValue).append(COMMA)
                    .append(bFund.cell.fundbDiscountRt).append(COMMA)
                    //指数
                    .append(aFund.cell.fundaIndexName).append(COMMA)
                    .append(aFund.cell.fundaIndexIncreaseRt).append(COMMA);


            bufferedWriter.write(sb.toString());

        }

        bufferedWriter.flush();
        bufferedWriter.close();

    }

}
