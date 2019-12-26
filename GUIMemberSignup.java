import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMemberSignup {
    public void buildMemberSignup() {
        JFrame frameMemberSignup = new JFrame("Sign up Membership");
        frameMemberSignup.setSize(450,400);
        frameMemberSignup.getContentPane().setBackground(new Color(248, 148, 6));
        frameMemberSignup.setBackground(new Color(44,62,80));
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
}
