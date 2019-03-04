package day1.com.rjxy.bean.state;

import day1.com.rjxy.bean.Hero;

import javax.swing.*;

/**
 * Created by lele on 18-1-11.
 * ¾ßÌå×´Ì¬£º¹Ø¿¨£±
 */
public class Hero1stState extends HeroState {

    public Hero1stState(Hero hero){
            this.hero = hero;
            hero.setLevel(1);
    }

    public Hero1stState(HeroState state){
        hero = state.hero;
    }

    @Override
    public void check() {
        int score = hero.getScore();
        if(score>1000){
            JOptionPane.showMessageDialog(null,"Congratulations Level2!");
            hero.setCurrentState(new Hero2ndState(this));

        }
    }


}
