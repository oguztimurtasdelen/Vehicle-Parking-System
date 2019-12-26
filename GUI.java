import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public void buildScreen() {
        JMenu memembership,admin;
        JMenuItem m1,m2, a1, a2,a3;

        JFrame frameLogin = new JFrame("Vehicle Parking Booking System");
        frameLogin.getContentPane().setBackground(new Color(248, 148, 6));
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
        frameLogin.setBackground(new Color(44,62,80));
        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIMemberSignup().buildMemberSignup();
            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIMemberDelete().buildMemberDelete();
            }
        });
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIAdminLogin().buildAdminLogin();
            }
        });
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new GUIAdminSignup().buildAdminSignup();
            }
        });
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new GUIAdminDelete().buildAdminDelete();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new GUISubscribed().buildSubscribed();

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUINotSubscribed().buildNotSubscribed();
            }
        });
    }
}
