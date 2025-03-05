import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() throws IOException {
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);

        while (true) {
            try {
                // System.out.println("Sever is listining on port"+port);
                // Socket acceptedConnection = socket.accept();
                // System.out.println("Connection accepted from
                // client"+acceptedConnection.getRemoteSocketAddress());
                // PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                // BufferedReader fromClient = new BufferedReader(new
                // InputStreamReader(acceptedConnection.getInputStream()));
                // toClient.println("Hellow from the server");
                System.out.println("Server is listening on port " + port);

                Socket acceptedConnection = socket.accept();

                System.out.println("Connection accepted from client " + acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());

                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Hello from the server");

                toClient.close();
                fromClient.close();
                acceptedConnection.close();

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Exception occured");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}