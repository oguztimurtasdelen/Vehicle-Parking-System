import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAdminLogin {
    public void buildAdminLogin(){
        JFrame frameLoginAdmin = new JFrame("Admin Login");
        frameLoginAdmin.setSize(450, 300);
        frameLoginAdmin.setLayout(null);
        frameLoginAdmin.getContentPane().setBackground(new Color(248, 148, 6));
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
                frameAdminPanel.getContentPane().setBackground(new Color(248, 148, 6));
                JTextField[] txt = new JTextField[5];
                //ikili array iflerli lokasyon ataması için kullandım
                JButton[][] btn = new JButton[5][10];
                for (int i = 0; i<5;i++)
                {
                    txt[i] = new JTextField();
                    txt[i].setBounds(950,180+(i*50),150,30);
                    frameAdminPanel.add(txt[i]);
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
                        frameAdminPanel.add(btn[i][k]);
                    }
                }
                frameAdminPanel.setBackground(new Color(44,62,80));
                frameAdminPanel.setLayout(null);
                frameAdminPanel.setLocationRelativeTo(null);
                frameAdminPanel.setVisible(true);
            }
        });
    }
}
