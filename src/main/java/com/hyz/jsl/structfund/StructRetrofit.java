package com.hyz.jsl.structfund;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StructRetrofit {
    private StructRetrofit() {
    }

    public static StructService getStructService() {
        return Holder.structService;
    }

//    public static Call<MotherFundsResult> getMotherFund(){
//        return getStructService().getMotherFund();
//    }

    private static class Holder {
        private static StructService structService;

        static {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.jisilu.cn/")
                    .addConverterFactory(
                            GsonConverterFactory.create(gson)
                    )
                    .build();
            structService = retrofit.create(StructService.class);
        }
    }
}
