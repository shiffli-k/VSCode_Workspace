package com.software.design.patterns.stratergy.context;

import com.software.design.patterns.stratergy.strats.BirdFlightStratergyPositive;

public class Pigeon extends Bird{

    public Pigeon(String nameOfPigeon){
        flightStrat = new BirdFlightStratergyPositive();
        nameOfBird = nameOfPigeon;
    }

    @Override
    public void whoAmI() {
        System.out.println("Ello mate me name is "+nameOfBird+", Imma Pigeon mate! I will do poo on ya car mate.");
    }

}
