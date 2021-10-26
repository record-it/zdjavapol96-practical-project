package api.swapi;

import api.swapi.repository.PlanetRepository;
import controller.Menu;
import controller.MenuItem;

import java.util.List;
import java.util.Scanner;

public class SwapiApp {
    private static PlanetRepository planets = new PlanetRepository();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Menu menu = new Menu(
                List.of(
                        MenuItem.builder()
                                .label("Wyświetl planety")
                                .action(() -> {
                                    for(var planet: planets.findAll()){
                                        System.out.printf("%-30s %14s\n", planet.getName(), planet.getPopulation());
                                    }
                                })
                                .build(),
                        MenuItem.builder()
                                .label("Wybierz planetę")
                                .action(()->{
                                    System.out.println("Wybrana planeta");
                                }).build(),
                        MenuItem.builder()
                                .label("Wyjście")
                                .action(()->{
                                    System.exit(0);
                                })
                                .build()
                )
        );
        //TODO dodać kod sprawdzający czy wpisany numer opcji jest liczbą (int)
        while(true) {
            menu.print();
            int option = scanner.nextInt();
            scanner.nextLine();
            menu.execute(option);
        }
    }
}
