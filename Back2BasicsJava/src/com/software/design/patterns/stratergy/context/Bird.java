package com.software.design.patterns.stratergy.context;

import com.software.design.patterns.stratergy.strats.BirdFlyStratergy;

public abstract class Bird {

    public String nameOfBird = "Generic Bird";

    BirdFlyStratergy flightStrat;

    public void setFlightStrat(BirdFlyStratergy flightStratergy) {
        this.flightStrat = flightStratergy;
    }

    public void doFly() {
        this.flightStrat.fly();
    }

    public abstract void whoAmI();

}
