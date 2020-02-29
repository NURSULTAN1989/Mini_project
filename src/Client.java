
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class Client {
    public static MainFrame frame;


    public static void connect(PackageData pd){
        try {

            Socket socket = new Socket("127.0.0.1", 2000);
            ObjectOutputStream toServer =  new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream fromServer =  new ObjectInputStream(socket.getInputStream());
            if(pd.operationType=="ADD"){
                toServer.writeObject(pd);
            }
            else if(pd.operationType=="LIST"){
                toServer.writeObject(pd);
                PackageData pdFromServer = (PackageData)fromServer.readObject();
                ArrayList<Student> studentList = pdFromServer.studentList;
                String sList = "";
                for(int i=0;i<studentList.size();i++){
                    sList+=studentList.get(i)+"\n";
                }
                ListStudent.text.setText(sList);
            }

            toServer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public static void main(String[] args) {
        frame = new MainFrame();
        frame.setVisible(true);
    }


}