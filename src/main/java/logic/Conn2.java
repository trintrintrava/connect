package logic;

import java.sql.*;

public class Conn2 {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        String sql = "";

        try{
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();

            /*sql = "create schema if not exists El_J";
            statement.executeUpdate(sql);

            sql = "create table if not exists El_J.actor " +
                    "( " +
                    " id            serial primary key  not null, " +
                    " name          varchar(100)        not null, " +
                    " second_name   varchar(100)        not null " +
                    ")";
            statement.executeUpdate(sql);


            sql = "create table if not exists El_J.film " +
                    "( " +
                    " id            serial primary key  not null, " +
                    " name          varchar(100)        not null, " +
                    " director      varchar(100)        not null " +
                    ")";
            statement.executeUpdate(sql);*/

            sql = "create table if not exists El_J.act_to_film " +
                    "( " +
                    " id            serial primary key  not null, " +
                    " id_actor      integer        not null, " +
                    " id_film       integer        not null " +
                    ")";
            statement.executeUpdate(sql);

            /*sql = "insert INTO El_J.actor (name, second_name) " +
                    "values (?, ?), " +
                    "(?, ?),"+
                    "(?, ?),"+
                    "(?, ?)";*/

            sql = "insert INTO El_J.act_to_film (id_actor, id_film) " +
                    "values (?, ?), " +
                    "(?, ?),"+
                    "(?, ?)";

            int[] arr = {1,3,2, 2, 3,1};



            /*sql = "insert INTO El_J.film (name, director) " +
                    "values (?, ?), " +
                    "(?, ?),"+
                    "(?, ?)";*/

            preparedStatement =
                    connection.prepareStatement(sql);


            for(int i=0; i<arr.length; i+=2){
                preparedStatement.setInt(i+1, arr[i]);
                preparedStatement.setInt(i+2, arr[i+1]);
            }

            preparedStatement.executeUpdate();


            ResultSet result = statement.executeQuery("select * from El_J.actor");

            while(result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");

                System.out.println("id: " + id);
                System.out.println("name: " + name);

            }


            System.out.println();

            statement.close();
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            System.out.println("Error in sql: " + sql);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }


    }

}
