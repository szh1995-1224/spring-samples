package org.szh.demo;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class OkHttpClientInstanceFactory {
    public static OkHttpClient okHttpClient;

    static {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public OkHttpClient getInstance() {
        return okHttpClient;
    }
}
