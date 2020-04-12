package com.houkai.tank.observer;

import com.houkai.tank.Tank;
import com.houkai.tank.TankFireEvent;

public class TankFireHandler implements TankFireObserver{
    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank t = e.getSource();
        t.fire();
    }
}
