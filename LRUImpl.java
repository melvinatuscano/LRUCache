import java.util.Scanner;
import java.io.*;

/**
 * LRUImpl class
 */
class LRUImpl
{
    /**
     * Main method entry point   
     */
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String command="";
        LRUCache lc=null;
        //Wait for exit command
        while(!command.equals("EXIT"))
        {
           command= sc.nextLine();
           String[] tokens=command.split(" ");
           switch(tokens[0])
           {
               // Process size command
               case "SIZE":
                if(lc==null)
                {
                    try
                    {
                        lc=new LRUCache(Integer.parseInt(tokens[1]));
                        System.out.println("SIZE OK");
                    }
                    catch(NumberFormatException e)
                    {
                      //System.out.println("BAD COMMAND.Invalid Size.");
                      System.out.println("ERROR");
                    }
                }
                else
                     System.out.println("ERROR");
                break;
                // Process set command
                case "SET":
                    if(tokens.length!=3)
                        System.out.println("ERROR");
                    else
                        {
                            lc.set(tokens[1],tokens[2]);
                            System.out.println("SET OK");
                        }
                break;
                // Get command processing
                case "GET":
                    if(tokens.length!=2)
                        System.out.println("ERROR");
                    else
                        {    
                            try{                       
                                System.out.println("GOT "+lc.get(tokens[1]));
                            }catch(IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }
                        }
                break;
                // Place holder for exit command so we dont print error message
                case "EXIT":
                break;
                default:
                 // System.out.println("Invalid command - valid commands are SIZE,SET,GET");
                 System.out.println("ERROR");
                break;

           }
        }


    }
}