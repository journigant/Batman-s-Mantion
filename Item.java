
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Item
{
    // instance variables - replace the example below with your own
    private int weight;
    private String name;
    private String description; 
    private boolean isCarriable;

    /**
     * Constructor for objects of class Item
     */
    public Item(String Name, String Description, int Weight)
    {
        weight = Weight;
        name = Name;
        description = Description;
        if (weight<10){
            isCarriable = true;
        } else{
            isCarriable = false;
        }
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getDescription()
    {        
        return description;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getName()
    {        
        return name;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getWeight()
    {        
        return description;
    }
}
