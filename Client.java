import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
   
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        try {
            // create a socket to a local host with port # 6789
            Socket s = new Socket("192.168.1.41", 6789);
            
            System.out.println("A connection is established and I'll now send a message");

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            String str = (String) din.readUTF();
            System.out.println(str);

            String input1 = input.nextLine();
            dout.writeUTF(input1);

            String str2 = (String) din.readUTF();
            System.out.println(str2);

            String input2 = input.nextLine();
            dout.writeUTF(input2);

            String result = (String) din.readUTF();
            System.out.println(result);  
            
            dout.flush();
            dout.close();
            s.close();

        } 
        catch (IOException e) 
        { System.out.println(e); 
        }
    }
}
