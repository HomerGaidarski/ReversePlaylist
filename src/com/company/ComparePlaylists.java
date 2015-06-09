package com.company;

import java.util.ArrayList;

/**
 * Created by Homer on 5/19/15.
 */
public class ComparePlaylists
{
    public ComparePlaylists(String filePath1, String filePath2)
    {
        FileReader reader1 = new FileReader(filePath1);
        FileReader reader2 = new FileReader(filePath2);
        ArrayList<String> songStrings1 = reader1.read();
        ArrayList<String> songStrings2 = reader2.read();

        ArrayList<String> songs1 = new ArrayList<String>();
        for (String song : songStrings1)
        {
            String[] strArray = song.split("\t");
            String newSong = "";
            for (int i = 0; i < strArray.length; i++)
            {
                try {
                    Integer.parseInt(strArray[i]);
                    break;
                }catch(NumberFormatException nfe)
                {
                    newSong += strArray[i];
                }
            }

            songs1.add(newSong);
        }
        ArrayList<String> songs2 = new ArrayList<String>();
        for (String song : songStrings2)
        {
            String[] strArray = song.split("\t");
            String newSong = "";
            for (int i = 0; i < strArray.length; i++)
            {
                try {
                    Integer.parseInt(strArray[i]);
                    break;
                }catch(NumberFormatException nfe)
                {
                    newSong += strArray[i];
                }
            }

            songs2.add(newSong);
        }

        ArrayList<String> smallerList, biggerList;
        if (songs1.size() > songs2.size())
        {
            biggerList = songs1;
            smallerList = songs2;
        }
        else
        {
            biggerList = songs2;
            smallerList = songs1;
        }

        biggerList.removeAll(smallerList);

        System.out.println("****Unique Songs****");
        for (String song : biggerList)
            System.out.println(song);

    }
}
