import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/students?useUnicode=true&serverTimezone=UTC","root", ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student){
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO students (id, name, surname, age) " +
                    "VALUES (NULL, ?, ?, ?)"
            );
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            int rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> studentList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                studentList.add(new Student(id, name, surname, age));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentList;
    }
    /*public void deleteCar(Long id){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM cars WHERE id = ?"
            );
            statement.setLong(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}