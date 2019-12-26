import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMemberDelete {
    public void buildMemberDelete(){
        JFrame frameDeleteMember = new JFrame("Delete Membership");
        frameDeleteMember.setSize(320, 320);
        frameDeleteMember.getContentPane().setBackground(new Color(248, 148, 6));
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
}
