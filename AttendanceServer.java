package staff;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AttendanceServer {

    private static final String[] ALLOWED_IPS = {"172.25.160.1", "192.168.91.80"};

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("Attendance server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                String clientIP = clientSocket.getInetAddress().getHostAddress();

                if (isIPAllowed(clientIP)) {
                    // IP address is allowed, mark attendance or perform other actions
                    System.out.println("Attendance marked for IP: " + clientIP);
                } else {
                    System.out.println("Access denied. IP not authorized: " + clientIP);
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isIPAllowed(String ip) {
        for (String allowedIP : ALLOWED_IPS) {
            if (allowedIP.equals(ip)) {
                return true;
            }
        }
        return false;
    }
}
