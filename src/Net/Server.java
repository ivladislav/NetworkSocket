package Net;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// Network Socket Program - Server
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(80);
        System.out.println("Server is waiting on port number 80......");
        Socket soc = server.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream out = new DataOutputStream(soc.getOutputStream());
        DataInputStream in = new DataInputStream(soc.getInputStream());

        int no = in.readInt();
        int arr[] = new int[no];

        System.out.println("Receiving the data from client.....");

        for (int i = 0; i < no; i++) {

            arr[i] = in.readInt();
            System.out.println(arr[i]);
        }

        System.out.println("Data receiving is completed.....");

        in.close();
        out.close();
        br.close();
        soc.close();
        server.close();
    }

}
