package com.houkai.tank.stratage;


import com.houkai.tank.*;
import com.houkai.tank.decorator.RectDecorator;
import com.houkai.tank.decorator.TailDecorator;
import com.houkai.tank.stratage.FireStrategy;

/**
 * 默认策略模式
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bx=t.x+Tank.WIDTH/2- Bullet.WIDTH/2;
        int by=t.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
      /*  GameModel.getInstance().add(
                new RectDecorator(
                        new TailDecorator(
                                new Bullet(bx, by, t.dir,t.group)
                        )
                )
        );*/
        new Bullet(bx, by, t.dir,t.group);
        if (t.group== Group.GOOD)new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
