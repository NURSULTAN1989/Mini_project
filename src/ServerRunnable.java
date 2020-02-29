
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ServerRunnable extends Thread{

    private Socket socket;
    ////////////////////////////////

    ////////////////////////////////
    public ServerRunnable(Socket socket){
        this.socket = socket;
    }

    public void run(){

        try{

            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true));
            BufferedReader br = new BufferedReader(new FileReader("output.txt"));

            PackageData pd = (PackageData) inStream.readObject();
            DBManager manager=new DBManager();
            manager.connect();

            String s = "";

            if(pd.operationType.equals("ADD")){
                Student serverList = pd.student;
                manager.addStudent(serverList);
            }
            else if(pd.operationType.equals("LIST")){
                PackageData finalDataToClient = new PackageData(manager.getAllStudents());
                outStream.writeObject(finalDataToClient);

            }
            bw.close();
            br.close();
            outStream.close();
            inStream.close();
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}

