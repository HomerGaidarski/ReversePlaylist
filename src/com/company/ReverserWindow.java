package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Homer on 11/27/14.
 */
public class ReverserWindow
{

    private static final Dimension DEFAULT_SIZE = new Dimension(300, 75);

    private JFrame window;

    public ReverserWindow()
    {
        window = new JFrame("Playlist Reverser");

        window.setPreferredSize(DEFAULT_SIZE);
        window.setMinimumSize(DEFAULT_SIZE);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        window.add(panel);

        window.setLocationRelativeTo(null);

        JLabel instructions = new JLabel("Select a text file");
        panel.add(instructions);

        JButton browseButton = new JButton("browse");
        panel.add(browseButton);

        browseButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String path = getFilePath();
                System.out.println("Filepath: " + path);
                Reverse reverser = new Reverse();
                boolean successful = reverser.reverseFile(path);
                JOptionPane.showMessageDialog(window, successful ? "Success" : "Failed", "InfoBox: " + "Results", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        window.pack();
        window.setVisible(true);
    }

    private String getFilePath()
    {
        String filePath;
        JFileChooser jc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        jc.setFileFilter(filter);
        int response = jc.showOpenDialog(window);
        if (response == JFileChooser.APPROVE_OPTION)
        {
            filePath = jc.getSelectedFile().toString();
            return filePath;
        }

        return null;
    }

}
