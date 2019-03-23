package com.hyz.jsl.structfund;

import com.hyz.jsl.structfund.module.AFund;
import com.hyz.jsl.structfund.module.BFund;
import com.hyz.jsl.structfund.module.MotherFund;
import com.hyz.jsl.structfund.module.StructFundResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface StructService {
    @GET("/data/sfnew/fundm_list/")
    Call<StructFundResult<MotherFund>> getMotherFund();

    @GET("/data/sfnew/funda_list/")
    Call<StructFundResult<AFund>> getAFund();

    @GET("/data/sfnew/fundb_list/")
    Call<StructFundResult<BFund>> getBFund();
}
