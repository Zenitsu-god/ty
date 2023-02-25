import java.sql.*; 
import java.rmi.*; 
import java.io.*; 
import java.util.*; 
import java.util.Vector.*; 
import java.lang.*; 
import java.rmi.registry.*;

public class ClientMPI 
{ 
    static String name1,name2,name3; 
    public static void main(String args[])
    {
        ClientMPI c=new ClientMPI();
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in)); 
        int ch; 
        
        try
        {
            Registry r1 = LocateRegistry.getRegistry("localhost",1030); 
            DBInterface DI = (DBInterface)r1.lookup("DBServ");

            do
            {
                System.out.println("\n\t\t*** Menu ***");
                System.out.print("\n 1.Send Input Strings");
                System.out.print("\n 2.Display Reversed String ");
                System.out.print("\n Enter your choice:");
                ch=Integer.parseInt(b.readLine()); 
                
                switch(ch) 
                {
                    case 1: 
                    {
                    System.out.print("Enter First String :"); 
                    name1=b.readLine();
                    name3=DI.input(name1); 
                    break;
                    } 
                    case 2: 
                    {
                    System.out.println("\nReversed String = "+name3);
                    break;
                    }
                }
            }while(ch > 0);
        }
        catch(Exception e)
        {
            System.out.println("ERROR:"+e.getMessage());
        }
    }
} 