package com.houkai.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public  static BufferedImage goodTankL, goodTankU,goodTankR,goodTankD,goodTankLU,goodTankLD,goodTankRU,goodTankRD;
    public  static BufferedImage badTankL, badTankU,badTankR,badTankD;
    public  static BufferedImage bulletL, bulletU,bulletR,bulletD,bulletLU,bulletLD,bulletRU,bulletRD;
    public  static BufferedImage[] explores=new BufferedImage[16];
    static {
        try {
            goodTankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/GoodTank1.png"));
            goodTankL=ImageUtil.rotateImage(goodTankU, -90);
            goodTankLU=ImageUtil.rotateImage(goodTankU, -45);
            goodTankLD=ImageUtil.rotateImage(goodTankU, -135);
            goodTankR=ImageUtil.rotateImage(goodTankU, 90);
            goodTankRU=ImageUtil.rotateImage(goodTankU, 45);
            goodTankRD=ImageUtil.rotateImage(goodTankU, 135);
            goodTankD=ImageUtil.rotateImage(goodTankU, 180);

            badTankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/BadTank1.png"));
            badTankL=ImageUtil.rotateImage(badTankU, -90);
            badTankR=ImageUtil.rotateImage(badTankU, 90);
            badTankD=ImageUtil.rotateImage(badTankU, 180);

            bulletU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletU.gif"));
            bulletL= ImageUtil.rotateImage(bulletU, -90);
            bulletLU= ImageUtil.rotateImage(bulletU, -45);
            bulletLD= ImageUtil.rotateImage(bulletU, -135);
            bulletR=ImageUtil.rotateImage(bulletU, 90);
            bulletRU=ImageUtil.rotateImage(bulletU, 45);
            bulletRD=ImageUtil.rotateImage(bulletU, 135);
            bulletD=ImageUtil.rotateImage(bulletU, 180);
            for (int i = 0; i < 16; i++) {
                explores[i]=ImageIO.read(ResourceMgr.class.getClassLoader().
                        getResourceAsStream("image/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
