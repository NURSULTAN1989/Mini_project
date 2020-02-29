
import java.io.*;
import java.net.*;
import java.util.*;

public class Server{

    public static void main(String[] args) {

        try{

            ServerSocket server = new ServerSocket(2000);
            while(true){

                System.out.println("Waiting for a client");
                Socket socket = server.accept();
                System.out.println("Client connected");

                ServerRunnable sr = new ServerRunnable(socket);
                sr.start();

            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}