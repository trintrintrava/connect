package logic.service;

import java.sql.*;

public class DataBaseService {

    public ResultSet executeSql(String sqlt){

        Connection connection = null;
        Statement statement = null;

        try{
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sqlt);

            statement.close();
            connection.close();

            return result;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error in sql: " + sqlt);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return null;

    }
}
