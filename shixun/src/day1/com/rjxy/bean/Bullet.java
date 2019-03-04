package day1.com.rjxy.bean;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lele on 18-1-8.
 */
public class Bullet {
    private int x;
    private int y;
    private int r;
    private Image buImg = new ImageIcon("img/fire.png").getImage();

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g){
        g.drawImage(buImg,x,y,null);
    }


}
