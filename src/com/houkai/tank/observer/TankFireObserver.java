package com.houkai.tank.observer;

import com.houkai.tank.TankFireEvent;

import java.io.Serializable;

public interface TankFireObserver extends Serializable {
    void actionOnFire(TankFireEvent e);
}
