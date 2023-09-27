package org.szh.demo;

public class HouseAgent implements Rent{
    private LandLord landLord;

    public HouseAgent(LandLord landLord) {
        this.landLord = landLord;
    }
    @Override
    public void rent(){
        publishAd();
        landLord.rent();
        agentFee();
    }

    public void publishAd(){
        System.out.println("中介发广告");
    }

    public void agentFee() {
        System.out.println("中介收中介费");
    }
}
