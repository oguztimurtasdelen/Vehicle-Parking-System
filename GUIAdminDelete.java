import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAdminDelete {
    public void buildAdminDelete(){
        JFrame frameDeleteAdmin = new JFrame("Delete Admin Membership");
        frameDeleteAdmin.setSize(320, 320);
        frameDeleteAdmin.setLayout(null);
        frameDeleteAdmin.getContentPane().setBackground(new Color(248, 148, 6));
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
}
