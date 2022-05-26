import java.net.*;
import java.io.*;
import java.io.IOException;  
import java.io.InputStream;  

public class Server {
   
    //display
	static String display(int not)
	{  
        String message;
        if(not == 1)
        {
           message = "Words are not Anagram";	
        }
        else
        {
           message = "Words are  Anagram";	
        }
        return message;
	}
    

    //anagram method
    public static int anagram(String wrd1,String wrd2){
        
        char[] ch1 = wrd1.toCharArray();
        char[] ch2 = wrd2.toCharArray();
        int found=0,not_sound=0; 
        int not = 0;
        
        
        //Convert
        for(int i=0;i<wrd1.length();i++){
            ch1[i] = Character.toUpperCase(ch1[i]); 

        }
        for(int i=0;i< wrd2.length();i++){
            ch2[i] = Character.toUpperCase(ch2[i]);
        }

     
        if(wrd1.length()==wrd2.length()){
            for(int  i=0;i<wrd1.length();i++){
               
                found = 0; 
                for(int j=0;i<wrd2.length();j++){
                    if(ch1[i] == ch2[j])
                    {
                        found = 1;
                        break;
                    }

                }
                if(found == 0)
                {
                    not_sound = 1;
                    break;
                }
                if(not_sound == 1){
                    not = 1;
                }
                else{
                    not = 0;
                }
            }
        }
        else {
             not = 1;
        }

    return not;

    }   
    public static void main(String[] args){
		try {

            ServerSocket ss = new ServerSocket(6789);  // create a socket
            System.out.println("A socket is created and now waiting for connection.");

            Socket s = ss.accept();
            System.out.println("A client has made a connection in.");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            System.out.println("I will send the message to receive words from Client");
            
            String str1 = "Please,input first word :  ";   
            dout.writeUTF(str1);
            String wrd1 = (String)din.readUTF();  

            String str2 = "Please,input second word :  ";   
            dout.writeUTF(str2);
            String wrd2 = (String)din.readUTF();
            
            String  message  = display(anagram(wrd1,wrd2));
            System.out.println("Now server is going to sent the result");
            dout.writeUTF(message);

        } 
		catch (IOException e) { 
            System.out.println(e);
        }
	
	}
}
    
       

