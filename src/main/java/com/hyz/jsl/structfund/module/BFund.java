package com.hyz.jsl.structfund.module;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFund extends StructFund {

    /**
     * id : 150032 //分级A的id!!!
     * cell : {"fundb_base_fund_id":"160718","funda_id":"150032","funda_name":"多利优先","fundb_id":"150033","fundb_name":"多利进取","status_cd":"N","recalc_to":null,"calc_info":"基金定折 2019-03-27 为折算基准日，暂停申购、赎回、转托管及配对转换业务，AB正常交易 2019-03-28 暂停申购、赎回、转托管及配对转换业务，A停牌一天，B参与折算则停牌 2019-03-29 恢复申购、赎回、转托管及配对转换业务，开盘恢复交易","upper_recalc_price":null,"maturity_dt":null,"coupon_descr":"固定5.0%","coupon_descr_s":"5.0%","coupon":"5.000","manage_fee":"0.900","funda_current_price":"1.024","funda_upper_price":"1.123","funda_lower_price":"0.919","funda_increase_rt":"0.29","fundb_current_price":"0.915","fundb_upper_price":"0.928","fundb_lower_price":"0.760","fundb_increase_rt":"8.41%","fundb_volume":"1.94","fundb_value":"0.8088","fundb_nav_dt":"2019-03-22","fundm_value":"1.0012","fundm_nav_dt":"2019-03-22","fundb_discount_rt":"13.13%","fundb_price_leverage_rt":"5.471","fundb_net_leverage_rt":"6.189","fundb_capital_rasising_rt":"5.99%","fundb_lower_recalc_rt":"8.17%","fundb_upper_recalc_rt":"-","fundb_left_year":"永续","b_est_val":"0.804","fundb_index_id":"000923","fundb_index_name":"债券总指","fundb_index_increase_rt":"0.00%","funda_ratio":8,"fundb_ratio":2,"fundb_base_price":"1.0012","fundb_base_est_dis_rt":"buy","last_time":"15:00:03","fundB_amount":"562","fundB_amount_increase":"0","fundB_amount_increase_rt":"0.06%","fundb_discount_rt2":"2.66","owned":0,"asset_ratio_last":"433%","fundb_unit_capital_rasising_rt":"1.34%","abrate":"8:2","fundb_base_est_dis_rt_tip":""}
     */

    @SerializedName("cell")
    public CellBean cell;

    public static class CellBean {
        /**
         * fundb_base_fund_id : 160718
         * funda_id : 150032
         * funda_name : 多利优先
         * fundb_id : 150033
         * fundb_name : 多利进取
         * status_cd : N
         * recalc_to : null
         * calc_info : 基金定折 2019-03-27 为折算基准日，暂停申购、赎回、转托管及配对转换业务，AB正常交易 2019-03-28 暂停申购、赎回、转托管及配对转换业务，A停牌一天，B参与折算则停牌 2019-03-29 恢复申购、赎回、转托管及配对转换业务，开盘恢复交易
         * upper_recalc_price : null
         * maturity_dt : null
         * coupon_descr : 固定5.0%
         * coupon_descr_s : 5.0%
         * coupon : 5.000
         * manage_fee : 0.900
         * funda_current_price : 1.024
         * funda_upper_price : 1.123
         * funda_lower_price : 0.919
         * funda_increase_rt : 0.29
         * fundb_current_price : 0.915
         * fundb_upper_price : 0.928
         * fundb_lower_price : 0.760
         * fundb_increase_rt : 8.41%
         * fundb_volume : 1.94
         * fundb_value : 0.8088
         * fundb_nav_dt : 2019-03-22
         * fundm_value : 1.0012
         * fundm_nav_dt : 2019-03-22
         * fundb_discount_rt : 13.13%
         * fundb_price_leverage_rt : 5.471
         * fundb_net_leverage_rt : 6.189
         * fundb_capital_rasising_rt : 5.99%
         * fundb_lower_recalc_rt : 8.17%
         * fundb_upper_recalc_rt : -
         * fundb_left_year : 永续
         * b_est_val : 0.804
         * fundb_index_id : 000923
         * fundb_index_name : 债券总指
         * fundb_index_increase_rt : 0.00%
         * funda_ratio : 8
         * fundb_ratio : 2
         * fundb_base_price : 1.0012
         * fundb_base_est_dis_rt : buy
         * last_time : 15:00:03
         * fundB_amount : 562
         * fundB_amount_increase : 0
         * fundB_amount_increase_rt : 0.06%
         * fundb_discount_rt2 : 2.66
         * owned : 0
         * asset_ratio_last : 433%
         * fundb_unit_capital_rasising_rt : 1.34%
         * abrate : 8:2
         * fundb_base_est_dis_rt_tip :
         */

        @SerializedName("fundb_base_fund_id")
        public String fundbBaseFundId;
        @SerializedName("funda_id")
        public String fundaId;
        @SerializedName("funda_name")
        public String fundaName;
        @SerializedName("fundb_id")
        public String fundbId;
        @SerializedName("fundb_name")
        public String fundbName;
        @SerializedName("status_cd")
        public String statusCd;
        @SerializedName("recalc_to")
        public Object recalcTo;
        @SerializedName("calc_info")
        public String calcInfo;
        @SerializedName("upper_recalc_price")
        public Object upperRecalcPrice;
        @SerializedName("maturity_dt")
        public Object maturityDt;
        @SerializedName("coupon_descr")
        public String couponDescr;
        @SerializedName("coupon_descr_s")
        public String couponDescrS;
        @SerializedName("coupon")
        public String coupon;
        @SerializedName("manage_fee")
        public String manageFee;
        @SerializedName("funda_current_price")
        public String fundaCurrentPrice;
        @SerializedName("funda_upper_price")
        public String fundaUpperPrice;
        @SerializedName("funda_lower_price")
        public String fundaLowerPrice;
        @SerializedName("funda_increase_rt")
        public String fundaIncreaseRt;
        @SerializedName("fundb_current_price")
        public String fundbCurrentPrice;
        @SerializedName("fundb_upper_price")
        public String fundbUpperPrice;
        @SerializedName("fundb_lower_price")
        public String fundbLowerPrice;
        @SerializedName("fundb_increase_rt")
        public String fundbIncreaseRt;
        @SerializedName("fundb_volume")
        public String fundbVolume;
        @SerializedName("fundb_value")
        /**
         * B基净值
         */
        public String fundbValue;
        @SerializedName("fundb_nav_dt")
        public String fundbNavDt;
        @SerializedName("fundm_value")
        public String fundmValue;
        @SerializedName("fundm_nav_dt")
        public String fundmNavDt;
        /**
         * B基溢价率
         */
        @SerializedName("fundb_discount_rt")
        public String fundbDiscountRt;
        @SerializedName("fundb_price_leverage_rt")
        public String fundbPriceLeverageRt;
        @SerializedName("fundb_net_leverage_rt")
        public String fundbNetLeverageRt;
        @SerializedName("fundb_capital_rasising_rt")
        public String fundbCapitalRasisingRt;
        @SerializedName("fundb_lower_recalc_rt")
        public String fundbLowerRecalcRt;
        @SerializedName("fundb_upper_recalc_rt")
        public String fundbUpperRecalcRt;
        @SerializedName("fundb_left_year")
        public String fundbLeftYear;

        @SerializedName("b_est_val")
        /**
         * B基估值
         */
        public String bEstVal;
        @SerializedName("fundb_index_id")
        public String fundbIndexId;
        @SerializedName("fundb_index_name")
        public String fundbIndexName;
        @SerializedName("fundb_index_increase_rt")
        public String fundbIndexIncreaseRt;
        @SerializedName("funda_ratio")
        public int fundaRatio;
        @SerializedName("fundb_ratio")
        public int fundbRatio;
        @SerializedName("fundb_base_price")
        public String fundbBasePrice;
        @SerializedName("fundb_base_est_dis_rt")
        public String fundbBaseEstDisRt;
        @SerializedName("last_time")
        public String lastTime;
        @SerializedName("fundB_amount")
        public String fundBAmount;
        @SerializedName("fundB_amount_increase")
        public String fundBAmountIncrease;
        @SerializedName("fundB_amount_increase_rt")
        public String fundBAmountIncreaseRt;
        @SerializedName("fundb_discount_rt2")
        public String fundbDiscountRt2;
        @SerializedName("owned")
        public int owned;
        @SerializedName("asset_ratio_last")
        public String assetRatioLast;
        @SerializedName("fundb_unit_capital_rasising_rt")
        public String fundbUnitCapitalRasisingRt;
        @SerializedName("abrate")
        public String abrate;
        @SerializedName("fundb_base_est_dis_rt_tip")
        public String fundbBaseEstDisRtTip;
    }

    @Override
    public String toString() {
        return cell.fundbName + ":" + id;
    }

    public static Map<String, BFund> listToMap(List<BFund> list){
        Map<String, BFund> map = new HashMap<>();
        for (BFund BFund : list) {
            map.put(BFund.cell.fundbId, BFund);
        }
        return map;
    }
}
