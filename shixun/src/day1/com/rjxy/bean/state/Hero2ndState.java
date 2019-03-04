package day1.com.rjxy.bean.state;

import javax.swing.*;

/**
 * Created by lele on 18-1-11.
 * ¾ßÌå×´Ì¬£º¹Ø¿¨£²
 */
public class Hero2ndState extends HeroState {



    public Hero2ndState(HeroState state){
        hero = state.hero;

        hero.setLevel(2);
    }
    @Override
    public void check() {

        if(hero.getScore()>2000){
            JOptionPane.showMessageDialog(null,"Congratulations Level3£¡");
            hero.setCurrentState(new Hero3rdState(this));


        }

    }
}
