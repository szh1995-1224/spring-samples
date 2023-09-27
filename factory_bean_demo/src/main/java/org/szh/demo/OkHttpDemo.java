package org.szh.demo;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class OkHttpDemo {

    public static void main(String[] args) throws InterruptedException {
        //通过建造者模式去创建一个 OkHttpClient 对象
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        //构建一个具体的请求
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .get()
                .build();

        Call call = client.newCall(request);
        //CountDownLatch初始化一个全局计数器
        CountDownLatch countDownLatch = new CountDownLatch(1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //减一
                countDownLatch.countDown();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //减一
                countDownLatch.countDown();
                System.out.println("response.body().string() = " + response.body().string());
            }
        });
        //会判断计数器是否为0  如果为0才会执行后续代码 否则就暂停在这里
        countDownLatch.await();
        //Thread.sleep(5000);
    }
}
