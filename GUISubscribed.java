import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISubscribed {
    public void buildSubscribed(){
        JFrame frameSubs = new JFrame("Subscribe");
        frameSubs.setSize(450, 300);
        frameSubs.setLayout(null);
        frameSubs.getContentPane().setBackground(new Color(248, 148, 6));
        Component label1 = new Label("Subscriber number");
        Component label2 = new Label("License number ");
        Component textField1 = new TextField();
        Component textField2 = new TextField();
        Component Subsbutton = new Button("Login");
        label1.setBounds(20,40,120,50);
        label2.setBounds(20,100,120,50);
        textField1.setBounds(140,50,120,30);
        textField2.setBounds(140,110,120,30);
        Subsbutton.setBounds(105,180,90,30);
        frameSubs.add(Subsbutton);
        frameSubs.add(textField1);
        frameSubs.add(textField2);
        frameSubs.add(label1);
        frameSubs.add(label2);
        frameSubs.setLocationRelativeTo(null);
        frameSubs.setVisible(true);
        ((Button) Subsbutton).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameGarage = new JFrame("Garage");
                frameGarage.getContentPane().setBackground(new Color(248, 148, 6));
                frameGarage.setSize(1200,1200);
                JButton buttonRnd = new JButton("Give me random");
                JButton buttonUpdate = new JButton("Update");
                buttonRnd.setBounds(1000,270,150,30);
                buttonUpdate.setBounds(1000,320,150,30);
                frameGarage.add(buttonUpdate);
                frameGarage.add(buttonRnd);
                JButton[][] btn = new JButton[5][10];
                for (int i = 0; i<5;i++)
                {
                    for (int k = 0; k<10;k++)
                    {
                        btn[i][k] =new JButton("A"+i+(k+1));
                        if (i==0) {
                            btn[i][k].setText("A" + (k + 1));
                            btn[i][k].setBounds(0, 180 + (k * 60), 150, 50);
                        }
                        if ((i==1))
                            btn[i][k].setBounds(0, 780, 150, 50);
                        if (i==1 && k!=0)
                            btn[i][k].setBounds(300, 240 + (k * 60), 150, 50);
                        if (i==2)
                            btn[i][k].setBounds(470, 300 + (k * 60), 150, 50);
                        if (i==2 && k==9)
                            btn[i][k].setBounds(750, 180, 150, 50);
                        if (i==3)
                            btn[i][k].setBounds(750, 240 + (k * 60), 150, 50);
                        if (i==4) {
                            btn[i][k].setBounds(150 + (k * 60), 20, 58, 150);
                            btn[i][k].setFont(new Font(null,0,13));
                        }
                        if (k==9)
                            btn[i][k].setText("A"+(i+1)+"0");
                        frameGarage.add(btn[i][k]);
                        btn[i][k].setBackground(new Color(25,234,0));
                    }
                }
                frameGarage.setLayout(null);
                frameGarage.setLocationRelativeTo(null);
                frameGarage.setVisible(true);
                buttonRnd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frameGarage,"is yours.");
                    }
                });
                buttonUpdate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frameMemberUpdate = new JFrame("Update Membership");
                        frameMemberUpdate.setSize(450,400);
                        frameMemberUpdate.getContentPane().setBackground(new Color(248, 148, 6));
                        frameMemberUpdate.setBackground(new Color(44,62,80));
                        JLabel lbl[] = new JLabel[6];
                        JTextField txt[] = new JTextField[6];
                        for (int i = 0; i<6;i++)
                        {
                            lbl[i] = new JLabel();
                            txt[i] = new JTextField();
                            lbl[i].setBounds(30,20+(i*40),150,20);
                            txt[i].setBounds(160,20+(i*40),120,30);
                            frameMemberUpdate.add(txt[i]);
                            frameMemberUpdate.add(lbl[i]);
                        }
                        lbl[0].setText("Subscriber number");
                        lbl[1].setText("License number");
                        lbl[2].setText("Name and surname");
                        lbl[3].setText("Phone");
                        lbl[4].setText("E-mail");
                        lbl[5].setText("Credit card no");
                        JButton buttonUpdate = new JButton("Update");
                        buttonUpdate.setBounds(30,280,120,40);
                        frameMemberUpdate.add(buttonUpdate);
                        frameMemberUpdate.setLocationRelativeTo(null);
                        frameMemberUpdate.setLayout(null);
                        frameMemberUpdate.setVisible(true);
                        buttonUpdate.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(frameMemberUpdate,"Successfuly Updated");
                                frameMemberUpdate.hide();
                            }
                        });
                    }
                });
            }
        });
    }
}
