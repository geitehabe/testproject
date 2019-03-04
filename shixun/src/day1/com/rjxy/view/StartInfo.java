package day1.com.rjxy.view;

import day1.com.rjxy.util.DB_Operator;

import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lele on 18-1-10.
 * 显示用户信息
 */
public class StartInfo implements ActionListener{
    JFrame frame;
    JButton button_start,button_end;
    JTextField jt1,jt2,jt3;
    JLabel jl1,jl2,jl3;
    JPanel panel;
    Dimension dim;
    String name;
    public StartInfo(Dimension dim,String name) {
        frame = new JFrame("飞机大战－用户信息");
        panel = new JPanel();
        button_end = new JButton("退出游戏");
        button_start = new JButton("开始游戏");

        //获取信息
        String info = new DB_Operator().grap(name);
        String[] test = info.split(" ");

        jl1 = new JLabel("等级");
        jl2 = new JLabel("成绩");
        jl3 = new JLabel("在线");
        jt1 = new JTextField(test[0],20);
        jt2 = new JTextField(test[1],20);
        jt3 = new JTextField(test[2],20);

        //监听当前对象
        button_start.addActionListener(this);
        button_end.addActionListener(this);

        frame.setLayout(new GridLayout(1,0,10,10));

        panel.add(jt1);
        panel.add(jl1);
        panel.add(jt2);
        panel.add(jl2);
        panel.add(jt3);
        panel.add(jl3);

        panel.add(button_start);
        panel.add(button_end);
        frame.add(panel);//面板添加到窗体上

        //使窗口大小为300x400，且位于屏幕中央
        frame.setBounds((dim.width - 300) / 2, (dim.height - 400) / 2, 300, 400);
        //设置窗体为可见
        frame.setVisible(true);
        //设置大小不可改变
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体的关闭方式

        this.dim = dim;
        this.name = name;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==button_end){//程序退出
            System.exit(0);
        }
        if(e.getSource()==button_start){

            frame.setVisible(false);
            new Started(dim,name);
        }



    }


}
