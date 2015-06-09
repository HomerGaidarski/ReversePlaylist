package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Homer on 11/27/14.
 */
public class FileReader
{
    private String fileName;
    private int numOfSongs;

    public FileReader(String fileName)
    {
        this.fileName = fileName;
    }

    public ArrayList<String> read()
    {

        ArrayList<String> songStrings = new ArrayList<String>(1000);

        File textFile = new File(this.fileName);
        try
        {
            System.out.println("*******");
            Scanner input = new Scanner(textFile);
            while (input.hasNext())
            {
                String line = input.nextLine();
                if (!line.equals(""))
                    songStrings.add(line);
            }
            input.close();

            this.numOfSongs = songStrings.size() - 1;
            System.out.println(this.numOfSongs);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return songStrings;
    }

    public int getNumOfSongs()
    {
        return this.numOfSongs;
    }
}
