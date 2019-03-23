package com.hyz.jsl.structfund;

import com.hyz.jsl.structfund.module.MotherFundsResult;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StructRetrofit {
    private StructRetrofit(){
    }

    public static StructService getStructService(){
        return Holder.structService;
    }

//    public static Call<MotherFundsResult> getMotherFund(){
//        return getStructService().getMotherFund();
//    }

    private static class Holder {
        private static StructService structService;
        static{
             Retrofit retrofit = new Retrofit.Builder()
                     .baseUrl("https://www.jisilu.cn/")
                     .addConverterFactory(
                             GsonConverterFactory.create()
                     )
                     .build();
             structService = retrofit.create(StructService.class);
        }
    }
}
