package com.hyz.jsl.structfund;

import com.hyz.jsl.structfund.module.MotherFundsResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main {
    public static void main(String[] args) {
        Call<MotherFundsResult> motherFundsResultCall = StructRetrofit.getStructService().getMotherFund();
        motherFundsResultCall.enqueue(new Callback<MotherFundsResult>() {
            @Override
            public void onResponse(Call<MotherFundsResult> call, Response<MotherFundsResult> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<MotherFundsResult> call, Throwable t) {
                t.printStackTrace();
                System.out.println(t);
            }
        });
    }


}
