package day1.com.rjxy.view;

import day1.com.rjxy.util.DB_Operator;

import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lele on 18-1-10.
 * ��ʾ�û���Ϣ
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
        frame = new JFrame("�ɻ���ս���û���Ϣ");
        panel = new JPanel();
        button_end = new JButton("�˳���Ϸ");
        button_start = new JButton("��ʼ��Ϸ");

        //��ȡ��Ϣ
        String info = new DB_Operator().grap(name);
        String[] test = info.split(" ");

        jl1 = new JLabel("�ȼ�");
        jl2 = new JLabel("�ɼ�");
        jl3 = new JLabel("����");
        jt1 = new JTextField(test[0],20);
        jt2 = new JTextField(test[1],20);
        jt3 = new JTextField(test[2],20);

        //������ǰ����
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
        frame.add(panel);//�����ӵ�������

        //ʹ���ڴ�СΪ300x400����λ����Ļ����
        frame.setBounds((dim.width - 300) / 2, (dim.height - 400) / 2, 300, 400);
        //���ô���Ϊ�ɼ�
        frame.setVisible(true);
        //���ô�С���ɸı�
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĺرշ�ʽ

        this.dim = dim;
        this.name = name;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==button_end){//�����˳�
            System.exit(0);
        }
        if(e.getSource()==button_start){

            frame.setVisible(false);
            new Started(dim,name);
        }



    }


}
