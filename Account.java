package staff;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

    public class Account extends JFrame {
        JLabel heading;
        JLabel Name,Email,Phonenumber,userid;

        Account() {
            setLayout(null);
//
            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("staff/images/STAFFLogin.jpg"));
            Image image = imageIcon.getImage().getScaledInstance(800, 400, Image.SCALE_DEFAULT);
            ImageIcon scaledImageIcon = new ImageIcon(image);
            JLabel backgroundImageLabel = new JLabel(scaledImageIcon);
            backgroundImageLabel.setBounds(0, 0, 800, 400);
            add(backgroundImageLabel);



            heading = new JLabel("Account");
            heading.setBounds(40, 50, 200, 40);
            heading.setFont(new Font("TAHOMA", Font.BOLD, 20));
            backgroundImageLabel.add(heading);

            JLabel lblname = new JLabel("Name");
            lblname.setBounds(40, 100, 300, 20);
            lblname.setFont(new Font("TAHOMA",Font.PLAIN,5));
//        addButton.addActionListener(this);
            backgroundImageLabel.add(lblname);

            JLabel lblid= new JLabel("Userid");
            lblid.setBounds(40, 150, 150, 40);
            lblname.setFont(new Font("TAHOMA",Font.PLAIN,20));
//        updateButton.addActionListener(this);
            backgroundImageLabel.add(lblid);

            JLabel lblphone = new JLabel("Phonenumber");
            lblphone.setBounds(40, 200, 150, 40);
            lblname.setFont(new Font("TAHOMA",Font.PLAIN,20));
//        viewButton.addActionListener(this);
            backgroundImageLabel.add(lblphone);

            JLabel lblemail= new JLabel("Email");
            lblemail.setBounds(40, 250, 150, 40);
            lblname.setFont(new Font("TAHOMA",Font.PLAIN,20));
//        removeButton.addActionListener(this);
            backgroundImageLabel.add(lblemail);

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

            setBounds(300, 200, 800, 400);
            setVisible(true);
        }



        public static void main(String[] args) {
            new Account();

        }
    }

