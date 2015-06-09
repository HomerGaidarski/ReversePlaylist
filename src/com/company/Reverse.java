package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Homer on 11/27/14.
 */
public class Reverse
{
    private boolean wasSuccessful;

    public Reverse(String textFile)
    {
        FileReader reader = new FileReader(textFile);
        ArrayList<String> songStrings = reader.read();

        String columnNames = songStrings.remove(0);

        Collections.reverse(songStrings);

        try
        {
            File inputFile = new File(textFile);
            System.out.println("directory: " + inputFile.getParent());

            FileWriter writer = new FileWriter(textFile);
            BufferedWriter bf = new BufferedWriter(writer);

            bf.write(columnNames + "\n");
            int i = 0;

            for (String song : songStrings)
            {
                bf.write(song + "\n");
                i++;
            }
            bf.close();
            this.isSuccessful(i, reader.getNumOfSongs());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void isSuccessful(int reversedSongs, int numOfSongs)
    {
        if (reversedSongs == numOfSongs)
            this.wasSuccessful = true;
        else
            this.wasSuccessful = false;
    }

    public boolean wasSuccessful()
    {
        return this.wasSuccessful;
    }
}
