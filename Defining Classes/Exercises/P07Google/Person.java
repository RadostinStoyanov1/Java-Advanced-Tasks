package P14DefiningClasses_Exercise.P07Google;

import java.util.ArrayList;
import java.util.List;


public class Person {
    private String personName;
    private Company company;
    private List<PokemonNew> pokemonList;
    private List<Parent> parentList;
    private List<Children> childrenList;
    private CarNew car;

    public Person(String personName) {
        this.personName = personName;
        this.pokemonList = new ArrayList<>();
        this.parentList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public String getPersonName() {
        return personName;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(CarNew car) {
        this.car = car;
    }

    public void addPokemon(PokemonNew pokemonNew) {
        this.pokemonList.add(pokemonNew);
    }

    public void addParent(Parent parent) {
        this.parentList.add(parent);
    }

    public void addChild(Children child) {
        this.childrenList.add(child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.personName).append(System.lineSeparator()).append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(String.format("%s %s %.2f%n", this.company.getCompanyName(), this.company.getDepartment(), this.company.getSalary()));
        }
        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(String.format("%s %d%n", car.getCarModel(), car.getCarSpeed()));
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        if (pokemonList.size() > 0) {
            for (PokemonNew pokemonNew : pokemonList) {
                sb.append(pokemonNew.getPokemonName()).append(" ").append(pokemonNew.getPokemonType()).append(System.lineSeparator());
            }
        }
        sb.append("Parents:").append(System.lineSeparator());
        if (parentList.size() > 0) {
            for (Parent parent : parentList) {
                sb.append(String.format("%s %s%n", parent.getParentName(), parent.getParentBirthday()));
            }
        }
        sb.append("Children:").append(System.lineSeparator());
        if (childrenList.size() > 0) {
            for (Children child : childrenList) {
                sb.append(String.format("%s %s%n", child.getChildName(), child.getChildBirthday()));
            }
        }

        return sb.toString();
    }
}
