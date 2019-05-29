package com.hyz.jsl.structfund.module;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MotherFund extends StructFund implements Comparable<MotherFund> {
    /**
     * id : 160127
     * cell : {"base_fund_id":"160127","base_fund_nm":"南方消费","base_fund_py":"nfxf","active_fl":"Y","mtrade":"N","market":"sz","mflag":"Y","fund_company_nm":"南方基金","fund_manager":"蒋秋洁","issue_dt":"2012-03-13","maturity_dt":"-","list_dt":"2012-04-25","manage_fee":"1.750","index_id":"000942","index_nm":"主动基金","upper_recalc_price":"定折归一","lower_recalc_price":"0.20","asset_ratio":"80.000","fully":"Y","a_ratio":5,"b_ratio":5,"fund_descr":"03/13，定折时A/B/M全归1，可顺延定折日","money_cd":"CNY","pre_recacl_dt":null,"next_recalc_dt":"2020-03-13","next_recalc_dt2":null,"fundA_id":"150049","fundA_nm":"消费收益","fundA_py":"xfsy","coupon_descr":"+3.2%，动态调整","coupon_descr_s":"+3.2%","coupon":"4.70","coupon_next":"4.70","coupon_next2":null,"fundB_id":"150050","fundB_nm":"消费进取","fundB_py":"xfjq","lower_recalc_comment":"B类净值低于","a_amount":null,"a_amount_increase_rt":null,"status_cd":"N","recalc_to":null,"calc_info":"基金公告： 自 2019-02-27 日起，限制大额(5万元，不含)申购。","apply_fee":"1.5%","apply_fee_tip":"100万以下，1.5% 100万（含）至500万，0.9% 500万（含）至1000万，0.3% 1000万（含）以上，每笔1000元 ","redeem_fee":"1.5%","redeem_fee_tip":"持有7日内1.5% 持有7日至1年，0.5% 持有1年至2年，0.3% 持有2年以上，0","min_apply_amount":null,"notes":"http://www.nffund.com/new/fundproduct/?action=searchjjfl&fundcode=160127&index=2","price":"1.0640","last_chg_dt":"2019-03-18","b_gangan":"1.899","base_lower_recalc_rt":"43.21%","base_est_dis_rt":"buy","left_year":"永续","abrate":"5:5","base_est_dis_rt_tip":""}
     */

    @SerializedName("cell")
    public CellBean cell;

    public AFund aFund;
    public BFund bFund;
    public float splitPremiumRate;
    public float expectedProfitRate;
    public float splitABPrice;
    public float estimatedValue;
    //预估套利申购户数
    public int applyAccountNum;

    @Override
    public int compareTo(MotherFund compared) {
        if (compared == null) {
            return 1;
        }
        if (expectedProfitRate == compared.expectedProfitRate) {
            return 0;
        } else if (expectedProfitRate > compared.expectedProfitRate){
            return 1;
        } else {
            return -1;
        }
    }


    public static class CellBean {
        /**
         * base_fund_id : 160127
         * base_fund_nm : 南方消费
         * base_fund_py : nfxf
         * active_fl : Y
         * mtrade : N
         * market : sz
         * mflag : Y
         * fund_company_nm : 南方基金
         * fund_manager : 蒋秋洁
         * issue_dt : 2012-03-13
         * maturity_dt : -
         * list_dt : 2012-04-25
         * manage_fee : 1.750
         * index_id : 000942
         * index_nm : 主动基金
         * upper_recalc_price : 定折归一
         * lower_recalc_price : 0.20
         * asset_ratio : 80.000
         * fully : Y
         * a_ratio : 5
         * b_ratio : 5
         * fund_descr : 03/13，定折时A/B/M全归1，可顺延定折日
         * money_cd : CNY
         * pre_recacl_dt : null
         * next_recalc_dt : 2020-03-13
         * next_recalc_dt2 : null
         * fundA_id : 150049
         * fundA_nm : 消费收益
         * fundA_py : xfsy
         * coupon_descr : +3.2%，动态调整
         * coupon_descr_s : +3.2%
         * coupon : 4.70
         * coupon_next : 4.70
         * coupon_next2 : null
         * fundB_id : 150050
         * fundB_nm : 消费进取
         * fundB_py : xfjq
         * lower_recalc_comment : B类净值低于
         * a_amount : null
         * a_amount_increase_rt : null
         * status_cd : N
         * recalc_to : null
         * calc_info : 基金公告： 自 2019-02-27 日起，限制大额(5万元，不含)申购。
         * apply_fee : 1.5%
         * apply_fee_tip : 100万以下，1.5% 100万（含）至500万，0.9% 500万（含）至1000万，0.3% 1000万（含）以上，每笔1000元
         * redeem_fee : 1.5%
         * redeem_fee_tip : 持有7日内1.5% 持有7日至1年，0.5% 持有1年至2年，0.3% 持有2年以上，0
         * min_apply_amount : null
         * notes : http://www.nffund.com/new/fundproduct/?action=searchjjfl&fundcode=160127&index=2
         * price : 1.0640
         * last_chg_dt : 2019-03-18
         * b_gangan : 1.899
         * base_lower_recalc_rt : 43.21%
         * base_est_dis_rt : buy
         * left_year : 永续
         * abrate : 5:5
         * base_est_dis_rt_tip :
         */

        @SerializedName("base_fund_id")
        public String baseFundId;
        @SerializedName("base_fund_nm")
        public String baseFundNm;
        @SerializedName("base_fund_py")
        public String baseFundPy;
        @SerializedName("active_fl")
        public String activeFl;
        @SerializedName("mtrade")
        public String mtrade;
        @SerializedName("market")
        public String market;
        @SerializedName("mflag")
        public String mflag;
        @SerializedName("fund_company_nm")
        public String fundCompanyNm;
        @SerializedName("fund_manager")
        public String fundManager;
        @SerializedName("issue_dt")
        public String issueDt;
        @SerializedName("maturity_dt")
        public String maturityDt;
        @SerializedName("list_dt")
        public String listDt;
        @SerializedName("manage_fee")
        public String manageFee;
        @SerializedName("index_id")
        public String indexId;
        @SerializedName("index_nm")
        public String indexNm;
        @SerializedName("upper_recalc_price")
        public String upperRecalcPrice;
        @SerializedName("lower_recalc_price")
        public String lowerRecalcPrice;
        @SerializedName("asset_ratio")
        public String assetRatio;
        @SerializedName("fully")
        public String fully;
        @SerializedName("a_ratio")
        public int aRatio;
        @SerializedName("b_ratio")
        public int bRatio;
        @SerializedName("fund_descr")
        public String fundDescr;
        @SerializedName("money_cd")
        public String moneyCd;
        @SerializedName("pre_recacl_dt")
        public Object preRecaclDt;
        @SerializedName("next_recalc_dt")
        public String nextRecalcDt;
        @SerializedName("next_recalc_dt2")
        public Object nextRecalcDt2;
        @SerializedName("fundA_id")
        public String fundAId;
        @SerializedName("fundA_nm")
        public String fundANm;
        @SerializedName("fundA_py")
        public String fundAPy;
        @SerializedName("coupon_descr")
        public String couponDescr;
        @SerializedName("coupon_descr_s")
        public String couponDescrS;
        @SerializedName("coupon")
        public String coupon;
        @SerializedName("coupon_next")
        public String couponNext;
        @SerializedName("coupon_next2")
        public Object couponNext2;
        @SerializedName("fundB_id")
        public String fundBId;
        @SerializedName("fundB_nm")
        public String fundBNm;
        @SerializedName("fundB_py")
        public String fundBPy;
        @SerializedName("lower_recalc_comment")
        public String lowerRecalcComment;
        @SerializedName("a_amount")
        public Object aAmount;
        @SerializedName("a_amount_increase_rt")
        public Object aAmountIncreaseRt;
        @SerializedName("status_cd")
        public String statusCd;
        @SerializedName("recalc_to")
        public Object recalcTo;
        @SerializedName("calc_info")
        public String calcInfo;
        /**
         * 申购费率
         */
        @SerializedName("apply_fee")
        public String applyFee;
        @SerializedName("apply_fee_tip")
        public String applyFeeTip;
        /**
         * 赎回费率
         */
        @SerializedName("redeem_fee")
        public String redeemFee;
        @SerializedName("redeem_fee_tip")
        public String redeemFeeTip;
        @SerializedName("min_apply_amount")
        public Object minApplyAmount;
        @SerializedName("notes")
        public String notes;
        /**
         * 母基净值
         */
        @SerializedName("price")
        public String price;
        @SerializedName("last_chg_dt")
        public String lastChgDt;
        @SerializedName("b_gangan")
        public String bGangan;
        @SerializedName("base_lower_recalc_rt")
        public String baseLowerRecalcRt;
        @SerializedName("base_est_dis_rt")
        public String baseEstDisRt;
        @SerializedName("left_year")
        public String leftYear;
        @SerializedName("abrate")
        public String abrate;
        @SerializedName("base_est_dis_rt_tip")
        public String baseEstDisRtTip;
    }

    @Override
    public String toString() {
        return cell.baseFundNm + ":" + id;
    }
}
