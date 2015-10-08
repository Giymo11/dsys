import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        String hostName = Config.hostName;
        int portNumber = Config.portNumber;
        String command = Config.command;

        try {
            Socket server = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));

            out.println(command);
            out.flush();
            String input = in.readLine();
            while (input != null) {
                System.out.println("Response: " + input);
                input = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
