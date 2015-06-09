package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Homer on 11/27/14.
 */
public class Swing extends JFrame
{

    public Swing()
    {
        super("Playlist Reverser");

        setVisible(true);

        setSize(300,75);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        add(panel);

        setLocationRelativeTo(null);

        JLabel instructions = new JLabel("Select a text file");
        panel.add(instructions);

        JButton browseButton = new JButton("browse");
        panel.add(browseButton);


        Thehandler handler = new Thehandler();
        browseButton.addActionListener(handler);
    }


    private class Thehandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String filePath;
            JFileChooser jc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            jc.setFileFilter(filter);
            int response = jc.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION)
            {
                filePath = jc.getSelectedFile().toString();
                System.out.println("Filepath: " + filePath);

                Reverse reverser = new Reverse(filePath);
                JFrame frame = new JFrame();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setSize(175, 75);

                JPanel panel = new JPanel();
                frame.add(panel);

                JLabel message;
                if (reverser.wasSuccessful())
                {
                    System.out.println("Success");
                    message = new JLabel("Success!");
                }
                else
                {
                    System.out.println("error");
                    message = new JLabel("An error occurred.");
                }

                panel.add(message);



            }
        }

    }
}
