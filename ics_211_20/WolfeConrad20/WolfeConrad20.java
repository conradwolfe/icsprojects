import javax.swing.JOptionPane; 
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
/**
* View, edit, and export data from a queue to file using a GUI, and text files from the user. 
* Also make inprovements on the code from assignment 19.
* 
* @author         Wolfe, Conrad
* @assignment     ICS 211 Assignment 20
* @date           12/08/17
*/
public class WolfeConrad20{

/**
* The "main" method starts the program
*
* @param args Takes 2 file names as the commandline input. 
              The first file name (args[0]) is the input file. 
              The second file name (args[1]) is the output file. 
*/	
   public static void main(String[] args) {
   //error checking for command line input
      checkInput(args);
      MyQueue<String> queue = readFileAddToQueue(args[0]);
      queue = displayMenu(queue);
      writeQueueToFile(args[1], queue);
   }// end of main

/**
* Reads data from input file and stores it in a MyQueue object
*   
* @param queue takes a string of a file contianing names
*/
   public static MyQueue<String> readFileAddToQueue(String input){
      MyQueue<String> queue = new MyQueue<String>();
   //your code goes here
      String line = "";
      File file = new File(input);
      Scanner reader = null;
   //connect to file
      try{
         reader = new Scanner(file);
      }
      catch(FileNotFoundException fnfe){
         JOptionPane.showMessageDialog(null,"The file \"" + input + "\" was not found.", "Error!", 
         JOptionPane.WARNING_MESSAGE);
         System.exit(0);
      }
   //loops through while scanner has tokens and builds queue
      while(reader.hasNext()){
         line = reader.nextLine();
         queue.offer(line);
      }
      return queue;
   }   
	
/**
* Displays a JOptionPane Menu that interacts with the given queue
*   
* @param queue takes a MyQueue object to interact with via the menu
*/
   public static MyQueue<String> displayMenu(MyQueue<String> queue){
   //your code goes here
      int choice = 0;
      boolean run = true;
      String message = "";
      String[] array = {"Offer Person", "Poll Person", "Peek Person",
                        "Display List", "Exit Program"};
   
      while(run){
         choice = JOptionPane.showOptionDialog(null, // put in center of screen
                  "Press a Button", // message to user
                  "Queue (line) of People", // title of window
                  JOptionPane.YES_NO_CANCEL_OPTION, // type of option
                  JOptionPane.QUESTION_MESSAGE, // type of message
                  null, // icon
                  array, // array of strings
                  array[array.length - 1]); // default choice (last one)
                  
   //switch statement for menu interaction.               
         switch(choice){
            case -1: System.exit(0);
            
            case 0: message = JOptionPane.showInputDialog(null, "Enter person's name");
                    queue.offer(message);
                    break;
                    
            case 1: if(queue.empty()){
                       JOptionPane.showMessageDialog(null," There in no one in line.", "Message", 
                       JOptionPane.INFORMATION_MESSAGE);
                    }else{
                       message = queue.poll();
                       JOptionPane.showMessageDialog(null, message + " is next in line.", "Message", 
                       JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
            
            case 2: if(queue.empty()){
                       JOptionPane.showMessageDialog(null," There in no one in line.", "Message", 
                       JOptionPane.INFORMATION_MESSAGE);
                    }else{
                       message = queue.peek();
                       JOptionPane.showMessageDialog(null, message + " is in front of the line.", "Message", 
                       JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
            
            case 3: message = queue.toString();
                    JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
                    break;
                    
            case 4: run = false;
                    break;
          }
      }
      return queue;
   }
	
/**
* Writes contents of queue to given output file.
*   
* @param filename takes the String filename to be written to
* @param queue takes the MyQueue object containing the data to be written to file
*/  
   public static void writeQueueToFile(String filename, MyQueue<String> queue){
      File fileOut = new File(filename);
      PrintWriter writer = null;
   //your code goes here
   //attempt to connect to ouput file
      try{   
         writer = new PrintWriter(fileOut);
      }catch(FileNotFoundException fnfe){
         JOptionPane.showMessageDialog(null,"The file \"" + filename + "\" was not found, and could not be created.", 
         "Error!", JOptionPane.WARNING_MESSAGE);
         System.exit(0);
      }
   //writes data in queue to the given output file
         writer.write(queue.toString());
         writer.flush();
   }
   
/**
* Verifies that there is command line input, and that there are two elements in the command line.
* If the input is incorrect exits the program.
*   
* @param inputArray takes an array of Strings
*/  
   public static void checkInput(String[] inputArray){
   //Change the value of argsLength to the amount of desired command line inputs
      int argsLength = 2;
      int missingInput = 0;
      if(inputArray.length == 0){
         JOptionPane.showMessageDialog(null, "No file name was inputted into the command line. " +
                                             "Please enter a valid file name.", "Error!", 
                                             JOptionPane.WARNING_MESSAGE);
         System.exit(0);
      }else if(inputArray.length < argsLength){
         missingInput = argsLength - inputArray.length;
         JOptionPane.showMessageDialog(null, "You are missing " + missingInput + " command line input(s).\n" +
                                       "Please enter " + argsLength + " file(s) into the command line.", 
                                       "Error!", JOptionPane.WARNING_MESSAGE);
         System.exit(0);
      }else if(inputArray.length > argsLength){
         JOptionPane.showMessageDialog(null, "Too many command line inputs.\n" +
                                       "Only enter " + argsLength + " file(s) into the command line.", 
                                       "Error!", JOptionPane.WARNING_MESSAGE);
         System.exit(0);
      }
   }//end checkInput method   
}//end of class WolfeConrad20

/**
* MyQueue extends class LinkedQueue adding a toString functionality.
* 
*/
class MyQueue<T> extends LinkedQueue<T>{

/**
* Constructs a MyQueue linked queue that can be used to display a linked queue as a string.
* 
*/
   public MyQueue(){
      super();
   }
   
/**
* Convers the linked queue into a string
* 
* @returns a string containing the data in the object
*/
   public String toString(){
      String output = "";
   //loop through nodes and compile a string for output
      Node loopingNode = endNode;
   //prevents NullPointerException from being thrown if the queue is empty
      if(loopingNode == null){
         output = "There in no one in line.";
      }else{
         while(loopingNode.getNext() != endNode){
            loopingNode = loopingNode.getNext();
            output += loopingNode.getData() + "\n";
         }  
   //when there is only one item left in the queue the loop will not execute because the next node is itself,
   //so this needs to be outside of the loop to ensure that it is added to the output       
         output += endNode + "\n";System.out.println(output);
      }
      return output;            
   }   
}//end of class MyQueue<T>