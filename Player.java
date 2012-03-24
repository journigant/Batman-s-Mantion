/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
public class Player
{
    // instance variables - replace the example below with your own
    private String name;
    private Room currentRoom;
    private int maxWeight;
    private int currentWeight = 0;
    public ArrayList<Item> bookbag;

    /**
     * Constructor for objects of class Player
     */
    public Player( String Name, int Weight)
    {
        name = Name;
        maxWeight = Weight;
        bookbag= new ArrayList<Item>();
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
        return currentRoom;
    }

    public Item getItem(String theItem)
    {
        for(Item item: bookbag){
            if (item.getName() == theItem){
                return item;
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
        if( theItem != null){
            if(theItem.isCarriable){
                currentWeight = theItem.getWeight() + currentWeight;
                if(currentWeight>=maxWeight){
                    System.out.println("You cant carry any more weight!");
                    currentWeight= currentWeight - theItem.getWeight();
                }else if (currentWeight<maxWeight){
                    bookbag.add(theItem);
                    System.out.println(theItem.getName() + " added to bookbag");
                }else{
                System.out.println("Nothing was picked up");
            }
        }else{
            System.out.println("Item was too heavy");
        }
    }
}

    public Item dropItem(String theItem)
    {
        Item currentItem = null;
        Item droppedItem = null;
        for(Item item: bookbag){
            if (item.getName().contains(theItem)){
                currentItem = item;      
            }
        }
        if (currentItem != null){
            currentWeight= currentWeight -currentItem.getWeight();       
            for(Item item: bookbag){
                if (item.getName().contains(theItem)){
                    
                    droppedItem= item;
                    System.out.println(item.getName() + " removed from bookback");
                }
            }
            bookbag.remove(droppedItem);
        }else{
            System.out.println("You don't have that item");
        }
        return droppedItem;
    }

}

