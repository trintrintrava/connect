package logic;

import domain.Actor;
import domain.Film;
import logic.service.ActorService;
import logic.service.FilmService;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ActorService actorService = new ActorService();
        FilmService filmService = new FilmService();

        List<Actor> allActors = actorService.getAllActors();
        List<Film> allFilms = filmService.getAllFilms();

        System.out.println("Print List of results");
        for (Actor actor : allActors) {
            System.out.println(actor);
        }
//        вывод столбиком построчно

        System.out.println("Another way to print List of data");
        System.out.println(Arrays.toString(allActors.toArray()));
//        вывод через одну строчку всего списка

        System.out.println("Print List of results");
        for (Film film : allFilms) {
            System.out.println(film);
        }

        System.out.println("Another way to print List of data");
        System.out.println(Arrays.toString(allFilms.toArray()));
    }
}
