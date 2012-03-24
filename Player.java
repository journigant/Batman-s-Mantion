/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 

import java.util.HashMap;

public class Player
{
    // instance variables - replace the example below with your own
    private String name;
    private Room currentRoom;
    private int maxWeight;
    private int currentWeight
    private HashMap<String, Item> bookbag;

    /**
     * Constructor for objects of class Player
     */
    public Player( String Name, int Weight)
    {
       name = Name;
       maxWeight = Weight;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
     public int getMaximumWeight()
    {
        // put your code here
        return maxWeight;
    }
    
     public Room getRoom()
    {
        // put your code here
        return name;
    }
    public Item getItem(String theItem)
    {
        for(Item item: bookbag){
            if (item = theItem){
                return item
            }
        }
        return null;
    }
    public void setRoom(Room nextRoom)
    {
        currentRoom = nextRoom;
    }
    public void pickUpItem(Item theItem)
    {
        currentWeight= theItem.getWeight() + currentWeight;
        if(currentWeight>=maxWeight){
             System.out.println(You cant carry any more weight!);
             currentWeight= currentWeight - theItem.getWeight();
        }else (currentWeight<maxWeight){
            bookbag.put(theItem.getName(), theItem)
        }
       
    }
    public void dropItem(Item theItem)
    {
        currentWeight= currentWeight -theItem.getWeight();       
        for(Item item: bookbag){
            if (item = theItem){
                bookbag.remove(item);
            }
        }
        
    }
    
}
