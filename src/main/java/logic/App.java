package logic;

import domain.Actor;
import domain.Film;
import domain.dto.ActorFullInfoDto;
import logic.service.ActorService;
import logic.service.ComplexService;
import logic.service.FilmService;
import logic.service.GenericPrintService;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ActorService actorService = new ActorService();
        FilmService filmService = new FilmService();

        List<Actor> allActors = actorService.getAllActors();
        List<Film> allFilms = filmService.getAllFilms();

        GenericPrintService<Actor> actorGenericPrintService = new GenericPrintService<Actor>();
        actorGenericPrintService.simplePrint(allActors);

        GenericPrintService<Film> filmGenericPrintService = new GenericPrintService<Film>();
        filmGenericPrintService.simplePrint(allFilms);


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

        ComplexService complexService = new ComplexService();
        List<ActorFullInfoDto> infoDtoList = complexService.getAllInfoForActor("Вайона");
        for (ActorFullInfoDto item: infoDtoList ) {
            System.out.println(item);
        }
    }
}
