package com.company;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        JMenu memembership,admin;
        JMenuItem m1,m2, a1, a2,a3;

        JFrame frameLogin = new JFrame("Vehicle Parking Booking System");
        frameLogin.setSize(450,300);
        Button button1 = new Button("Subscribed");
        Button button2 = new Button("Not subscribed");
        JMenuBar menuBar = new JMenuBar();
        memembership = new JMenu("Membership   ");
        admin = new JMenu("  Admin     ");

        m1=new JMenuItem("Sign up");
        m2=new JMenuItem("Delete Membership");
        a1=new JMenuItem("Login");
        a2=new JMenuItem("Sign up");
        a3=new JMenuItem("Delete account");

        memembership.add(m1);
        memembership.add(m2);
        admin.add(a1);
        admin.add(a2);
        admin.add(a3);
        menuBar.add(memembership);
        menuBar.add(admin);
        button1.setBounds(80,150,120,40);
        button2.setBounds(230,150,120,40);
        frameLogin.add(button1);
        frameLogin.add(button2);

        frameLogin.setJMenuBar(menuBar);
        frameLogin.add(menuBar);
        frameLogin.setLocationRelativeTo(null);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setLayout(null);
        frameLogin.setVisible(true);
        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JFrame frameMemberSignup = new JFrame("Sign up Membership");
                frameMemberSignup.setSize(320,400);
                JLabel lbl[] = new JLabel[6];
                JTextField txt[] = new JTextField[6];
                for (int i = 0; i<6;i++)
                {
                    lbl[i] = new JLabel();
                    txt[i] = new JTextField();
                    lbl[i].setBounds(30,20+(i*40),150,20);
                    txt[i].setBounds(160,20+(i*40),120,30);
                    frameMemberSignup.add(txt[i]);
                    frameMemberSignup.add(lbl[i]);
                }
                lbl[0].setText("Subscriber number");
                lbl[1].setText("License number");
                lbl[2].setText("Name and surname");
                lbl[3].setText("Phone");
                lbl[4].setText("E-mail");
                lbl[5].setText("Credit card no");
                JButton buttonSignup = new JButton("Sign up");
                JButton button2 = new JButton("Cancel");
                buttonSignup.setBounds(30,280,120,40);
                button2.setBounds(160,280,120,40);
                frameMemberSignup.add(buttonSignup);
                frameMemberSignup.setLocationRelativeTo(null);
                frameMemberSignup.setLayout(null);
                frameMemberSignup.setVisible(true);
                buttonSignup.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frameMemberSignup,"Successful");
                        frameMemberSignup.hide();
                    }
                });
            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameDeleteMember = new JFrame("Delete Membership");
                frameDeleteMember.setSize(320, 320);
                frameDeleteMember.setLayout(null);
                Component label1 = new Label("Subscriber number");
                Component label2 = new Label("License number ");
                Component textFieldDelete1 = new TextField();
                Component textFieldDelete2 = new TextField();
                Component buttonDelete = new Button("Delete");
                label1.setBounds(20,40,120,50);
                label2.setBounds(20,100,120,50);
                textFieldDelete1.setBounds(140,50,120,30);
                textFieldDelete2.setBounds(140,110,120,30);
                buttonDelete.setBounds(105,180,90,30);
                frameDeleteMember.add(buttonDelete);
                frameDeleteMember.add(textFieldDelete1);
                frameDeleteMember.add(textFieldDelete2);
                frameDeleteMember.add(label1);
                frameDeleteMember.add(label2);
                frameDeleteMember.setLocationRelativeTo(null);
                frameDeleteMember.setVisible(true);
                ((Button) buttonDelete).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frameDeleteMember,"Successfully deleted");
                        frameDeleteMember.hide();
                    }
                });
            }
        });
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameLoginAdmin = new JFrame("Admin Login");
                frameLoginAdmin.setSize(320, 320);
                frameLoginAdmin.setLayout(null);
                Component label1 = new Label("No");
                Component label2 = new Label("Password ");
                Component textField1 = new TextField();
                Component textField2 = new JPasswordField();
                Component buttonLoginAdmin = new Button("Login");
                label1.setBounds(20,40,120,50);
                label2.setBounds(20,100,120,50);
                textField1.setBounds(140,50,120,30);
                textField2.setBounds(140,110,120,30);
                buttonLoginAdmin.setBounds(105,180,90,30);
                frameLoginAdmin.add(buttonLoginAdmin);
                frameLoginAdmin.add(textField1);
                frameLoginAdmin.add(textField2);
                frameLoginAdmin.add(label1);
                frameLoginAdmin.add(label2);
                frameLoginAdmin.setLocationRelativeTo(null);
                frameLoginAdmin.setVisible(true);
                ((Button) buttonLoginAdmin).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frameAdminPanel = new JFrame("Admin Panel");
                        frameAdminPanel.setSize(1200,1200);
                        JTextField[] txt = new JTextField[5];

                        JButton[][] btn = new JButton[5][10];
                        for (int i = 0; i<5;i++)
                        {
                            txt[i] = new JTextField();
                            txt[i].setBounds(950,180+(i*50),150,30);
                            frameAdminPanel.add(txt[i]);
                            for (int k = 0; k<10;k++)
                            {
                                btn[i][k] =new JButton("1"+i+k);
                                switch (i){
                                    case 0: btn[i][k].setBounds(0, 180+ (k * 60), 150, 50); break;
                                    case 3: btn[i][k].setBounds(750, 180 + (k * 60), 150, 50); break;
                                    case 4: btn[i][k].setBounds(150+(k*60), 20 , 50, 150); break;
                                }
                                if (i==1 && k!=0 && k!=1)
                                    btn[i][k].setBounds(300, 180 + (k * 60), 150, 50);
                                if (i==2 && k!=0 && k!=1)
                                    btn[i][k].setBounds(470, 180 + (k * 60), 150, 50);
                                frameAdminPanel.add(btn[i][k]);
                            }
                        }

                        frameAdminPanel.setLayout(null);
                        frameAdminPanel.setLocationRelativeTo(null);
                        frameAdminPanel.setVisible(true);
                    }
                });
            }
        });
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameAdminSignup = new JFrame("Sign up as admin");
                frameAdminSignup.setSize(320,400);
                JLabel lbl[] = new JLabel[5];
                JTextField txt[] = new JTextField[5];
                for (int i = 0; i<5;i++)
                {
                    lbl[i] = new JLabel();
                    txt[i] = new JTextField();
                    lbl[i].setBounds(30,20+(i*40),150,20);
                    txt[i].setBounds(160,20+(i*40),120,30);
                    frameAdminSignup.add(txt[i]);
                    frameAdminSignup.add(lbl[i]);
                }
                lbl[0].setText("Subscriber number");
                lbl[1].setText("License number");
                lbl[2].setText("Name and surname");
                lbl[3].setText("Phone");
                lbl[4].setText("E-mail");
                JButton buttonAdminSignup = new JButton("Sign up");
                JButton button2 = new JButton("Cancel");
                buttonAdminSignup.setBounds(30,280,120,40);
                button2.setBounds(160,280,120,40);
                frameAdminSignup.add(buttonAdminSignup);
                frameAdminSignup.setLocationRelativeTo(null);
                frameAdminSignup.setLayout(null);
                frameAdminSignup.setVisible(true);
                buttonAdminSignup.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frameAdminSignup,"Successful");
                        frameAdminSignup.hide();
                    }
                });
            }
        });
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameDeleteAdmin = new JFrame("Delete Admin Membership");
                frameDeleteAdmin.setSize(320, 320);
                frameDeleteAdmin.setLayout(null);
                Component label1 = new Label("No");
                Component label2 = new Label("Password ");
                Component textField1 = new TextField();
                Component textField2 = new JPasswordField();
                Component buttonDeleteAdmin = new Button("Delete");
                label1.setBounds(20,40,120,50);
                label2.setBounds(20,100,120,50);
                textField1.setBounds(140,50,120,30);
                textField2.setBounds(140,110,120,30);
                buttonDeleteAdmin.setBounds(105,180,90,30);
                frameDeleteAdmin.add(buttonDeleteAdmin);
                frameDeleteAdmin.add(textField1);
                frameDeleteAdmin.add(textField2);
                frameDeleteAdmin.add(label1);
                frameDeleteAdmin.add(label2);
                frameDeleteAdmin.setLocationRelativeTo(null);
                frameDeleteAdmin.setVisible(true);
                ((Button) buttonDeleteAdmin).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frameDeleteAdmin,"Successfully deleted");
                        frameDeleteAdmin.hide();
                    }
                });
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frameSubs = new JFrame("Subscribe");
                frameSubs.setSize(320, 320);
                frameSubs.setLayout(null);
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
                        frameGarage.setSize(1200,1200);
                        JButton buttonRnd = new JButton("Random");
                        buttonRnd.setBounds(1000,270,150,30);
                        frameGarage.add(buttonRnd);
                        JButton[][] btn = new JButton[5][10];
                        for (int i = 0; i<5;i++)
                        {
                            for (int k = 0; k<10;k++)
                            {
                                btn[i][k] =new JButton("1"+i+k);
                                if (i==0)
                                    btn[i][k].setBounds(0, 180+ (k * 60), 150, 50);
                                if (i==1 && k!=0 && k!=1)
                                    btn[i][k].setBounds(300, 180 + (k * 60), 150, 50);
                                if (i==2 && k!=0 && k!=1)
                                    btn[i][k].setBounds(470, 180 + (k * 60), 150, 50);
                                if (i==3)
                                    btn[i][k].setBounds(750, 180 + (k * 60), 150, 50);
                                if (i==4)
                                    btn[i][k].setBounds(150+(k*60), 20 , 50, 150);
                                frameGarage.add(btn[i][k]);
                            }
                        }
                        frameGarage.setLocationRelativeTo(null);
                        frameGarage.setVisible(true);
                        }
                });

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameNotSubs = new JFrame("Not Subscribe");
                frameNotSubs.setSize(320,400);

                JLabel lbl[] = new JLabel[4];
                JTextField txt[] = new JTextField[4];
                for (int i = 0; i<4;i++)
                {
                    lbl[i] = new JLabel();
                    txt[i] = new JTextField();
                    lbl[i].setBounds(30,20+(i*40),150,20);
                    txt[i].setBounds(160,20+(i*40),120,30);
                    frameNotSubs.add(txt[i]);
                    frameNotSubs.add(lbl[i]);
                }
                lbl[0].setText("License number");
                lbl[1].setText("Name and surname");
                lbl[2].setText("Phone");
                lbl[3].setText("E-mail");
                JButton button = new JButton("Parking");

                // TARİH SAAT PİCKER EKLENECEK



                button.setBounds(30,280,120,40);
                frameNotSubs.add(button);
                frameNotSubs.setLocationRelativeTo(null);
                frameNotSubs.setLayout(null);
                frameNotSubs.setVisible(true);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(txt[0].getText().equals("")|| txt[1].getText().equals("") || txt[2].getText().equals("") || txt[3].getText().equals(""))
                            JOptionPane.showMessageDialog(frameNotSubs,"Fill the void places");
                        else {
                            int NotsubOption = JOptionPane.showConfirmDialog(frameNotSubs, "is available would you like to continue","",JOptionPane.YES_NO_OPTION);
                            if(NotsubOption == 0){
                                String card = JOptionPane.showInputDialog(frameNotSubs,"Enter card number");


                            }

                        }
                    }
                });
            }
        });

    }
}
