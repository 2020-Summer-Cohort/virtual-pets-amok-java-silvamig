package pets_amok;

import java.util.Scanner;

public class VirtualPetsAmokApp {
    static Scanner input = new Scanner(System.in);
    static VirtualPetShelter myPetShelter = new VirtualPetShelter();

    public static void main(String[] args) {

        myPetShelter.addPet(new OrganicDog("Sirius", "an organic dog", 50, 50, 25, 25, 25, 0));
        myPetShelter.addPet(new RoboticDog("Robert", "a robotic dog", 50, 50, 25, 25));
        myPetShelter.addPet(new OrganicCat("Cyprus", "an organic cat", 50, 50, 25, 25, 0));
        myPetShelter.addPet(new RoboticCat("Hilda", "a robotic cat", 50, 50, 25, 25));

        System.out.println("Welcome to our Pet Shelter.");

        boolean quit = false;
        while (!quit) {
            shelterOptions();
            String userInput = input.nextLine();
            if (userInput.equals("1")) {
                myPetShelter.displayStatus();
                System.out.println(
                        "Organic pets don't need oil or maintenance and robotic pets never need to eat, drink, or produce waste.");
            } else if (userInput.equals("2")) {
                System.out.println(
                        "You want to feed the organic pets.");
                myPetShelter.feedAllOrganicPets();
                myPetShelter.tickAllPets();
            } else if (userInput.equals("3")) {
                System.out.println(
                        "You want to water the organic pets.");
                myPetShelter.waterAllOrganicPets();
                myPetShelter.tickAllPets();
            } else if (userInput.equals("4")) {
                myPetShelter.displayStatus();
                System.out.println("Please enter the name of the pet you want to play with.");
                String petToPlayWith = input.nextLine();
                myPetShelter.playWithOnePet(petToPlayWith);
                System.out.println("You want to play with " + petToPlayWith);
                myPetShelter.tickAllPets();
            } else if (userInput.equals("5")) {
                myPetShelter.walkAllDogs();
                System.out
                        .println("You want to walk ALL the dogs.");
                myPetShelter.tickAllPets();
            } else if (userInput.equals("6")) {
                myPetShelter.cleanAllCages();
                System.out.println("OK. All waste has been removed from the dog cages.");
                myPetShelter.tickAllPets();
            } else if (userInput.equals("7")) {
                System.out.println("You want to clean the shelter litter box.");
                myPetShelter.cleanCommunalLitterBox();
                myPetShelter.tickAllPets();
            } else if (userInput.equals("8")) {
                myPetShelter.oilAllRobots();
                System.out.println("You want to oil the Robotic pets.");
                myPetShelter.tickAllPets();
            } else if (userInput.equals("9")) {
                myPetShelter.maintainAllRobots();
                System.out.println(
                        "A new update is available for the Robotic Pets. You want to keep up their maintenance.");
                myPetShelter.tickAllPets();
            } else if (userInput.equals("10")) {
                myPetShelter.tickAllPets();
                System.out.println("You want to add a pet.\nWhat is the pet's name?");
                String petToAddName = input.nextLine();
                System.out.println("And what kind of animal is " + petToAddName + "?\n"
                        + "Please type 1 for organic cat, 2 for organic dog, 3 for robotic cat, or 4 robotic dog.");
                String petToAddSpecies = input.nextLine();

                System.out.println("Thank you! " + petToAddName + " has been admitted to the Pet Shelter.");
                switch (petToAddSpecies) {
                    case "1":
                        myPetShelter.addPet(new OrganicCat(petToAddName, "a " + " organic cat", 50,
                                50, 25, 25, 0));
                        break;
                    case "2":
                        myPetShelter.addPet(new OrganicDog(petToAddName, "a " + " organic dog", 50,
                                50, 25, 25, 25, 0));
                        break;
                    case "3":
                        myPetShelter.addPet(new RoboticCat(petToAddName, "a " + " robotic cat", 50,
                                50, 25, 25));
                        break;
                    case "4":
                        myPetShelter.addPet(new RoboticDog(petToAddName, "a " + " robotic dog", 50,
                                50, 25, 25));
                        break;
                }

            } else if (userInput.equals("11")) {
                System.out.println("You want to adopt a pet. Enter the name of the pet you wish to adopt.");
                myPetShelter.listPetNamesAndDescriptions();
                String petToAdopt = input.nextLine();
                myPetShelter.adoptPet(petToAdopt);
                System.out.println("You have adopted a pet, Congratulations to you and " + petToAdopt);
                myPetShelter.tickAllPets();
            } else if (userInput.equals("0")) {
                System.out.println("Thanks for playing, Have a good day! Goodbye.");
                quit = true;
            } else {
                System.out.println("Sorry, that response was not recognized. Try again.");
            }
        }

    }

    private static void shelterOptions() {
        System.out.println("\nHere are our pets:\n" + myPetShelter.listPetNamesAndDescriptions()
                + "What would you like to do?\nPress 1 to check the status of all pets.   Press 2 to feed organic pets."
                + "\nPress 3 to give organic pets water.   Press 4 to play with a pet."
                + "\nPress 5 to walk the dogs.   Press 6 to clean the dog cages."
                + "\nPress 7 to clean the communal litter box.   Press 8 to oil all robotic pets."
                + "\nPress 9 to maintain a robotic pet.   Press 10 to add a pet to the shelter."
                + "\nPress 11 to adopt a pet.   Press 0 to quit.");
    }

}



