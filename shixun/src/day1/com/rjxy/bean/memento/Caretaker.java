package day1.com.rjxy.bean.memento;

import day1.com.rjxy.bean.Memento;

/**
 * Created by lele on 18-1-12.
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento(){
        return memento;
    }

    public void setMemento(Memento memento){
        this.memento = memento;
    }
}
