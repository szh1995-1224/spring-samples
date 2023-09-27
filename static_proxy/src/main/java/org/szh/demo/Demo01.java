package org.szh.demo;

/**
 * java 23种设计模式中的代理模式  静态代理 中介代理了房东
 */
public class Demo01 {
    public static void main(String[] args) {
        LandLord landLord = new LandLord();
        HouseAgent houseAgent = new HouseAgent(landLord);
        houseAgent.rent();
    }
}
