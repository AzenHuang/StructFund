package com.hyz.jsl.structfund.module;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AFund extends StructFund {

    /**
     * id : 150106
     * cell : {"owned":0,"funda_profit_rt_2020":"buy","coupon_descr_s":"7.0%","coupon_descr":"固定7.0%","calc_info":"基金公告： 自 2019-02-25 日起，限制大额(1千元，不含)申购与转换转入。 自 2019-03-08 日起，暂停场外转场内。","funda_volume":"225.15","funda_index_increase_rt":"0.00%","funda_lower_recalc_rt":"29.63%","fundb_upper_recalc_rt":"119.11%","funda_increase_rt":"0.00%","funda_left_year":"0.50","funda_base_fund_id":"161118","funda_id":"150106","funda_name":"中小A","last_time":"15:00:03","funda_current_price":"1.036","funda_nav_dt":"2019-03-22","funda_value":"1.0347","funda_discount_rt":"-0.13%","funda_coupon":"7.00","funda_coupon_next":"7.00","funda_profit_rt":"6.51%","funda_profit_rt_next":"6.508%","funda_index_id":"399005","funda_index_name":"中小板指","abrate":"5:5","base_est_dis_rt_tip":"","funda_base_est_dis_rt":"buy","fund_descr":"09/20，周年内最后一个工作日定折","left_recalc_year":"0.49315","status_cd":"N","next_recalc_dt":"2019-09-19","lower_recalc_profit_rt":"-","funda_amount_increase":"-5","funda_amount":41390,"funda_amount_increase_rt":"-0.01%","funda_base_est_dis_rt_t1":"-0.47%","funda_base_est_dis_rt_t2":"-0.38%","price_tips":"现价:1.036; 最后更新时间:15:00:03"}
     */


    @SerializedName("cell")
    public CellBean cell;

    public static class CellBean {
        /**
         * owned : 0
         * funda_profit_rt_2020 : buy
         * coupon_descr_s : 7.0%
         * coupon_descr : 固定7.0%
         * calc_info : 基金公告： 自 2019-02-25 日起，限制大额(1千元，不含)申购与转换转入。 自 2019-03-08 日起，暂停场外转场内。
         * funda_volume : 225.15
         * funda_index_increase_rt : 0.00%
         * funda_lower_recalc_rt : 29.63%
         * fundb_upper_recalc_rt : 119.11%
         * funda_increase_rt : 0.00%
         * funda_left_year : 0.50
         * funda_base_fund_id : 161118
         * funda_id : 150106
         * funda_name : 中小A
         * last_time : 15:00:03
         * funda_current_price : 1.036
         * funda_nav_dt : 2019-03-22
         * funda_value : 1.0347
         * funda_discount_rt : -0.13%
         * funda_coupon : 7.00
         * funda_coupon_next : 7.00
         * funda_profit_rt : 6.51%
         * funda_profit_rt_next : 6.508%
         * funda_index_id : 399005
         * funda_index_name : 中小板指
         * abrate : 5:5
         * base_est_dis_rt_tip :
         * funda_base_est_dis_rt : buy
         * fund_descr : 09/20，周年内最后一个工作日定折
         * left_recalc_year : 0.49315
         * status_cd : N
         * next_recalc_dt : 2019-09-19
         * lower_recalc_profit_rt : -
         * funda_amount_increase : -5
         * funda_amount : 41390
         * funda_amount_increase_rt : -0.01%
         * funda_base_est_dis_rt_t1 : -0.47%
         * funda_base_est_dis_rt_t2 : -0.38%
         * price_tips : 现价:1.036; 最后更新时间:15:00:03
         */

        @SerializedName("owned")
        public int owned;
        @SerializedName("funda_profit_rt_2020")
        public String fundaProfitRt2020;
        @SerializedName("coupon_descr_s")
        public String couponDescrS;
        @SerializedName("coupon_descr")
        public String couponDescr;
        @SerializedName("calc_info")
        public String calcInfo;
        /**
         * A基成交金额
         */
        @SerializedName("funda_volume")
        public String fundaVolume;
        /**
         * 指数涨幅
         */
        @SerializedName("funda_index_increase_rt")
        public String fundaIndexIncreaseRt;
        @SerializedName("funda_lower_recalc_rt")
        public String fundaLowerRecalcRt;
        @SerializedName("fundb_upper_recalc_rt")
        public String fundbUpperRecalcRt;
        @SerializedName("funda_increase_rt")
        public String fundaIncreaseRt;
        @SerializedName("funda_left_year")
        public String fundaLeftYear;
        @SerializedName("funda_base_fund_id")
        public String fundaBaseFundId;
        @SerializedName("funda_id")
        public String fundaId;
        @SerializedName("funda_name")
        public String fundaName;
        @SerializedName("last_time")
        public String lastTime;
        @SerializedName("funda_current_price")
        /**
         * A基当前价格
         */
        public String fundaCurrentPrice;
        @SerializedName("funda_nav_dt")
        public String fundaNavDt;
        @SerializedName("funda_value")
        /**
         * A基净值
         */
        public String fundaValue;
        @SerializedName("funda_discount_rt")
        /**
         * A基折价率
         */
        public String fundaDiscountRt;
        @SerializedName("funda_coupon")
        public String fundaCoupon;
        @SerializedName("funda_coupon_next")
        public String fundaCouponNext;
        @SerializedName("funda_profit_rt")
        public String fundaProfitRt;
        @SerializedName("funda_profit_rt_next")
        public String fundaProfitRtNext;
        @SerializedName("funda_index_id")
        public String fundaIndexId;
        @SerializedName("funda_index_name")
        public String fundaIndexName;
        @SerializedName("abrate")
        public String abrate;
        @SerializedName("base_est_dis_rt_tip")
        public String baseEstDisRtTip;
        @SerializedName("funda_base_est_dis_rt")
        public String fundaBaseEstDisRt;
        @SerializedName("fund_descr")
        public String fundDescr;
        @SerializedName("left_recalc_year")
        public String leftRecalcYear;
        @SerializedName("status_cd")
        public String statusCd;
        @SerializedName("next_recalc_dt")
        public String nextRecalcDt;
        @SerializedName("lower_recalc_profit_rt")
        public String lowerRecalcProfitRt;
        @SerializedName("funda_amount_increase")
        public String fundaAmountIncrease;
        @SerializedName("funda_amount")
        public int fundaAmount;
        @SerializedName("funda_amount_increase_rt")
        public String fundaAmountIncreaseRt;
        /**
         * 母基T-1整体溢价率
         */
        @SerializedName("funda_base_est_dis_rt_t1")
        public String fundaBaseEstDisRtT1;
        /**
         * 母基T-2整体溢价率
         */
        @SerializedName("funda_base_est_dis_rt_t2")
        public String fundaBaseEstDisRtT2;
        @SerializedName("price_tips")
        public String priceTips;
    }

    @Override
    public String toString() {
        return cell.fundaName + ":" + id;
    }

    public static Map<String, AFund> listToMap(List<AFund> list){
        Map<String, AFund> map = new HashMap<>();
        for (AFund AFund : list) {
            map.put(AFund.cell.fundaId, AFund);
        }
        return map;
    }
}
