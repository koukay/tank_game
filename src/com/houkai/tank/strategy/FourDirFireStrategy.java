package com.houkai.tank.strategy;

import com.houkai.tank.*;

/**
 * 策略模式,四个方向打出子弹
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bx=t.x+Tank.WIDTH/2-Bullet.WIDTH/2;
        int by=t.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
        Dir[] dirs= Dir.values();
        for (Dir dir : dirs) {
            t.tf.gf.createBullet(bx, by, dir,t.group,t.tf);
        }
        if (t.group==Group.GOOD)new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
