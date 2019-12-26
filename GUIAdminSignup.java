import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAdminSignup {
    public void buildAdminSignup(){
        JFrame frameAdminSignup = new JFrame("Sign up as admin");
        frameAdminSignup.setSize(320,400);
        frameAdminSignup.getContentPane().setBackground(new Color(248, 148, 6));
        JLabel lbl[] = new JLabel[5];
        JTextField txt[] = new JTextField[5];
        //tek tek yazmamak için for döngüsüyle array oluşturdum
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
}
