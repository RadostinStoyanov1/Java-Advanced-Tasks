package P14DefiningClasses_Exercise.P07Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personsMap = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String personName = tokens[0];
            personsMap.putIfAbsent(personName, new Person(personName));

            createObject(tokens, personsMap);

            line = scanner.nextLine();
        }
        String personNameToPrint = scanner.nextLine();

        for (Person person : personsMap.values()) {
            if (person.getPersonName().equals(personNameToPrint)) {
                System.out.println(person);
            }
        }
    }

    private static void createObject(String[] tokens, Map<String, Person> personsMap) {
        String personName = tokens[0];
        switch (tokens[1]) {
            case "company":
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                Company company = new Company(companyName, department, salary);
                personsMap.get(personName).setCompany(company);
                break;
            case "pokemon":
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];
                PokemonNew pokemonNew = new PokemonNew(pokemonName, pokemonType);
                personsMap.get(personName).addPokemon(pokemonNew);
                break;
            case "parents":
                String parentName = tokens[2];
                String parentBirthday = tokens[3];
                Parent parent = new Parent(parentName, parentBirthday);
                personsMap.get(personName).addParent(parent);
                break;
            case "children":
                String childName = tokens[2];
                String childBirthday = tokens[3];
                Children children = new Children(childName, childBirthday);
                personsMap.get(personName).addChild(children);
                break;
            case "car":
                String carModel = tokens[2];
                int carSpeed = Integer.parseInt(tokens[3]);
                CarNew car = new CarNew(carModel, carSpeed);
                personsMap.get(personName).setCar(car);
                break;
        }
    }
}
