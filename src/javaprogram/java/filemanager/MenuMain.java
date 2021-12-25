package javaprogram.java.filemanager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MenuMain
{
  public static void main(String args[]) throws IOException
  {
	Scanner localScanner = new Scanner(System.in);
    String str1 = "";
    
    String str2 = "";
    
    do
    {
      System.out.println("*** Welcome To File Management System ***");
      System.out.println("*** Developed by Annu Sinha ***");
      System.out.println("1. Create file");
      System.out.println("2. Delete file");
      System.out.println("3. View Files in a Directory");
      System.out.println("4. Exit");
      System.out.println("**********************************************");
      System.out.println("Please enter your choice: ");
      
      str1 = localScanner.next();
      
      localScanner = new Scanner(System.in);
      String str4; Object localObject;
      switch (str1)
      {

      case "1": 
        System.out.println("Enter the file path where you want to create the file: ");
        str2 = localScanner.nextLine();
        
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");
        }
        else
        {
          System.out.println("Enter the content :");
          str4 = localScanner.nextLine();
          FileUtility.createFile(str2, str4);
        }
        
        break;
    
      case "2": 
        System.out.println("Enter the path of the file which you want to delete ");
        str2 = localScanner.nextLine();
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");
        }
        else
        {
          FileUtility.deleteFile(str2);
        }
        break;
      
      case "3": 
        System.out.println("Enter the directory you want to view ");
        str4 = localScanner.nextLine();
        if (str4.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");

        }
        else
        {
          localObject = new File(str4);
          FileUtility.viewDirectory((File)localObject);
        }
        break;
      
      case "4":
    	  System.exit(0);
    	  break;
    	  
      default: 
        System.out.print("\nInvalid Choice\n ");
      }
      
    } while (str1 != "4");
  }
}
