package staff;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AttendanceTracker extends JFrame implements ActionListener {

    JButton View, Back;
    JTextField timeField;
    JLabel Department;
    JTextField tftime;
    JLabel heading;
    JScrollPane pane;
    JTable table;
    JComboBox<String> departmentDropdown;
    ResultSetMetaData rsmd;
    DefaultTableModel model;
    String[] col_name;
    String designation, currentUserRole;

    AttendanceTracker(String userRole) {
        this.currentUserRole =userRole;
        getContentPane().setBackground(Color.WHITE);


        setLayout(null);
        setBounds(0, 0, 1500, 1000);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1500, 50);
        panel.setBackground(new Color(29, 59, 85));
        add(panel);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("staff/images/Imitlogo.png"));
        Image ima =i2.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        ImageIcon imaicon2 = new ImageIcon(ima);
        JLabel image1 = new JLabel(imaicon2);
        image1.setBounds(600, 0, 100, 50);
        panel.add(image1);


        heading = new JLabel("Attendance Tracker");
        heading.setBounds(350, 10, 200, 50);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 20));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds(80, 100, 100, 30);
        add(dateLabel);

        timeField = new JTextField("Enter Time");
        timeField.setBounds(200, 100, 100, 30);


        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);
        timeField.setText(formattedDate);
        add(timeField);

        JLabel lblname1 = new JLabel("Name");
        lblname1.setBounds(400, 100, 100, 20);
//            lblname1.setFont(new Font("TAHOMA",Font.PLAIN,16));
//        addButton.addActionListener(this);
        add(lblname1);

        tftime = new JTextField("Enter Name");
        tftime.setBounds(600, 100, 100, 20);
        add(tftime);


        //Scrollable view of the table
        pane = new JScrollPane();
        pane.setBounds(200, 350, 1300, 400);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //Table for the shown of data
        table = new JTable();
        table.setBounds(0, 0, 1150, 400);
        table.setBackground(Color.gray);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        pane.getViewport().add(table);

        View = new JButton("  View");
        View.setBounds(50, 210, 100, 30);
        View.addActionListener(this);
        add(View);

        Back = new JButton("Back");
        Back.setBounds(600, 210, 100, 30);
//        Back.addActionListener(this);
        add(Back);

        Department = new JLabel("Department");
        Department.setBounds(80, 150, 100, 20);
        add(Department);

        departmentDropdown = new JComboBox<>(new String[]{"MCA", "MBA"});
        departmentDropdown.setBounds(200, 150, 100, 20);
        add(departmentDropdown);

        setVisible(true);

    }

    public static void main(String[] args) {
        new staff.AttendanceTracker("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        table.setModel(new DefaultTableModel(null, col_name));
        String startdate = timeField.getText();
        if (!isValidDateFormat(startdate)) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please enter From date in YYYY-MM-DD format.");
        } else {
            String department = (String) departmentDropdown.getSelectedItem();


            //Fetching of the data from the database
            String query = "select distinct * from attendance_update where department = '" + department + "' ";
            try {
                connectionclass c = new connectionclass();
                ResultSet rs = c.stm.executeQuery(query);
                rsmd = rs.getMetaData();
                model = (DefaultTableModel) table.getModel();

                //Accessing column name directly from the table in the database
                int cols = rsmd.getColumnCount();
                col_name = new String[cols];
                for (int i = 0; i < cols; i++) {
                    col_name[i] = rsmd.getColumnName(i + 1);
                }
                model.setColumnIdentifiers(col_name);


                //Accessing the data from the table
                while (rs.next()) {
                    Object[] rowData = new Object[cols];
                    for (int i = 0; i < cols; i++) {
                        rowData[i] = rs.getObject(i + 1);
                    }
                    model.addRow(rowData);
                }

                //Changing the Row values into columns
                try {
                    // Create Calendar instances for start and end dates
                    String[] startDateParts = startdate.split("-");
                    int startYear = Integer.parseInt(startDateParts[0]);
                    int startMonth = Integer.parseInt(startDateParts[1]);
                    int startDay = Integer.parseInt(startDateParts[2]);

                    Calendar startDate = Calendar.getInstance();
                    startDate.set(startYear, startMonth - 1, startDay);


                    Calendar current = (Calendar) startDate.clone();

                    //Adding a new column total percentage


                } catch (Exception ee) {
                    ee.printStackTrace();
                }

                // Set width for all columns
                for (int columnIndex = 0; columnIndex < model.getColumnCount(); columnIndex++) {
                    table.getColumnModel().getColumn(columnIndex).setPreferredWidth(200); // Set width for all columns to 200 pixels
                }

                table.setModel(model);

                add(pane);

            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if (e.getSource() == View) {
            String username = tftime.getText();
            String department =(String) departmentDropdown.getSelectedItem();

            // Validate credentials and get the user's role
            designation = authenticate(username, department);

            if (currentUserRole != null) {
                if (designation.equals("Principal") || currentUserRole.equals("HOD")) {
                    // Proceed with fetching data
                    fetchData();
                } else {
                    JOptionPane.showMessageDialog(this, "You don't have access to view data.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        }
        // Other action events...
    }

    // Method to authenticate users
    private String authenticate(String username, String password) {
        // Here you can implement your authentication logic.
        // For simplicity, let's assume there are only two users: Principal and HOD,
        // and their usernames and passwords are hardcoded.
        if (username.equals("principal") && password.equals("principalpassword")) {
            return "Principal";
        } else if (username.equals("hod") && password.equals("hodpassword")) {
            return "Principal";
        } else if (username.equals("hod") && password.equals("hodpassword")) {
            return "HOD";
        }
        return null; // If authentication fails
    }

    // Method to fetch data from the database
    private void fetchData() {
        // Your database query code here...
    }

    public static boolean isValidDateFormat(String dateString) {
        String regex = "\\d{4}-(0?[1-9]|1[0-2])-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateString);
        return matcher.matches();
    }
}
