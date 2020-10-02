package logic;

import domain.Actor;
import logic.service.ActorService;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ActorService actorService = new ActorService();

        List<Actor> allActors = actorService.getAllActors();

        System.out.println("Print List of results");
        for (Actor actor : allActors) {
            System.out.println(actor);
        }

        System.out.println("Another way to print List of data");
        System.out.println(Arrays.toString(allActors.toArray()));
    }
}
