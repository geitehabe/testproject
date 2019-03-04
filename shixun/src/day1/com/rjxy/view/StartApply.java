package day1.com.rjxy.view;

import day1.com.rjxy.util.DB_Operator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lele on 18-1-9.
 */
public class StartApply implements ActionListener{
    JFrame frame;
    JButton button_start,button_end;
    JTextField jt1,jt2;
    JLabel jl1,jl2;
    JPanel panel;
    Dimension dim;

    public StartApply(Dimension dim) {
        frame = new JFrame("飞机大战－注册");
        panel = new JPanel();
        button_end = new JButton("关闭");
        button_start = new JButton("注册");

        jl1 = new JLabel("user");
        jl2 = new JLabel("word");
        jt1 = new JTextField(20);
        jt2 = new JTextField(20);

        //监听当前对象
        button_start.addActionListener(this);
        button_end.addActionListener(this);

        panel.add(jl1);
        panel.add(jt1);
        panel.add(jl2);
        panel.add(jt2);
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
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==button_end){//程序退出
            System.exit(0);
        }
        if(e.getSource()==button_start){
            String name = jt1.getText();
            String password = jt2.getText();
            new DB_Operator().add(name,password);
            JOptionPane.showMessageDialog(null,"注册成功！");
            frame.setVisible(false);
            //切换到登陆
            new StartLogin(dim);//匿名对象
        }



    }
}
