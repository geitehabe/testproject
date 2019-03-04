package day1.com.rjxy.bean;

/**
 * Created by lele on 18-1-12.
 */
public class Memento {
    int level;
    int grade;
    int time = 20;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }



    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    Memento(int level,int grade){
        this.grade = grade;
        this.level = level;
    }
}
