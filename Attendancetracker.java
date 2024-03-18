package staff;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Attendancetracker extends JFrame {
    JButton View, Back;
   JLabel Department;

    Attendancetracker() {

        getContentPane().setBackground(Color.WHITE);


        setLayout(null);
        setBounds(0, 0, 800, 700);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 800, 50);
        panel.setBackground(new Color(29, 59, 85));
        add(panel);

        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds(80, 100, 100, 30);
        add(dateLabel);

        JTextField timeField = new JTextField("Enter Time");
        timeField.setBounds(200, 100, 100, 30);


        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);
        timeField.setText(formattedDate);
        add(timeField);

        View = new JButton("  View");
        View.setBounds(50, 210, 100, 30);
//        View.addActionListener(this);
        add(View);

        Back = new JButton("Back");
        Back.setBounds(600, 210, 100, 30);
//        Back.addActionListener(this);
        add(Back);

        Department = new JLabel("Department");
        Department.setBounds(80,150,100,20);
        add(Department);

        JComboBox<String> departmentDropdown = new JComboBox<>(new String[]{"MCA",  "MBA"});
        departmentDropdown.setBounds(200,150,100,20);
        add(departmentDropdown);

        setVisible(true);

    }
    public static void main(String[] args){
        new Attendancetracker();
    }
}

