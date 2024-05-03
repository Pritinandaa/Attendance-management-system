package staff;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Activity extends JFrame implements ActionListener {
    JLabel lbltime;
    JLabel Date,Section,Subject,Activity,Department,Topic;
    JTextField tftime;
    String username;
    JButton Update,Acti, back;
    Activity(String username)
    {
        this.username = username;
        getContentPane().setBackground(Color.WHITE);


        // Create a new JFrame
//        JFrame frame = new JFrame("Meeting Scheduler");
////        frame.setSize(800, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel for holding components
        setLayout(null);
        setBounds(0,0,800,700);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 800, 50);
        panel.setBackground(new Color(29, 59, 85));
        add(panel);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("staff/images/Imitlogo.png"));
        Image ima =i2.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        ImageIcon imaicon2 = new ImageIcon(ima);
        JLabel image1 = new JLabel(imaicon2);
        image1.setBounds(600, 0, 100, 50);
        panel.add(image1);

        Activity = new JLabel("Activity");
        Activity.setBounds(0, 250, 800, 150);
        Activity.setForeground(Color.WHITE);
        Activity.setFont(new Font("TAHOMA", Font.BOLD, 25));
        panel.add( Activity);

//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(6, 2, 5, 5));

        // Create dropdowns for section, subject, class, and meeting

        // Get the current date and format it
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


        Department = new JLabel("Department");
        Department.setBounds(80,150,100,20);
        add(Department);

        JComboBox<String> departmentDropdown = new JComboBox<>(new String[]{"MCA",  "MBA"});
        departmentDropdown.setBounds(200,150,100,20);
        add(departmentDropdown);

        Section=new JLabel("Section");
        Section.setBounds(80,200,100,20);
        add(Section);
        JComboBox<String> sectionDropdown = new JComboBox<>(new String[]{" A", " B"});
        sectionDropdown.setBounds(200,200,100,20);
        add(sectionDropdown);

        lbltime = new JLabel("Start Time");
        lbltime.setBounds(80,350,100,30);
        add(lbltime);

        tftime = new JTextField("");
        tftime.setBounds(200,350,100,30);
        add(tftime);

        Subject=new JLabel("Subject");
        Subject.setBounds(80,250,100,20);
        add(Subject);
        JComboBox<String> subjectDropdown = new JComboBox<>(new String[]{"Math", "Science", "English"});
        subjectDropdown.setBounds(200,250,100,20);
        add( subjectDropdown);

//        JComboBox<String> meetingDropdown = new JComboBox<>(new String[]{"Meeting 1", "Meeting 2", "Meeting 3"});
//        meetingDropdown.setBounds(80,430,100,20);

        lbltime = new JLabel("End  Time");
        lbltime.setBounds(80,400,100,30);
        add(lbltime);

        tftime = new JTextField("");
        tftime.setBounds(200,400,100,30);
        add(tftime);

        Topic = new JLabel("Topic");
       Topic.setBounds(80,300,100,30);
        add(Topic);

        tftime = new JTextField("");
        tftime.setBounds(200,300,100,30);
        add(tftime);

       Activity = new JLabel("Activity Type");
        Activity.setBounds(500,300,100,20);
        add(  Activity);
        JComboBox<String> activityDropdown = new JComboBox<>(new String[]{"Meeting",  "Class"});
        activityDropdown.setBounds(600,300,100,20);
        add(activityDropdown);



        Update = new JButton("Update");

        Update.setBounds(10, 500, 150, 40);
        Update.setBackground(new Color(29,75,100));
        Update.setForeground(Color.WHITE);
        Update.setBorder(new LineBorder(new Color(29,75,100)));
        Update.addActionListener(this);
        add(Update);

       Acti = new JButton("Add Another Activity");
        Acti.setBounds(200, 500, 150, 40);
        Acti.setBackground(new Color(29,75,100));
        Acti.setForeground(Color.WHITE);
        Acti.setBorder(new LineBorder(new Color(29,75,100)));
        Acti.addActionListener(this);
        add( Acti);


        back = new JButton("Back");
        back.setBounds(400, 500, 150, 40);
        back.setBackground(new Color(29,75,100));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(29,75,100)));
        back.addActionListener(this);
        add( back);
        // Create calendar to choose date
//        JCalendar calendar;
//        calendar = new JCalendar();
//        calendar.getClass();
//        calendar.toString();
//        calendar.getClass(); // Prevent selecting past dates

        // Create a section to mention time

        // Add components to the panel



        // Add the panel to the frame
//        frame.add(panel);
//        frame.setVisible(true);
        String date=timeField.getText();
        Object department=departmentDropdown.getSelectedItem();
        Object section = sectionDropdown.getSelectedItem();
        Object subject = subjectDropdown.getSelectedItem();
        setVisible(true);

    }

    public static void main(String[] args){
        new Activity("");
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            new Home(username);
        }else if(e.getSource() == Update){
            //update kale kou table re store haba

        }
    }
}
