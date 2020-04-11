package com.houkai.tank.stratage;


import com.houkai.tank.Audio;
import com.houkai.tank.Bullet;
import com.houkai.tank.Group;
import com.houkai.tank.Tank;
import com.houkai.tank.stratage.FireStrategy;

/**
 * 默认策略模式
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bx=t.x+Tank.WIDTH/2- Bullet.WIDTH/2;
        int by=t.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
        new Bullet(bx, by, t.dir,t.group);
        if (t.group== Group.GOOD)new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
