package com.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Animal {
    String name;
    List<String> commands;

    public Animal(String name) {
        this.name = name;
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void printCommands() {
        System.out.println("Команды для " + name + ":");
        for (String command : commands) {
            System.out.println("- " + command);
        }
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
}
}

class PetRegistry {
    List<Animal> animals;

    public PetRegistry() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void printAnimals() {
        System.out.println("Животные:");
        for (Animal animal : animals) {
            System.out.println("- " + animal.name);
            animal.printCommands();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetRegistry petRegistry = new PetRegistry();

        while (true) {
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Распечатать животных");
            System.out.println("3. Выход");
            System.out.print("Введите свой выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();

                    System.out.print("Введите тип животного (cat/dog): ");
                    String type = scanner.nextLine();

                    Animal animal;
                    if (type.equalsIgnoreCase("cat")) {
                        animal = new Cat(name);
                    } else if (type.equalsIgnoreCase("dog")) {
                        animal = new Dog(name);
                    } else {
                        System.out.println("Неверный тип животного. Пожалуйста, попробуйте еще раз.");
                        continue;
                    }

                    System.out.print("Введите команды (через запятую): ");
                    String commandsStr = scanner.nextLine();
                    String[] commandsArr = commandsStr.split(",");
                    for (String command : commandsArr) {
                        animal.addCommand(command.trim());
                    }

                    petRegistry.addAnimal(animal);
                    break;
                case 2:
                    petRegistry.printAnimals();
                    break;
                case 3:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }
    }
}