package org.szh.demo.test;

public class TestClass implements InterfaceTest2{
    @Override
    public String[] getC() {
        return new String[0];
    }

    @Override
    public String getA() {
        return null;
    }

    @Override
    public String getB() {
        return null;
    }

    @Override
    public Integer getD() {
        return null;
    }
}
