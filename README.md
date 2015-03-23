# Project was compiled using Java 7 and JUnit 4.

***To Import***:

1) in Eclipse go to File -> Import

2) Select Git -> Projects from Git and hit Next

3) Select Clone Existing URI and hit Next

4) Enter the following into the fields:
    
    URI: https://github.com/Blev08/Neustar.git
    
    Host: github.com
    
    Repository Path: /Blev08/Neustar.git
    
    Make sure the connection is HTTPS
    Hit Next.

5) Make sure Master is checked and hit Next.

6) Select a Destination Directory and Hit Next.

7) Make sure Import Existing Projects is Checked.  Hit Next.

8) Make sure Neustar is checked and hit Finish.

The Neustar project should now be in your Package Explorer.

***Alternate - Import From File System***:

1) Download the project as a zip.

2) Extract the file to a convenient location like your Desktop.

3) Open Eclipse.

4) Go to File -> New -> Java Project

5) Enter a Project Name.  Make sure the JRE is a JAVA 1.7 version. Click finish.

6) File -> Import

7) Select General Folder and File System.

8) Browse Button.

9) Find the Extracted top level folder, select it, and hit OK.

10) Select the Checkbox next to Neustar-Master.  The .classpath, .gitignore, and .project should also now be checked.

11) Hit the Browse button next to Into Folder.

12) Scroll down to the name of the project you created in step 5.  Select it and Hit Ok.

13) Hit Finish.

14) Hit Yes to All on the pop up screen.

The project should be successfully imported into the project you created in step 5.  
There should be one package - Neustar, located under the src folder with two classes: Neustar.java and NeustarTest.java.

***To Run:***

1) Copy and Paste the three included input files, input.txt, blank.txt and long.txt into a convenient location.  For Example: C:\input\.

2) Open a Command Prompt.

3) Change Directory to the Neustar project in your git repository. ..\git\Neustar\src\Neustar

4) Type javac Neustar.java.  Project will compile.

5) Go up one directory to the src directory.

6) Type the following: java Neustar.Neustar c:\input\input.txt and hit Enter.

The program should run and output data.  Try the command on line 6 with the other input files blank.txt and long.txt

Note: if you imported by downloading the file as a zip.  Instead of going to the git, it should be in your eclipse workspace.
So go to \workspace\Neustar\src\Neustar instead for Step 3 Above in the To Run.
