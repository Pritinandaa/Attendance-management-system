package staff;

import java.sql.*;
class GetIPAddressUsingJDBC {
    public static void main(String[] args) {
        // JDBC URL, username, and password for your database
        String url = "jdbc:mysql://localhost:3306/imitstaffattedance";
        String username = "root";
        String password = "root@98";

        try {
            // Establishing a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Creating a statement
            Statement statement = connection.createStatement();

            // Query to fetch the IP address
            String query = "SELECT host FROM information_schema.processlist WHERE ID=connection_id()";

            // Executing the query
            ResultSet resultSet = statement.executeQuery(query);

            // Processing the result set
            if (resultSet.next()) {
                String ipAddress = resultSet.getString("host");
                System.out.println("IP Address: " + ipAddress);
            } else {
                System.out.println("Failed to retrieve IP address.");
            }

            // Closing resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
