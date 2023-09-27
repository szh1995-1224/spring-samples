package org.szh.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

public class GsonDemo {
    public static void main(String[] args) {
        Gson gson = new Gson();
        User user = new User("孙志昊", 27,new Date());
        String s = gson.toJson(user);
        System.out.println("s = " + s);
        Gson gson1 = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String s1 = gson1.toJson(user);
        System.out.println("s1 = " + s1);
    }
}
