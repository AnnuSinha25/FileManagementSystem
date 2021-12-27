package javaprogram.java.filemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Annu Sinha
 *
 */
public class FileUtility {
	/*
	 * Create directory for file operations.
	 */
	
	public static String directory ="c:\\temp1";
	
	public static void CreateDirectory() {
		File dir = new File(directory);
		if (!dir.exists()){
			dir.mkdirs();
		}
	}
	
	/**
	 * @param paramString1
	 * @param paramString2
	 * @throws IOException
	 */
	public static void createFile(String paramString1, String paramString2) throws IOException {
		try {
			File localFile = new File(directory + "\\" + paramString1);

			if (!localFile.exists()) {
				localFile.createNewFile();
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(localFile))) {
			        bw.write(paramString2);
				    bw.newLine();
				}
				
				System.out.println("\nFile " + paramString1 + " has been created successfully..!\n");
			}
			else {
				System.out.println("\nFile " + paramString1 + " already exists. Enter another file name..!\n");
			}
		} catch (IOException localIOException) {
			localIOException.printStackTrace();
		}
	}

	/**
	 * @param paramString
	 */
	public static void deleteFile(String paramString) {
		File localFile = new File(directory + "\\" + paramString);

		if (localFile.isFile()) {
			if (localFile.delete()) {
				System.out.println("\nFile successfully deleted..!\n");
			} else {
				System.out.println("\nThere is some issue deleting the file\n");
			}

		} else {
			System.out.println("\nFile not found\n");
		}
	}

	/**
	 * @param paramString
	 */
	public static void searchFile(String paramString) {
		if(paramString != null && !paramString.trim().isEmpty()) {
	        // Create an object of the File class
	        // Replace the file path with path of the directory
	        File dir = new File(directory);
	  
	        // Create an object of Class MyFilenameFilter
	        // Constructor with name of file which is being
	        // searched
	        FileFilter filter = new FileFilter(paramString);
	  
	        // store all names with same name 
	        // with/without extension
	        String[] flist = dir.list(filter);
	        
	        // Empty array
	        if (flist == null || flist.length == 0) {
	            System.out.println("No files found..\n");
	        }
	        else {
	  
	            // Print all files with same name in directory
	            // as provided in object of MyFilenameFilter
	            // class
	        	System.out.println(flist.length + " files found..\n");
	            for (int i = 0; i < flist.length; i++) {
	                System.out.println(flist[i]+" found with contents: \n");
	                Path path = Paths.get(directory + "\\" + flist[i]);
	                try {
						String content = Files.readString(path, StandardCharsets.US_ASCII);
						System.out.println(content);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
                System.out.println("\n");
	        }			
		} else {
			System.out.println("\nInvalid File Name..!\n");
		}
	}

	public static void getExtension() {
		// TODO Auto-generated method stub
		
	}

	public static String getExtension(String fileName) {
		String[] tokens = fileName.split("\\.(?=[^\\.]+$)");
		//String file = str2.substring(str2.lastIndexOf("/"));
		//String fileName = file.substring(file.indexOf("."));
		//String extension = file.substring(file.lastIndexOf("."));
		String extension = "";
		if(tokens.length < 2) {
			extension = "txt";
		}
		else {
			extension = tokens[1];
		}

		return String.join(".", tokens[0], extension);
	}
}
