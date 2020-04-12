package com.houkai.tank;

public class TankFireEvent {
    Tank tank;
    public Tank getSource(){
        return tank;
    }

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }
}
