package api.swapi;

import api.swapi.repository.FilmRepository;
import controller.Menu;
import controller.MenuItem;

import java.util.List;
import java.util.Scanner;

public class MyApp {
    static FilmRepository films = new FilmRepository();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Menu menu = new Menu(List.of(
                MenuItem.builder()
                        .label("Wszystkie filmy")
                        .action(() -> {
                            films.findAll().forEach(film ->
                                System.out.printf("%-30s%40s\n", film.getTitle(), film.getDirector())
                            );
                        })
                        .build(),
                MenuItem.builder()
                        .label("Wybrany film")
                        .action(() ->{

                        })
                        .build(),
                MenuItem.builder()
                        .label("Wyjście")
                        .action(()->{
                            System.exit(0);
                        })
                        .build()
        ));
        while(true) {
            menu.print();
            int option = scanner.nextInt();
            scanner.nextLine();
            menu.execute(option);
        }
    }
}
