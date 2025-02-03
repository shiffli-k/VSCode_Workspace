package com.software.design.patterns.stratergy.strats;

public class BirdFlightStratergyNegative implements BirdFlyStratergy{

    @Override
    public void fly() {
        System.out.println("No way, I cant fly! I'm a flightless bird!");
    }

}
