package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Homer on 11/27/14.
 */
public class FileReader
{
    public List<String> read(String fileName)
    {
        return read(new File(fileName));
    }

    public List<String> read(File file)
    {

        List<String> songStrings = new ArrayList<>(1000);

        try
        {
            System.out.println("*******");
            Scanner input = new Scanner(file);
            while (input.hasNext())
            {
                String line = input.nextLine();
                if (!line.equals(""))
                    songStrings.add(line);
            }
            input.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return songStrings;
    }

}
