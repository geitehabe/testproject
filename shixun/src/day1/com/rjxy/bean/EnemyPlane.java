package day1.com.rjxy.bean;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by lele on 18-1-8.
 */
public class EnemyPlane {
    private int x;
    private int y;
    private int r;
    private int speed;
    private int epNum;
    private Image epImg;

    private static ArrayList<EnemyPlane> eps = new ArrayList<EnemyPlane>();

    private static int index = 0;

    static {

        for(int i=0;i<15;i++){
            eps.add(new EnemyPlane());
        }
    }

    public static EnemyPlane getInstance(){
        if(index>=15){
            index = 0;
        }
        return  eps.get(index++);
    }

    private EnemyPlane(){
        changePlane();
    }

    public void changePlane(){
        epNum=(int)(Math.random()*15)+1;
        DecimalFormat df=new DecimalFormat("00");
        String ep=df.format(epNum);
        epImg=new ImageIcon("img/ep" +ep+".png").getImage();
    }

    public void paint(Graphics g){
        g.drawImage(epImg, x-r, y-r, null);

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

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEpNum() {
        return epNum;
    }

    public void setEpNum(int epNum) {
        this.epNum = epNum;
    }


}
