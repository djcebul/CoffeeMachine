package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static final int WATER_AMOUNT_ESPRESSO = 250;
    static final int COFFEE_AMOUNT_ESPRESSO = 16;
    static final int WATER_AMOUNT_LATTE = 350;
    static final int MILK_AMOUNT_LATTE = 75;
    static final int COFFEE_AMOUNT_LATTE = 20;
    static final int WATER_AMOUNT_CAPPUCCINO = 200;
    static final int MILK_AMOUNT_CAPPUCCINO = 100;
    static final int COFFEE_AMOUNT_CAPPUCCINO = 12;
    static final int COST_ESPRESSO = 4;
    static final int COST_LATTE = 7;
    static final int COST_CAPPUCCINO = 6;

    static int water = 400, milk = 540, coffeeBeans = 120, cups = 9, money = 550;
    static boolean error = false;

    static void zapasy(int selection) {
        if (selection == 1) {
            if (water >= WATER_AMOUNT_ESPRESSO && coffeeBeans >= COFFEE_AMOUNT_ESPRESSO) {
                System.out.println("I have enough resources, making you a coffee!");
                error = false;
            }
            else if (water < WATER_AMOUNT_ESPRESSO) {
                System.out.println("Sorry, not enough water!");
                error = true;
            }
            else {
                System.out.println("Sorry, not enough coffee!");
                error = true;
            }
        }
        else if (selection == 2) {
            if (water >= WATER_AMOUNT_LATTE && coffeeBeans >= COFFEE_AMOUNT_LATTE && milk >= MILK_AMOUNT_LATTE) {
                System.out.println("I have enough resources, making you a coffee!");
                error = false;
            }
            else if (water < WATER_AMOUNT_LATTE) {
                System.out.println("Sorry, not enough water!");
                error = true;
            }
            else if (milk < MILK_AMOUNT_LATTE) {
                System.out.println("Sorry, bot enough milk!");
                error = true;
            }
            else {
                System.out.println("Sorry, not enough coffee!");
                error = true;
            }
        }
        else if (selection == 3) {
            if (water >= WATER_AMOUNT_CAPPUCCINO && coffeeBeans >= COFFEE_AMOUNT_CAPPUCCINO && milk >= MILK_AMOUNT_CAPPUCCINO) {
                System.out.println("I have enough resources, making you a coffee!");
                error = false;
            }
            else if (water < WATER_AMOUNT_CAPPUCCINO) {
                System.out.println("Sorry, not enough water!");
                error = true;
            }
            else if (milk < MILK_AMOUNT_CAPPUCCINO) {
                System.out.println("Sorry, bot enough milk!");
                error = true;
            }
            else {
                System.out.println("Sorry, not enough coffee!");
                error = true;
            }
        }

//
    }

    public static void main(String[] args) {
        var s = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String selection = s.next();
            switch (selection) {
                case "buy" :
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String select = s.next();
                    if (select.equals("back")) continue;
                    else {
                        if (!error) zapasy(Integer.parseInt(select));
                        else continue;
                        select(Integer.parseInt(select));
                    }
                    break;
                case "fill" :
                    fill();
                    break;
                case "take" :
                    if (money == 0) System.out.println("There is no money!");
                    else {
                        System.out.println("I gave you " + money);
                        money = 0;
                    }
                    break;
                case "remaining" :
                    stan();
                    break;
                case "exit" :
                    System.exit(0);
                    break;
                default :
                    System.out.println("Podaj poprawna wartosc");
                    break;

            }


        }
    }
    static void fill() {
        var scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        int temp = scanner.nextInt();
        water += temp;
        System.out.println("Write how many ml of milk you want to add:");
        temp = scanner.nextInt();
        milk += temp;
        System.out.println("Write how many grams of coffee beans you want to add:");
        temp = scanner.nextInt();
        coffeeBeans += temp;
        System.out.println("Write how many disposable cups of coffee you want to add:");
        temp = scanner.nextInt();
        cups += temp;
    }

    static void select(int choice) {
            if (choice == 1) {
                water -= WATER_AMOUNT_ESPRESSO;
                coffeeBeans -= COFFEE_AMOUNT_ESPRESSO;
                cups--;
                money += COST_ESPRESSO;
            }
            else if (choice == 2) {
                water -= WATER_AMOUNT_LATTE;
                milk -= MILK_AMOUNT_LATTE;
                coffeeBeans -= COFFEE_AMOUNT_LATTE;
                cups--;
                money += COST_LATTE;
            }
            else if (choice == 3) {
                water -= WATER_AMOUNT_CAPPUCCINO;
                milk -= MILK_AMOUNT_CAPPUCCINO;
                coffeeBeans -= COFFEE_AMOUNT_CAPPUCCINO;
                cups--;
                money += COST_CAPPUCCINO;
            }
    }

    static void stan() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water\n" + milk + " ml of milk\n" + coffeeBeans +
                " g of coffee beans\n" + cups + " disposable cups\n" + "$" + money + " of money");
    }

    static void kolejnosc() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

//    static void ilosc() {
//        var scanner = new Scanner(System.in);
//        System.out.println("Write how many cups of coffee you will need");
//        int cups = scanner.nextInt();
//        int water = WATER_AMOUNT * cups;
//        int milk = MILK_AMOUNT * cups;
//        int coffeeBeans = COFFEE_AMOUNT * cups;
//
//        System.out.println("For " + cups + " cups of coffee you will need:");
//        System.out.println(water + " ml of water\n" + milk + " ml of milk\n" + coffeeBeans + " g of coffee beans");
//
//    }


}
//System.out.println("Write how many ml of water the coffee machine has:");
//        water = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        milk = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        coffee = scanner.nextInt();
//        System.out.println("Write how many cups of coffee you will need: ");
//        cup = scanner.nextInt();
//    int fromWater = water / WATER_AMOUNT;
//        int fromMilk = milk / MILK_AMOUNT;
//        int fromCoffee = coffee / COFFEE_AMOUNT;
//
//        int iloscKaw = Math.min(fromWater, Math.min(fromMilk, fromCoffee));
//
//        if (iloscKaw > cup) {
//            System.out.println("Yes, I can make that amount of coffee (and even " + (iloscKaw - cup) + " more than that)");
//        }
//        else if (iloscKaw == cup) System.out.println("Yes, I can make that amount of coffee");
//        else System.out.println("No, I can make only " + iloscKaw + " cup(s) of coffee");

//        else if (selection.equals("fill")) {
//            System.out.println("Write how many ml of water you want to add:");
//            int temp = scanner.nextInt();
//            water += temp;
//            System.out.println("Write how many ml of milk you want to add:");
//            temp = scanner.nextInt();
//            milk += temp;
//            System.out.println("Write how many grams of coffee beans you want to add:");
//            temp = scanner.nextInt();
//            coffeeBeans += temp;
//            System.out.println("Write how many disposable cups of coffee you want to add:");
//            temp = scanner.nextInt();
//            cups += temp;
//
//        }
//        else if (selection.equals("take")) {
//            System.out.println("I gave you " + money);
//            money = 0;
//        }