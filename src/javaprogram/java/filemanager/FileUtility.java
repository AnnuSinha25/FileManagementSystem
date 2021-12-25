package javaprogram.java.filemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtility
{
	public static void createFile(String paramString1, String paramString2)
    throws IOException
	{
    try
    {
      File localFile = new File(paramString1);
      
      if (!localFile.exists())
      {
        localFile.createNewFile();
      }
      
      FileWriter localFileWriter = new FileWriter(paramString1);
      BufferedWriter localBufferedWriter = new BufferedWriter(localFileWriter);
      localBufferedWriter.write(paramString2);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      
      System.out.println("\nFile " + paramString1 + " has been created successfully..!\n");

    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static void deleteFile(String paramString)
  {
    File localFile = new File(paramString);
    
    if (localFile.isFile())
    {
      if (localFile.delete())
      {
        System.out.println("\nFile successfully deleted..!\n");
      }
      else
      {
        System.out.println("\nThere is some issue deleting the file\n");
      }
      
    }
    else {
      System.out.println("\nFile not found\n");
    }
  }
  
  public static void viewDirectory(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile1 = paramFile.listFiles();
      System.out.println("\n" + paramFile.getName());
      if (arrayOfFile1 != null)
      {
        for (File localFile : arrayOfFile1)
        {
          System.out.println("\t->" + localFile.getName());
        }
        System.out.println("\n");
      }
      else
      {
        System.out.println("\nNo Sub-Folders..!\n");
      }
    }
    else
    {
      System.out.println("\nInvalid Directory..!\n");
    }
  }
 }
