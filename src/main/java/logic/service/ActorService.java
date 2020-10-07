package logic.service;

import domain.Actor;

import javax.sql.RowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorService extends DataBaseService{

    public List<Actor> getAllActors() {

        List<Actor> actors = new ArrayList<Actor>();

        String sql = "select * from El_J.actor";
        ResultSet result = executeSql(sql);
        try {
            while (result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                String secondName = result.getString("second_name");

                Actor actor = new Actor();
                actor.setId(id);
                actor.setName(name);
                actor.setSecondName(secondName);

                actors.add(actor);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return actors;
    }
}
