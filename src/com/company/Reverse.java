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

    /**
     * Returns true if the reverse was successful.
     * @param file The File to reverse
     * @return True if the file was reversed.
     */
    public boolean reverseFile(File file) {
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

    public boolean reverseFile(String filePath) {
        return reverseFile(new File(filePath));
    }
}
