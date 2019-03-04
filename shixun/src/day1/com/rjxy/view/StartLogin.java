package day1.com.rjxy.view;

import day1.com.rjxy.util.DB_Operator;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by lele on 18-1-8.
 * ��ʼ���桡��������ȫ���������
 */
public class StartLogin implements ActionListener {
    JFrame frame;
    JButton button_start,button_end;
    JTextField jt1,jt2;
    JLabel jl1,jl2;
    JPanel panel;
    Dimension dim;

    public StartLogin(){

    }
    public StartLogin(Dimension dim) {
        frame = new JFrame("�ɻ���ս����½");
        panel = new JPanel();
        button_end = new JButton("�ر�");
        button_start = new JButton("��½");

        jl1 = new JLabel("user");
        jl2 = new JLabel("word");
        jt1 = new JTextField(20);
        jt2 = new JTextField(20);

        //������ǰ����
        button_start.addActionListener(this);
        button_end.addActionListener(this);

        frame.setLayout(new GridLayout(2,0,10,10));

        panel.add(jl1);
        panel.add(jt1);
        panel.add(jl2);
        panel.add(jt2);
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
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==button_end){//�����˳�
            System.exit(0);
        }
        if(e.getSource()==button_start){
            //�ж������Ƿ�ƥ��
            String name = jt1.getText();
            String password = jt2.getText();
            boolean a = new DB_Operator().exit(name,password);
            if(a) {
                //����Ϸ����
                JOptionPane.showMessageDialog(null,"��½�ɹ���");
                frame.setVisible(false);
                new StartInfo(dim,name);//��������
            }else{
                JOptionPane.showMessageDialog(null,"�û������������");
            }
        }



    }


}
