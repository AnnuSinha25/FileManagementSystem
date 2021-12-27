package javaprogram.java.filemanager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Annu Sinha
 * This program implements the create, delete and view files.
 */
public class MenuMain {
	/**
	 * @param args
	 * @throws IOException
	 */
	
	private static Scanner localScanner;

	public static void main(String args[]) throws IOException {
		
		FileUtility.CreateDirectory();
		localScanner = new Scanner(System.in);
		String str1 = "";

		String str2 = "";

		do {
			System.out.println("*** Welcome To File Management System ***");
			System.out.println("*** Developed by Annu Sinha ***");
			System.out.println("1. Create file");
			System.out.println("2. Delete file");
			System.out.println("3. Search file");
			System.out.println("4. Exit");
			System.out.println("**********************************************");
			System.out.println("Please enter your choice: ");

			str1 = localScanner.next();

			localScanner = new Scanner(System.in);
			String str4;
			switch (str1) {

			case "1":
				System.out.println("Enter the file name to create the file : ");
				str2 = localScanner.nextLine();
				if (str2.isEmpty()) {
					System.out.println("\nInvalid input..!\n");
				} else {
					str2 = FileUtility.getExtension(str2);
					System.out.println("Enter the content :");
					str4 = localScanner.nextLine();
					FileUtility.createFile(str2, str4);
				}

				break;

			case "2":
				System.out.println("Enter the file name which you want to delete: ");
				str2 = localScanner.nextLine();
				if (str2.isEmpty()) {
					System.out.println("\nInvalid input..!\n");
				} else {
					FileUtility.deleteFile(str2);
				}
				break;

			case "3":
				System.out.println("Enter the file you want to search: ");
				str4 = localScanner.nextLine();
				if (str4.isEmpty()) {
					System.out.println("\nInvalid input..!\n");
				} else {
					FileUtility.searchFile(str4);
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
