package logic.service;

import domain.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmService extends DataBaseService{

    public List<Film> getAllFilms() {

        List<Film> films = new ArrayList<Film>();

        String sql = "select * from El_J.film";
        ResultSet result = executeSql(sql);

        try{
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
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return films;
    }
}
