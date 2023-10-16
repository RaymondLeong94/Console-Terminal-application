package pleasework;
import java.util.ArrayList;
import java.util.List;
public class InventoryService {

    private List<Item> inventory; // Use a List instead of an array for dynamic sizing

    // Constructor initializes the inventory as an empty ArrayList
    public InventoryService() {
        inventory = new ArrayList<>();
    }

    // Return all the items in the inventory
    public List<Item> getAll() {
        if (inventory.size() == 0 ) {System.out.println("There are no current Items in your bag- Let's return to the main menu");}
        
		return inventory;
    }

    // Find and return the item with the given id
    // Return null if the item does not exist
    public Item getById(int id) {
        //loop through items
    	for (Item item : inventory) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // Create a new item and add it to the inventory
    // Returns true if the item is successfully added, false otherwise
    public boolean create(Item item) {
        // Check if an item with the same name already exists in the inventory
        for (Item existingItem : inventory) {
            if (existingItem.getName().equals(item.getName())) {
                System.out.println("Item with the same name already exists. please change the name of the item.");
                return false;
            }
        }

        // If no item with the same name exists, add the new item to the inventory
        return inventory.add(item);
    }

    // Update an existing item in the inventory
    // Returns true if the item is successfully updated, false if the item is not found
    public boolean update(Item updatedItem) {
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (item.getId() == updatedItem.getId() && !item.getName().equals(updatedItem.getName())) {
                inventory.set(i, updatedItem); 
                return true;
            }
        }
        System.out.println("Item Name cannot match ID");
        return false;
    }


    // Delete an item from the inventory by its id
    // Returns true if the item is successfully deleted, false if the item is not found
    public boolean delete(int id) {
        for (Item item : inventory) {
            if (item.getId()  == id) {
                inventory.remove(item);
                return true;
            }
        } 
        return false;
    }
}