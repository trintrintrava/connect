package logic.service;

import domain.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmService {

    public List<Film> getAllFilms() {

        List<Film> films = new ArrayList<Film>();

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

            ResultSet result = statement.executeQuery("select * from El_J.film");

            while(result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                String director = result.getString("director");

                Film film = new Film();
                film.setId(id);
                film.setName(name);
                film.setDirector(director);

                films.add(film);
            }

            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error in sql: " + sql);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return films;
    }
}
