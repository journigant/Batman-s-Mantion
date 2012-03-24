/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room study, entrance, masterBedroom, masterCloset, lab, batCave, garage;
      
        // create the rooms
        study = new Room("outside the main entrance of the university");
        studyCloset = new Room("inside the study room closet");
        entranceHall = new Room("in a lecture theater");
        masterBedroom = new Room("in the campus pub");
        masterCloset = new Room("in the master closet");
        masterBathroom = new Room("in a computing lab");
        lab = new Room("in the lab");
        labCloset = new Room("inside the lab room closet");
        batCave = new Room("in the BatCave");
        garage = new Room("in the garage");
        
        // initialise room exits and creates items in the rooms
        entranceHall.setExit( "west", study );
        entranceHall.setExit( "east", masterBedroom );
        entranceHall.setExit( "down", batCave );
        masterBedroom.setExit( "east", masterBathroom );
        masterBedroom.setExit( "closet", masterCloset );
        masterCloset.setExit( "west", masterBedroom );
        masterBedroom.setExit( "west", entranceHall );
        masterBathroom.setExit( "west", masterBedroom );
        study.setExit( "down", lab );
        study.setExit( "east", entranceHall );
        study.setExit( "closet", studyCloset );
        studyCloset.setExit( "east", study );
        lab.setExit( "up", study );
        lab.setExit( "east", batCave );
        lab.setExit( "closet", labCloset );
        labCloset.setExit( "east", lab );
        batCave.setExit( "up", entranceHall );
        batCave.setExit( "west", lab );
        batCave.setExit( "east", garage );
        garage.setExit( "west", batCave );
        
        currentRoom = entranceHall;
        Player P1 = new Player("P1", 50);
        P1.setRoom(currentRoom);
        /*
        *Creates the Player and places them in the Entrance Hall of Batman's Mansion
        */
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Until next time...");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Gotham!");
        System.out.println("World of Gotham is a new, incredibly awesome adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());        
        describeRoom();
    }
    
    private void describeRoom(){
        System.out.println();
        currentRoom.describeExits();
        //Describes the Room
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some awesome, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the Mansion.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }
    
    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
       nextRoom= currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            System.out.println(currentRoom.getLongDescription());
            P1.setRoom(currentRoom);
        }
        //If exit is available, the player's room becomes the room the player
        //instructed to go to
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
