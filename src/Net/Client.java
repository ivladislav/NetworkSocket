package Net;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

// Network Socket Program - Client
public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Socket sc = new Socket("localhost", 80);

        DataOutputStream out = new DataOutputStream(sc.getOutputStream());
        DataInputStream in = new DataInputStream(sc.getInputStream());

        System.out.println("Enter number of element you want to send to server....");
        int num = Integer.parseInt(br.readLine());

        System.out.println("Sending the data....");

        out.writeInt(num);

        for (int i = 0; i < num; i++) {

            int x = Integer.parseInt(br.readLine());
            out.writeInt(x);
        }

        System.out.println("Data sending is completed....");

        in.close();
        out.close();
        br.close();
        sc.close();
    }

}
