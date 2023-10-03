package P14DefiningClasses_Exercise.P06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!command.equals("Tournament")) {
            String[] tokens = command.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer;

            if (trainers.containsKey(trainerName)) {
                trainer = trainers.get(trainerName);
            } else {
                trainer = new Trainer(trainerName);
                trainers.put(trainerName, trainer);
            }
            trainer.addPokemon(pokemon);

            trainers.putIfAbsent(trainerName, trainer);

            command = scanner.nextLine();
        }

        command = scanner.nextLine();

        while (!command.equals("End")) {
            String element = command;
            trainers.values().forEach(t -> {
                if (t.hasPokemonWithSuchElement(element)) {
                    t.increaseBadges();
                } else {
                    t.decreasePokemonsHealth();
                    t.removeDiedPokemons();
                }
            });

            command = scanner.nextLine();
        }

        trainers.values()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(System.out::print);
    }
}
