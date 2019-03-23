package com.hyz.jsl.structfund;

import com.hyz.jsl.structfund.module.MotherFundsResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface StructService {
    @GET("/data/sfnew/fundm_list")
    Call<MotherFundsResult> getMotherFund();
}
