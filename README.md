# ReversePlaylist
A program that reverses the order of iTunes' playlists. Please read the Problem section before you call me an idiot.

**The Problem**

I made this program because sometimes iTunes messes up when syncing a playlist I changed on my phone: it reverses the playlist order (of when I added the songs). I have very large playlists and like to listen to the most recently added songs at the top but when iTunes make this error, it thinks the very first songs I added were the most recent songs I added, and there is no way to fix this until the error is repeated.

Don’t tell me that you can fix this by pressing the arrow in the top left of the playlist box, yes, this reverses the songs, but it does not fix my problem.

The arrow doesn’t actually reverse the order, it is more like a switch, one way it has the most recently added songs at the top of the list, the other way it has the most recently added songs at the bottom of the list. So when iTunes messes up with the iPhone sync, and reverses the actual song order in the playlist, I can’t add my songs next to the most recent ones because it has been reversed.

**The Solution**

I realized that you can actually export iTunes playlists as text files that store information of each song per line. So I quickly wrote a java program that takes in a text file and simply reverses it by line. I had ignore the first line of the text file because that contains column information: song, artist, album, etc. Then I deleted the playlist in iTunes and re-imported it using my reversed text file and voilà! The order was fixed.

**Usage**

IMPORTANT: All of this must be done on the same computer, if you export an iTunes playlist, reverse it (or don’t reverse it), and then import the playlist into an iTunes library on a different computer, it won’t import properly. This is because in the text file, there is a file path for each song, when it can’t find the song there, it searches your entire computer for the file, but only searches for certain file types (ex: .m4a).

1. Dowload the executable jar file "ReversePlaylist.jar" OR download the source code and import it into your favorite IDE and build.

2. Before you even start the program, you should go into your iTunes and export your playlist(s) as PLAIN TEXT file(s) (it will not work if you don’t export as plain text). On mac you actually have to specify it as plain text, but on windows just select .txt.

3. Start the program. A window should pop up with a single “browse” button. If you can’t see the browse button, try resizing the window.

4. Click “browse” and search for the plain text file you exported. Select the file and click “open”.

5. If the reverse process worked, another window should pop up that says, “Success!” If the window didn’t pop up or the program crashed, go back to step 1 and retry. 

6. You can repeat the reverse process multiple times (doesn't have to be the same file), just repeat from step 4 and when you are done, close all java windows to quit the program.

NOTE: If you are running the program from a source build (not from the executable jar file), then two identical numbers should print out in the console. The first number represents the number of songs before the reversal process, and the second number represents the number of songs after the reversal process. So, if those numbers are not the same, then it means song(s) were lost or the file was corrupted.

**Future Updates**

If you’re like me, most of you just use iTunes as a means of playing music and uploading to your iPhone, you don’t actually purchase media from the iTunes store. This creates huge issues if you get a new computer and need to import an old iTunes library.

When I did this, there were about 100 missing songs in my playlists even though most of the songs had been imported into the library. Checking to see which songs it was that were missing was very annoying, so I made another program that asks for 2 playlist text files and lists the songs that are “unique”. This sped up the process of fixing my playlists a lot faster but it was still very tedious. If I ever work on this program again, I will edit that feature so that it edits the files so that they are exactly the same except for the file paths.

**Final Comments**

When I made this program, I only had a little over a year of programming experience and just made this for fun. If anyone has any suggestions on how I can make this better, has questions, or wants to tell me about a straightforward way to solve this problem, then please email me.
