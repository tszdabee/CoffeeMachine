import java.util.Scanner;

class drink { // Define class to hold individual drink values and machine count.
    int water, milk, coffee, cup, price;
    public drink(int water, int milk, int coffee, int cup, int price) { // Constructor for drinks for initialization
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cup = cup;
        this.price = price;
    }
    public void makeCoffee(drink count) { // Use machine count object as input, used to modify count values directly. Can take desired object input and object count inputs.
        if(count.water - water < 0) { // Insufficient water
            System.out.println("Sorry, not enough water!");
        }else if(count.milk - milk < 0) { // Insufficient milk
            System.out.println("Sorry, not enough milk!");
        }else if(count.coffee - coffee < 0) { // Insufficient coffee
            System.out.println("Sorry, not enough coffee!");
        }else if(count.cup - cup < 0){ // Insufficient cups
            System.out.println("Sorry, not enough cups!");
        }else { // Successful purchase, deduct appropriate amounts from machine count
            System.out.println("I have enough resources, making you a coffee!");
            count.price += price;
            count.cup -= 1;
            count.water -= water;
            count.milk -= milk;
            count.coffee -= coffee;
        }
    }
    public void status() { //Method to print object status, but only used for machine count
        System.out.println("\nThe coffee machine has\n"
                + water + " ml of water\n"
                + milk + " ml of milk\n"
                + coffee + " g of coffee beans\n"
                + cup + " disposable cups\n"
                + "$" + price + " of money\n");
    }
}
public class CoffeeMachine {
    public static void main(String[] args) {
        // initialize and declare variables
        drink count = new drink(400,540, 120, 9, 550); // Overall machine count
        drink espresso = new drink(250, 0, 16, 1, 4); // Espresso values
        drink latte = new drink(350, 75, 20, 1, 7); // Latte count
        drink cappuccino = new drink(200, 100, 12, 1, 6); // Cappuccino count
        Scanner scanner = new Scanner(System.in);

        boolean machine = true; // Machine on, execute loop until user exit
        while(machine) {
            System.out.println("Write action (buy, fill, take, remaining, exit):"); // Determine user desired actions
            String action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino"); // User selects coffee type to purchase
                    String buy_action = scanner.next();
                    switch (buy_action) {
                        case "1": espresso.makeCoffee(count); // Espresso purchased
                            break;
                        case "2": latte.makeCoffee(count); // Latte purchased
                            break;
                        case "3": cappuccino.makeCoffee(count); // Cappuccino purchased
                            break;
                        default: // If user inputs back will return to main
                            break;
                    }
                    System.out.println();
                    break;
                case "fill": // User wants to fill machine
                    System.out.println("\nWrite how many ml of water you want to add:");
                    count.water += scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    count.milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    count.coffee += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    count.cup += scanner.nextInt();
                    System.out.println();
                    break;
                case "take": // User takes money from machine
                    System.out.println("\nI gave you $" + count.price + "\r\n");
                    count.price = 0;
                    break;
                case "remaining": // User displays remaining machine counts
                    count.status(); // Print final status
                    break;
                case "exit": // User exits from program
                    machine = false; // Exits from while loop, program completes execution
                    break;
                default: // Returns to main menu if for any other input
                    break;
            }
        }
    }
}