package pleasework;
import java.util.Scanner;

public class Menu {
	//start with system in
    private static Scanner sc = new Scanner(System.in);
    //initiate with new service 
    private static InventoryService inventoryService = new InventoryService();

    public static void mainMenu() {
        boolean exit = false;

        System.out.println("Welcome to the Inventory CRUD Application!");

        while (!exit) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. List all inventory items");
            System.out.println("2. Get inventory item by ID");
            System.out.println("3. Create inventory item");
            System.out.println("4. Update inventory item");
            System.out.println("5. Delete inventory item");
            System.out.println("6. Exit");

            int input = sc.nextInt();
            sc.nextLine(); 

            switch (input) {
                case 1:
                    getAllItems();
                    break;
                case 2:
                    getItemById();
                    break;
                case 3:
                    createItem();
                    break;
                case 4:
                    updateItem();
                    break;
                case 5:
                    deleteItem();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("\nPlease enter an option listed (number 1 - 6)");
                    break;
            }
        }

        System.out.println("\nGoodbye!");
        sc.close();
    }
    //return the array after printing it all with getall
    private static void getAllItems() {
        for (Item item : inventoryService.getAll()) {
            System.out.println(item);
        }
    }
    //obtain input from user that is our id
    
    private static void getItemById() {
        System.out.print("Enter item ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the newline character left after nextInt()

        Item item = inventoryService.getById(id);
        //if the id for the item exist then return item: see inventory services
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item not found.");
        }
    }
    //open ai assisted with line 84 
    // cannot change increment i++ due to item establishment in Item
    private static void createItem() {
        System.out.print("Enter ID (starts with 1 and increment to 10):");
        int id = sc.nextInt();
        sc.nextLine();

        // make new item with just an ID 
        Item existingItem = inventoryService.getById(id);
        if (existingItem != null) {
            // Display current status if the id is already in array
            System.out.println("Item added: " + existingItem.getName() + ", Price: " + existingItem.getPrice());
            // ask for new quantity"
            System.out.print("Enter additional quantity: ");
            int additionalQuantity = sc.nextInt();
            sc.nextLine(); 

            // set new quantity using original function (current +  input = new)
            existingItem.setQuantity(existingItem.getQuantity() + additionalQuantity);
            System.out.println("New quantity: " + existingItem.getQuantity());
        } else {
            // Item with the given ID does not exist, proceed with creating a new item
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            sc.nextLine(); 

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); 

            Item newItem = new Item(id, name, price, quantity);
            boolean created = inventoryService.create(newItem);
            if (created) {
                System.out.println("Item created successfully.");
            } else {
                System.out.println("Failed to create item or Inventory might be full.");
            }
        }
    }

    //update via ID only
    private static void updateItem() {
        System.out.print("Enter item ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        Item item = inventoryService.getById(id);
        if (item != null) {
            System.out.print("Enter new Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter new Price: ");
            double price = sc.nextDouble();
            sc.nextLine(); 

            System.out.print("Enter new Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); 

            item.setName(name);
            item.setPrice(price);
            item.setQuantity(quantity);
            boolean updated = inventoryService.update(item);
            //run into issue of same id assigned to name
            if (updated ) {
                System.out.println("Item updated successfully.");
            } else {
                System.out.println("Unsucessful");
            }
        } else {
            System.out.println("Item not found.");
        }
    }
    // str del fx
    private static void deleteItem() {
        System.out.print("Enter item ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        boolean deleted = inventoryService.delete(id);
        if (deleted) {
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }
}