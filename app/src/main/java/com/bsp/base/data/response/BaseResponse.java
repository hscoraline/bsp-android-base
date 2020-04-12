package com.bsp.base.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class BaseResponse<T> {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
