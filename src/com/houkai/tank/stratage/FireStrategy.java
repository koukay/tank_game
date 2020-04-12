package com.houkai.tank.stratage;

import com.houkai.tank.Tank;

import java.io.Serializable;

public interface FireStrategy extends Serializable {
    public void fire(Tank t);
}
