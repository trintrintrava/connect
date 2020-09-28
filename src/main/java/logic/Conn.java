package logic;

import java.math.BigDecimal;
import java.sql.*;

public class Conn {

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
                    "(?, ?),"+
                    "(?, ?),"+
                    "(?, ?),"+
                    "(?, ?),"+
                    "(?, ?),"+
                    "(?, ?)";

            /*sql = "insert INTO El_J.film (name, director) " +
                    "values (?, ?), " +
                    "(?, ?),"+
                    "(?, ?)";*/

            preparedStatement =
                    connection.prepareStatement(sql);

            /*preparedStatement.setString(1, "Малифисента");
            preparedStatement.setString(2, "Роберт Стромберг");
            preparedStatement.setString(3, "Прерванная жизнь");
            preparedStatement.setString(4, "Джеймс Мэнголд");
            preparedStatement.setString(5, "Семь");
            preparedStatement.setString(6, "Дэвид Финчер");
            preparedStatement.setString(7, "Уэс Андерсон");
            preparedStatement.setString(8, "Отель \"Гранд Будапешт\"");
            preparedStatement.executeUpdate();*/

            /*preparedStatement.setString(1, "Вайона");
            preparedStatement.setString(2, "Райдер");
            preparedStatement.setString(3, "Бред");
            preparedStatement.setString(4, "Питт");
            preparedStatement.setString(5, "Тим");
            preparedStatement.setString(6, "Рот");
            preparedStatement.setString(7, "Рэйф");
            preparedStatement.setString(8, "Файнс");
            preparedStatement.executeUpdate();*/

            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, 2);
            preparedStatement.setInt(3, 1);
            preparedStatement.setInt(4, 6);
            preparedStatement.setInt(5, 1);
            preparedStatement.setInt(6, 7);
            preparedStatement.setInt(7, 2);
            preparedStatement.setInt(8, 2);
            preparedStatement.setInt(9, 2);
            preparedStatement.setInt(10, 8);
            preparedStatement.setInt(11, 3);
            preparedStatement.setInt(12, 3);
            preparedStatement.setInt(13, 4);
            preparedStatement.setInt(14, 5);
            preparedStatement.setInt(15, 5);
            preparedStatement.setInt(16, 7);
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
