package staff;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

    public class Account extends JFrame implements ActionListener {
        JLabel heading;
        JLabel Name,Email,Phonenumber,userid;

        JButton back;
        String name;

        Account(String name) {

            this.name =  name;
            setLayout(null);
//
//            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("staff/images/STAFFLogin.jpg"));
//            Image image = imageIcon.getImage().getScaledInstance(800, 400, Image.SCALE_DEFAULT);
//            ImageIcon scaledImageIcon = new ImageIcon(image);
//            JLabel backgroundImageLabel = new JLabel(scaledImageIcon);
//            backgroundImageLabel.setBounds(0, 0, 800, 400);
//            add(backgroundImageLabel);

            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 900, 70);
            panel.setBackground(new Color(29, 59, 85));
            panel.setLayout(null);
            add(panel);

            back = new JButton("Back");
            back.setBounds(10, 0, 130, 30);
            back.setForeground(new Color(255,255,255));
            back.setBackground(new Color(29, 59, 85));
            back.setBorder(new LineBorder(new Color(29, 59, 85)));
            back.setBorder(BorderFactory.createEmptyBorder());
            back.setCursor(new Cursor(Cursor.HAND_CURSOR));
            back.addActionListener(this);
            panel.add(back);

            JPanel panel3 = new JPanel();
            panel3.setBounds(20, 80, 400, 280);
            panel3.setBackground(new Color(29, 59, 85));
            panel3.setLayout(null);
            add(panel3);




            JPanel jpanel2 = new JPanel();
            jpanel2.setLayout(null);
            jpanel2.setBounds(400, 80, 400, 260);
            add(jpanel2);

            ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("staff/images/STAFFLogin.jpg"));
            Image image = imageicon.getImage().getScaledInstance(400, 280, Image.SCALE_DEFAULT);
            ImageIcon imageicon2 = new ImageIcon(image);
            JLabel jlabel = new JLabel(imageicon2);
            jlabel.setBounds(0, 0, 400, 280);
            panel3.add(jlabel);



            heading = new JLabel("Account");
            heading.setBounds(350, 10, 200, 40);
            heading.setFont(new Font("TAHOMA", Font.BOLD, 20));
            heading.setForeground(Color.WHITE);
            panel.add(heading);

            ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("staff/images/Imitlogo.png"));
            Image ima =i2.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
            ImageIcon imaicon2 = new ImageIcon(ima);
            JLabel image1 = new JLabel(imaicon2);
            image1.setBounds(600, 0, 100, 50);
            panel.add(image1);

            JLabel lblname1 = new JLabel("Name");
            lblname1.setBounds(40, 50, 200, 25);
            lblname1.setFont(new Font("TAHOMA",Font.BOLD,20));
//        addButton.addActionListener(this);
            jpanel2.add(lblname1);



            JLabel lblname = new JLabel("Name");
            lblname.setBounds(160, 50, 300, 20);
            lblname.setFont(new Font("TAHOMA",Font.PLAIN,20));
//        addButton.addActionListener(this);
            jpanel2.add(lblname);

            JLabel lblid1= new JLabel("Userid");
            lblid1.setBounds(40, 100, 150, 40);
            lblid1.setFont(new Font("TAHOMA",Font.BOLD,20));
//        updateButton.addActionListener(this);
            jpanel2.add(lblid1);

            JLabel lblid= new JLabel("Userid");
            lblid.setBounds(160, 100, 150, 40);
            lblid.setFont(new Font("TAHOMA",Font.PLAIN,20));
//        updateButton.addActionListener(this);
            jpanel2.add(lblid);

            JLabel lblphone1 = new JLabel("Contact");
            lblphone1.setBounds(40, 150, 150, 40);
            lblphone1.setFont(new Font("TAHOMA",Font.BOLD,20));
//        viewButton.addActionListener(this);
            jpanel2.add(lblphone1);

            JLabel lblphone = new JLabel("Phonenumber");
            lblphone.setBounds(160, 150, 150, 40);
            lblphone.setFont(new Font("TAHOMA",Font.PLAIN,20));
//        viewButton.addActionListener(this);
            jpanel2.add(lblphone);

            JLabel lblemail1= new JLabel("Email");
            lblemail1.setBounds(40, 200, 150, 40);
            lblemail1.setFont(new Font("TAHOMA",Font.BOLD,20));
//        removeButton.addActionListener(this);
            jpanel2.add(lblemail1);


            JLabel lblemail= new JLabel("Email");
            lblemail.setBounds(160, 200, 250, 40);
            lblemail.setFont(new Font("TAHOMA",Font.PLAIN,20));
//        removeButton.addActionListener(this);
            jpanel2.add(lblemail);

            try{
                connectionclass con = new connectionclass();
                ResultSet rs = con.stm.executeQuery("select * from staff");
                while(rs.next()){
                    lblname.setText(rs.getString("Name"));
                    lblphone.setText(rs.getString("contact_no"));
                    lblemail.setText(rs.getString("email_id"));
                    lblid.setText(rs.getString("userid"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            setBounds(300, 200, 900, 410);
            setVisible(true);
        }



        public static void main(String[] args) {
            new Account("");

        }

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == back){
                new Home(name);// are b
            }
        }
    }

