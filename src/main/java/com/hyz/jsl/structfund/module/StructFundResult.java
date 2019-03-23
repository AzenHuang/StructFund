package com.hyz.jsl.structfund.module;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StructFundResult<T> {
    @SerializedName("page")
    public int page;
    @SerializedName("rows")
    public List<T> rows;
}
