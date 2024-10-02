package employeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame implements ActionListener {

    public Main(){
//        adding the frame background color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        adding the content ot the frame
        JLabel jLabel = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        jLabel.setBounds(80, 30, 1200, 60);
        jLabel.setFont(new Font("serif", Font.PLAIN, 60));
        jLabel.setForeground(Color.RED);
        add(jLabel);

//        adding images
        ImageIcon imageIcon_def = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image image_scale = imageIcon_def.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon((image_scale));

        JLabel image_jLabel = new JLabel(imageIcon);
        image_jLabel.setBounds(50, 100, 1080, 500);
        add(image_jLabel);

//        adding Button
//        for CONTINUE
        JButton jButton = new JButton("Click Here To Continue");
        jButton.setBounds(400, 400, 300, 70);
        jButton.setBackground(Color.BLACK);
        jButton.setForeground(Color.WHITE);
        jButton.addActionListener(this); // adding the listener to button
        image_jLabel.add(jButton);

//        CUSTOMIZE THE FRAMING SIZE
        setSize(1190, 650);
        setVisible(true);
        setLocation(200, 50);

//        BLINK VIEW
        while(true){
            jLabel.setVisible(false);
            try{Thread.sleep(500);}
            catch (Exception e){System.out.println(e.getStackTrace());}

            jLabel.setVisible(true);
            try{Thread.sleep(500);}
            catch (Exception e){System.out.println(e.getStackTrace());}
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
//        NAVIGATE to:- LOGIN Page when all the update is Completed
//        RETURN TO DEFAULT PAGE
        new Login();
    }


//    DRIVE CODE
    public static void main(String[] args){
        new Main();
    }
}
