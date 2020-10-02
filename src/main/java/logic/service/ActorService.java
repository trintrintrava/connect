package logic.service;

import domain.Actor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorService {

    public List<Actor> getAllActors() {

        List<Actor> actors = new ArrayList<Actor>();

        Connection connection = null;
        Statement statement = null;
        String sql = "";

        try{
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();

            ResultSet result = statement.executeQuery("select * from El_J.actor");

            while(result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                String secondName = result.getString("second_name");

                Actor actor = new Actor();
                actor.setId(id);
                actor.setName(name);
                actor.setSecondName(secondName);

                actors.add(actor);
            }

            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error in sql: " + sql);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return actors;
    }
}
