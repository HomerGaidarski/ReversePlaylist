package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Homer on 5/19/15.
 */
public class ComparePlaylists
{

    public ComparePlaylists(String filePath1, String filePath2)
    {
        FileReader reader = new FileReader();

        List<String> songStrings1 = reader.read(filePath1);
        List<String> songStrings2 = reader.read(filePath2);

        List<String> songs1 = new ArrayList<String>();
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
        List<String> songs2 = new ArrayList<String>();
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

        List<String> smallerList, biggerList;
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


    public void doSomething(List<String> blahMyList) {

    }
}
