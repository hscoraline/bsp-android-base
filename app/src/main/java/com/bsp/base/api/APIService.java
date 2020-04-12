package com.bsp.base.api;

import com.bsp.base.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    private static Retrofit retrofit;

    public static ClientInterface getClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);
        builder.addInterceptor(loggingInterceptor);
        builder.addInterceptor(Authorization.Instance());

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().
                    baseUrl(BuildConfig.BASE_URL).
                    client(builder.build()).
                    addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }

        return retrofit.create(ClientInterface.class);
    }
}
