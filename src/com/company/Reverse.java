package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Homer on 11/27/14.
 */
public class Reverse
{

    /** This takes in a text file and attempts to reverse it by line.
     *
     * @param file - The playlist text file of iTunes songs.
     * @return - True if the text file was reversed.
     */
    public boolean reverseFile(File file)
    {
        FileReader reader = new FileReader();
        List<String> songStrings = reader.read(file);

        String columnNames = songStrings.remove(0);

        Collections.reverse(songStrings);

        int numberOfSongs = songStrings.size();

        try
        {
            System.out.println("directory: " + file.getParent());

            BufferedWriter bf = new BufferedWriter(new FileWriter(file));

            bf.write(columnNames + "\n");
            int i = 0;

            for (String song : songStrings)
            {
                bf.write(song + "\n");
                i++;
            }
            bf.close();

            return i == numberOfSongs;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    /** Uses the passed parameter as a filepath string to create a new file and pass it to the other reverseFile method.
     *
     * @param filePath - the filepath as a string
     * @return - whether or not the reversal process was successful
     */
    public boolean reverseFile(String filePath)
    {
        return reverseFile(new File(filePath));
    }
}
