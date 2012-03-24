/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Gotham" application. 
 * "World of Gotham" is a very awesome, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
import java.util.HashMap;
import java.util.ArrayList;
public class Room 
{
    public String description; 
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "Entrance Hall" or
     * "Master Bedroom".
     * Within those rooms there are exits and items, interactive objects a player may
     * carry with them to another room.
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new ArrayList<Item>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
    /*
    *available exits for a particular room
    */
    public void setExit(String direction, Room currentroom){
        exits.put(direction, currentroom);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * @return The description of the room.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
        /*if(direction.equals("north")) {
            return northExit;
        }
        if(direction.equals("east")) {
            return eastExit;
        }
        if(direction.equals("west")) {
            return westExit;
        }
        if(direction.equals("south")) {
            return southExit;
        }
        return null;
        */
    }
    public void describeExits(){
        
        System.out.print("Exits: ");
        if(this.getExit("north") != null) {
            System.out.print("north ");
        }
        if(this.getExit("east") != null) {
            System.out.print("east ");
        }
        if(this.getExit("south") != null) {
            System.out.print("south ");
        }
        if(this.getExit("west") != null) {
            System.out.print("west ");
        }
        if(this.getExit("up") != null) {
            System.out.print("up ");
        }
        if(this.getExit("down") != null) {
            System.out.print("down ");
        }
        if(this.getExit("closet") != null) {
            System.out.print("closet ");
        }
        System.out.println();
    }

    public void addItem(String Name, String Description, int Weight){
        Item theItem= new Item( Name, Description, Weight);
        items.add(theItem);
    }
    
    public void addItem(Item theItem){
        if (theItem != null){
            items.add(theItem);
        System.out.println(theItem.getName()+ " was added to room");
    }
}
    public Item removeItem(String itemName){
        Item currentItem = null; 
        for(Item item: items){
            if (item.getName().contains(itemName)){
                currentItem = item; 
                if (item.isCarriable){
                System.out.println(item.getName() +" was removed from room");
            }else if(!item.isCarriable){
                System.out.println(item.getName() +"is to heavy to pick up!");
                return null;
                
            }
        }
    }
        items.remove(currentItem);
        if ( currentItem == null){
            System.out.println("Item wasnt found");
            return null;
        }else{
            return currentItem;
        }
       
       
    
}

      /**
     * @return a long Description of the room in the form: You are in the "room". Your Exits are : "".
     */
     public void getLongDescription() {
       for(Item item: items){
           System.out.println("There is a " + item.getDescription() + ".\n");
        }   
       this.describeExits();
         
       

     }   
}
