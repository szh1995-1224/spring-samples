package org.szh.demo;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.FactoryBean;
import sun.net.www.http.HttpClient;

import java.util.concurrent.TimeUnit;

/**
 * 注意 这个命名是有规则的 一般为xxxFactoryBean ,看到这个名字 就知道最终生成的bean是xxx
 */
public class OkHttpClientFactoryBean implements FactoryBean<OkHttpClient> {

    /**
     * 返回具体的实例对象
     *
     * @return
     * @throws Exception
     */
    @Override
    public OkHttpClient getObject() throws Exception {
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public Class<?> getObjectType() {
        return HttpClient.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
