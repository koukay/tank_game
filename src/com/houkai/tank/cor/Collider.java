package com.houkai.tank.cor;

import com.houkai.tank.GameObject;

public interface Collider {
    boolean collide(GameObject o1,GameObject o2);
}
