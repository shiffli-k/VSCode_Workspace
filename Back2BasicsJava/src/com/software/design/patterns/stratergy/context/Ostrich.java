package com.software.design.patterns.stratergy.context;

import com.software.design.patterns.stratergy.strats.BirdFlightStratergyNegative;

public class Ostrich extends Bird{

    public Ostrich(String nameOfOstrich){
        flightStrat = new BirdFlightStratergyNegative();
        nameOfBird = nameOfOstrich;
    }

    @Override
    public void whoAmI() {
        System.out.println("Name is "+nameOfBird+"Imma an Ostrich mate, I am tallaf and run fasta than ya car mate!");
    }

}
