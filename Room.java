/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
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
    private HashMap<String, Item> items;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new HashMap<String, Item>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }
    public void setExits(String direction, Room currentroom){
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

    public void addItems(String Name, String Description, int Weight){
        Item theItem= new Item( Name, Description, Weight);
        items.put(theItem.getName(), theItem);
    }
    public void removeItems(String itemName){
       items.remove(itemName);
    }

      /**
     * @return a long Description of the room in the form: You are in the "room". Your Exits are : "".
     */
     public String getLongDescription() {
       return "You are in the" + description. + ".\n" 
       for ( Item item: items){
       "You have an" + item.getName(). + ".\n" 
       } this.describeExits();
         
       

     }   
}
