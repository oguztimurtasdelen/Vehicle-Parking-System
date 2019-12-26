import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUINotSubscribed {
    public void buildNotSubscribed(){
        JFrame frameNotSubs = new JFrame("Not Subscribe");
        frameNotSubs.setSize(320,400);
        frameNotSubs.getContentPane().setBackground(new Color(248, 148, 6));

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

        JLabel lblNewLabel = new JLabel("Test");
        lblNewLabel.setBounds(90,330,120,40);
        frameNotSubs.getContentPane().add(lblNewLabel);
        //15dakika geri sayım
        Thread thread = new Thread();

        new Thread() {
            int counter = 900;
            public void run() {
                while(counter >= 0) {
                    if (counter >60){
                        counter--;
                        lblNewLabel.setText("Remain  "+(counter/60)+"  minutes");}
                    else
                        lblNewLabel.setText("Remain  "+counter--);
                    try{
                        Thread.sleep(1000);
                    } catch(Exception e) {}
                }
                frameNotSubs.hide();
            }
        }.start();



        JLabel Flabel2 = new JLabel("Check-in time                      Check-out time");
        JLabel Flabel = new JLabel("yyyy-mm-dd   hh:mm        yyyy-mm-dd   hh:mm");
        JTextField firstdatee = new JTextField();
        JTextField firsthour = new JTextField();
        JTextField seconddatee = new JTextField();
        JTextField secondhour = new JTextField();
        Flabel2.setBounds(20,180,300,20);
        firstdatee.setBounds(20,210,70,20);
        firsthour.setBounds(95,210,40,20);
        seconddatee.setBounds(160,210,70,20);
        secondhour.setBounds(235,210,40,20);
        Flabel.setBounds(20,230,300,20);
        frameNotSubs.add(Flabel2);
        frameNotSubs.add(Flabel);
        frameNotSubs.add(firstdatee);
        frameNotSubs.add(firsthour);
        frameNotSubs.add(seconddatee);
        frameNotSubs.add(secondhour);

        button.setBounds(30,280,120,40);
        frameNotSubs.add(button);
        frameNotSubs.setLocationRelativeTo(null);
        frameNotSubs.setLayout(null);
        frameNotSubs.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //değer girilmeyince devam etmemesi için

                if(txt[0].getText().equals("")|| txt[1].getText().equals("") || txt[2].getText().equals("") || txt[3].getText().equals(""))
                    JOptionPane.showMessageDialog(frameNotSubs,"Fill the void places");

                else {
                    int NotsubOption = JOptionPane.showConfirmDialog(frameNotSubs, "is available would you like to continue","",JOptionPane.YES_NO_OPTION);
                    if(NotsubOption == 0){
                        String card = JOptionPane.showInputDialog(frameNotSubs,"Enter card number");
                        if(card != null) {
                            JOptionPane.showMessageDialog(frameNotSubs, "Your appointment successfully completed");
                            frameNotSubs.hide();
                        }
                    }

                }
            }
        });
    }
}
