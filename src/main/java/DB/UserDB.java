package DB;

import Model.User;

import java.sql.*;

public class UserDB {


    private final  String user = "root";
    private final  String uni = "university";
    private final  String password = "password";
    private final String url="jdbc:mysql://localhost:"+3306+"/"+uni;
    public  Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);

    }

    Connection connection;
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet = null;
    public void insertUser(User user){

        try {

            connection = connect();
            query = "insert into signup (Email , firstname , lastName , Phone , Password , job) values (?, ? , ? , ? ,? , ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getfName());
            preparedStatement.setString(3, user.getlName());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getPass());
            preparedStatement.setString(6, user.getType());
            preparedStatement.execute();
            System.out.println("Student inserted with Email : "+ user.getEmail());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

   public boolean serarchUser(User user){
        try {
            connection = connect();
            query = "select * from signup where email = ? AND password=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPass());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }



}
