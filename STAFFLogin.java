package staff;

import java.sql.ResultSet;


import java.awt.*;
import java.awt.event.*;
import com.mysql.cj.protocol.Resultset;
import javax.swing.*;
import javax.swing.border.*;


public class STAFFLogin extends JFrame implements ActionListener{

    JTextField tfusername, tfpassword;
    JButton login, back;
    String pass, name;

    STAFFLogin(){

        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);

        getContentPane().setBackground(new Color(29,59,85));

        JPanel jpanel = new JPanel();// Used for divide page into multiple parts
        jpanel.setBackground(new Color(29,75,100));
        jpanel.setBounds(0, 0, 400, 400);
        add(jpanel);

        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("staff/images/STAFFLogin.jpg"));
        Image image = imageicon.getImage().getScaledInstance(375, 375, Image.SCALE_DEFAULT);
        ImageIcon imageicon2 = new ImageIcon(image);
        JLabel jlabel = new JLabel(imageicon2);
        jlabel.setBounds(90, 120, 200, 200);
        jpanel.add(jlabel);

        JPanel jpanel2 = new JPanel();
        jpanel2.setLayout(null);
        jpanel2.setBounds(400, 30, 450, 300);
        add(jpanel2);

        //Creating Username
        JLabel username = new JLabel("Username"); // The main uses of JLabel is for creating text formate in frame
        username.setBounds(60, 20, 100, 25);
        username.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        username.setForeground(new Color(29,75,100));
        jpanel2.add(username);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        jpanel2.add(tfusername);

        //Creating Password
        JLabel password = new JLabel("Password");
        password.setBounds(60, 110, 100, 25);
        password.setForeground(new Color(29,75,100));
        password.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        jpanel2.add(password);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        jpanel2.add(tfpassword);

        //Creating Login button
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(29,75,100));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(29,75,100)));
        login.addActionListener(this);
        jpanel2.add(login);

        //Creating back button
        back = new JButton("Back");
        back.setBounds(230, 200, 130, 30);
        back.setBackground(new Color(29,75,100));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(29,75,100)));
        back.addActionListener(this);
        jpanel2.add(back);

        setVisible(true);
    }



    public static void main(String[] args){
        new STAFFLogin();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == login){

            name = tfusername.getText();
            String query = "select * from staff where Name = '" + name + "'";
            connectionclass c = new connectionclass();
            try {
                ResultSet rs = c.stm.executeQuery(query);
                while(rs.next()){
                    pass = rs.getString("password");
                }
                String password = tfpassword.getText();
                if(password.equals(pass)){
                    new LoadingPage(name);
                }else{

                    JOptionPane.showMessageDialog(null, "Wrong username or password.");
//
                }//sbuthire back button acha ok wait
            }catch(Exception e){
                e.printStackTrace();
            }

        } else{

                setVisible(false);
                new SelectBranch();
//             new MainPage();
        }

    }

}


