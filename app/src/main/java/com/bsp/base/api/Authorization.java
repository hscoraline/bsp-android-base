package com.bsp.base.api;

import com.bsp.base.util.Constant;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@SuppressWarnings("FieldCanBeLocal")
public class Authorization implements Interceptor {

    private final String HEADER_SIG = "sig";
    private final String HEADER_TOKEN = "token";

    private static Authorization instance;

    private String sig = Constant.SIG;
    private String token = "";

    public static Authorization Instance() {
        if (instance == null) {
            instance = new Authorization();
        }
        return instance;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader(HEADER_SIG, sig)
                .addHeader(HEADER_TOKEN, token)
                .build();

        return chain.proceed(request);
    }

    public void updateToken(String token) {
        this.token = token;
    }

}
