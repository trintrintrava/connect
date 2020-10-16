package logic.service;

import domain.ActorFilmParent;

import java.util.List;

public class GenericPrintService<T extends ActorFilmParent> {

    public void simplePrint(List<T> list) {
        System.out.println("Print from PrintService");
        for (T item : list) {
            System.out.println(item);
        }
    }
}
