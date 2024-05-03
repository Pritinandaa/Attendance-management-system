package staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.ResultSet;


public class Home extends JFrame implements ActionListener {
    JButton account, attendance, activity, logout, present, absent;
    String id, mail, pass,contact, department, designation, attend, reason, name;
    JLabel Name;

    public Home(String username) {
        this.name = username;
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1550, 150);
        panel.setBackground(new Color(29, 59, 85));
        panel.setLayout(null);
        add(panel);

//            ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("staffattendance1/"));
//            Image image = imageicon.getImage().getScaledInstance(1550, 900, Image.SCALE_DEFAULT);
//            ImageIcon imageicon2 = new ImageIcon(image);
//            JLabel jlabel = new JLabel(imageicon2);
//            jlabel.setBounds(0, 0, 1550, 900);
//            add(jlabel);

//            JLabel heading = new JLabel("Staff Management");
//            heading.setBounds(650, 220, 400, 40);
//            heading.setFont(new Font("TAHOMA", Font.BOLD, 27));
//            add(heading);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("staff/images/Imitlogo.png"));
        Image ima =i2.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        ImageIcon imaicon2 = new ImageIcon(ima);
        JLabel image1 = new JLabel(imaicon2);
        image1.setBounds(600, 0, 100, 50);
        panel.add(image1);

        int barHeight = 10;
        int barSpacing = 10;
        int startY = 200;

        JPanel bar1 = new JPanel();
        bar1.setBackground(Color.GREEN); // Change the color as needed
        bar1.setBounds(30, startY, 50, barHeight);
        add(bar1);

        JPanel bar2 = new JPanel();
        bar2.setBackground(Color.GREEN); // Change the color as needed
        bar2.setBounds(30, startY + barHeight + barSpacing, 50, barHeight);
        add(bar2);

        JPanel bar3 = new JPanel();
        bar3.setBackground(Color.GREEN); // Change the color as needed
        bar3.setBounds(30, startY + 2 * (barHeight + barSpacing), 50, barHeight);
        add(bar3);


        Name = new JLabel("Name");
        Name.setBounds(20, 20, 450, 30);
        Name.setForeground(Color.WHITE);
        Name.setFont(new Font("TAHOMA", Font.BOLD, 25));
        panel.add(Name);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(20, 50, 150, 30);
        designation.setForeground(Color.WHITE);
        designation.setFont(new Font("TAHOMA", Font.PLAIN, 25));
        panel.add(designation);

        JLabel department = new JLabel("Department");
        department.setBounds(20, 80, 150, 30);
        department.setForeground(Color.WHITE);
        department.setFont(new Font("TAHOMA", Font.PLAIN, 25));
        panel.add(department);


        JLabel mail = new JLabel("Mail id");
        mail.setBounds(20, 120, 150, 20);
        mail.setForeground(Color.WHITE);
        mail.setFont(new Font("TAHOMA", Font.PLAIN, 25));
        panel.add(mail);
        try {
            connectionclass con = new connectionclass();
            ResultSet rs = con.stm.executeQuery("select * from staff where name = '"+username+"'");
            while (rs.next()) {
                Name.setText(rs.getString("Name"));
                designation.setText(rs.getString("designation"));
                department.setText(rs.getString("department"));
                mail.setText(rs.getString("email_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        account = new JButton("Account");
        account.setBounds(50, 310, 150, 40);
        account.setFont(new Font("TAHOMA", Font.BOLD, 20));
        account.setOpaque(false);
        account.setBorderPainted(false);
        account.setContentAreaFilled(false);
        account.setFocusPainted(false);
        account.addActionListener(this);
        add(account);

        attendance = new JButton("Activity Tracker");
        attendance.setBounds(50, 380, 200, 40);
        attendance.setFont(new Font("TAHOMA", Font.BOLD, 20));
        attendance.setOpaque(false);
        attendance.setBorderPainted(false);
        attendance.setContentAreaFilled(false);
        attendance.setFocusPainted(false);
        attendance.addActionListener(this);
        add(attendance);

        activity = new JButton("Activity");
        activity.setBounds(50, 450, 150, 40);
        activity.setFont(new Font("TAHOMA", Font.BOLD, 20));
        activity.setOpaque(false);
        activity.setBorderPainted(false);
        activity.setContentAreaFilled(false);
        activity.setFocusPainted(false);
        activity.addActionListener(this);
        add(activity);


        logout = new JButton("Log out");
        logout.setBounds(50, 520, 150, 40);
        logout.setFont(new Font("TAHOMA", Font.BOLD, 20));
        logout.setOpaque(false);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setFocusPainted(false);
        logout.addActionListener(this);
        add(logout);

        present = new JButton("Present");
        present.setBounds(1050, 210, 150, 40);
        present.addActionListener(this);
        add(present);

        absent = new JButton("Absent");
        absent.setBounds(1050, 310, 150, 40);
        absent.addActionListener(this);
        add(absent);

        JTextArea lbltext = new JTextArea("");
        lbltext.setBounds(200, 250, 350, 150);
        add(lbltext);

        // Add action listeners
//                  account.addActionListener(new ActionListener() {
//                        public void actionPerformed(ActionEvent e) {
//                              // Handle account button action
//                        }
//                  });
//
//                  attendance.addActionListener(new ActionListener() {
//                        public void actionPerformed(ActionEvent e) {
//                              // Handle attendance button action
//                        }
//                  });
//
//                  activity.addActionListener(new ActionListener() {
//                        public void actionPerformed(ActionEvent e) {
//                              // Handle activity button action
//                        }
//                  });
//
//                  logout.addActionListener(new ActionListener() {
//                        public void actionPerformed(ActionEvent e) {
//                              // Handle logout button action
//                        }
//                  });
//
//                  present.addActionListener(new ActionListener() {
//                        public void actionPerformed(ActionEvent e) {
//                              // Handle present button action
//                        }
//                  });
//
//                  absent.addActionListener(new ActionListener() {
//                        public void actionPerformed(ActionEvent e) {
//                              // Handle absent button action
//                        }
//                  });

        setBounds(0, 0, 1450, 800);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Home("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == account) {
            setVisible(false);
            new Account(name);

        } else if (ae.getSource() == attendance) {
            setVisible(false);
            new ActivityTracker(name);

        } else if (ae.getSource() == activity) {
            setVisible(false);
            new Activity(name);

        }
        else if (ae.getSource() == logout) {
            setVisible(false);
            new STAFFLogin();

        } else if (ae.getSource() == present){
            if(markAttendance()) {
                name = Name.getText();
                String query = "select * from staff where Name = '" + name + "'";
                connectionclass c = new connectionclass();
                try {
                    ResultSet rs = c.stm.executeQuery(query);
                    while (rs.next()) {
                        id = rs.getString("userid");
                        mail = rs.getString("email_id");
                        pass = rs.getString("password");
                        contact = rs.getString("contact_no");
                        department = rs.getString("department");
                        designation = rs.getString("designation");
                        attend = rs.getString("attendance");
                        reason = rs.getString("Reason_for_leave");
                    }
                    String Query = "insert into attendance_update values ('" + id + "','" + name + "','" + mail + "','" +
                            pass + "','" + contact + "','" + department + "','" + designation + "','" + attend + "','" + reason + "',curdate())";
                    c.stm.executeUpdate(Query);
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
            else if (ae.getSource() == absent) {
            // Create a pop-up dialog with a text field
            if (markAttendance()) {
                JTextField textField = new JTextField();
                Object[] message = {
                        "Reason for leave", textField
                };

                int option = JOptionPane.showConfirmDialog(this, message, "Text Input", JOptionPane.OK_CANCEL_OPTION);

                // Handle the input text
                if (option == JOptionPane.OK_OPTION) {
                    name = Name.getText();
                    reason = textField.getText();
                    String query = "select * from staff where Name = '" + name + "'";
                    connectionclass c = new connectionclass();
                    try {
                        ResultSet rs = c.stm.executeQuery(query);
                        while (rs.next()) {
                            id = rs.getString("userid");
                            mail = rs.getString("email_id");
                            pass = rs.getString("password");
                            contact = rs.getString("contact_no");
                            department = rs.getString("department");
                            designation = rs.getString("designation");
                            attend = rs.getString("attendance");
                            reason = rs.getString("Reason_for_leave");


                        }
                        String Query = "insert into attendance_update values ('" + id + "','" + name + "','" + mail + "','" +
                                pass + "','" + contact + "','" + department + "','" + designation + "','" + "No" + "','" + reason + "',curdate())";
                        c.stm.executeUpdate(Query);

                        // Do something with the text (e.g., display it)
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        }

    }
    private static boolean markAttendance() {
        String serverHost = "192.168.91.80";
        int serverPort = 8888;

        try (Socket socket = new Socket(serverHost, serverPort);
             OutputStream outputStream = socket.getOutputStream()) {

            // Send a simple message to the server to trigger attendance marking
            outputStream.write("Mark Attendance".getBytes());

//            JOptionPane.showMessageDialog(null, "Attendance marked successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Failed to mark attendance. Please try again.");
            return false;
        }
       return true;
    }
}
