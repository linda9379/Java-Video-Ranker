import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Write a description of class VideoScore here.
 * 
 * @author Linda Jiang
 * @version 1.0 2017-01-04
 */
public class VideoScore
{
    // class constants and variables
    private static final int NUMBER_OF_VIDEOS = 13;
    private static final String TAB = "\t";

    private static String lineOfText;
    private static Video[] macintoshVideo = new Video [NUMBER_OF_VIDEOS];
    private static int currentVideo;

    /**
     * Calculates and shows each videos ratings. 
     */
    public static void main (String[] argument) 
    {
        final int VIDEO_NAME_COLUMN = 0;
        final String CLASS1 ="Block A";
        final String CLASS2 ="Block B";
        final String CLASS3 ="Block C";
        final String CLASS4 ="Block D";
        final String TEXT_FILE = "editedScores.text";

        BufferedReader inputFile = null; 
        int numberOfVideoTitlesStored = 0; 
        String[] lineOfScores;

        // instatiate an array of video objects
        for (currentVideo = 0; currentVideo < NUMBER_OF_VIDEOS; currentVideo ++)
        {
            macintoshVideo[currentVideo] = new Video();
        } // end of for (int i = 0; i < NUMBER_OF_VIDEOS; i ++)

        editErrorsInFile();
        // Establish a connection to the text file.
        try 
        {
            inputFile = new BufferedReader(new FileReader(TEXT_FILE));
        }
        catch (IOException exception)
        {
            System.out.println("***Error: Unable to connect to \"" + TEXT_FILE + "\".");
        } // end of catch (IOException exception)

        // Read title of video from the text file 
        try 
        {
            lineOfText = inputFile.readLine();
        }
        catch (IOException exception)
        {
            System.out.println(exception);
        } // end of catch (IOException exception)

        lineOfScores = lineOfText.split(TAB); 

        while (numberOfVideoTitlesStored < NUMBER_OF_VIDEOS && lineOfText != null)
        {   
            // Does the line contain video scores?
            if (!lineOfText.equals(CLASS1) && !lineOfText.equals(CLASS2) 
            && !lineOfText.equals(CLASS3) && !lineOfText.equals(CLASS4))
            {
                macintoshVideo[numberOfVideoTitlesStored].setTitle(lineOfScores[VIDEO_NAME_COLUMN]);
                numberOfVideoTitlesStored = numberOfVideoTitlesStored + 1;               
            } // end of if (!lineOfText.equals(CLASS1) && !lineOfText.equals(CLASS2) 
            
            try 
            {
                lineOfText = inputFile.readLine();
            }
            catch (IOException exception)
            {
                System.out.println(exception);
            } // end of catch (IOException exception)
            lineOfScores = lineOfText.split(TAB); 
        } // end of while (numberOfVideoTitlesStored < NUMBER_OF_VIDEOS && lineOfText != null)

        try 
        {
            if (inputFile != null)
            {
                inputFile.close();
            }
        }
        catch (IOException exception)
        {
            System.out.println(exception);
        } // end of catch (IOException exception)
        getScores();

        // Print out results
        System.out.println("Total Scores");
        for(currentVideo = 0; currentVideo < NUMBER_OF_VIDEOS; currentVideo ++)
        {
            System.out.println(macintoshVideo[currentVideo].getTitle()
                + TAB + macintoshVideo[currentVideo].getContentScore() + TAB + macintoshVideo[currentVideo].getLayoutAndDesignScore()
                + TAB + macintoshVideo[currentVideo].getTechnicalElementsScore() + TAB + macintoshVideo[currentVideo].getCreativityScore() 
                + TAB + (macintoshVideo[currentVideo].getContentScore() + macintoshVideo[currentVideo].getLayoutAndDesignScore() + macintoshVideo[currentVideo].getTechnicalElementsScore() + macintoshVideo[currentVideo].getCreativityScore()));
        } // end of for (int i = 0; i < NUMBER_OF_VIDEOS; i ++)
    } // end of method main (String[] argument) 

    /**
     * Fixes the errors in the text file.
     */
    public static void editErrorsInFile() 
    {
        final String EMPTY_STRING = "";
        final String INPUT_FILE = "2016-12-21_Welcome_to_Macintosh_combined.text";
        final int LENGTH_OF_MISPLACED_LINE = 7;
        final String MISPLACED_LINE = "Block A";
        final String OUTPUT_FILE = "editedScores.text";
        final char SPACE = ' ';
        final String SPACES_AS_TABS = "   ";
        BufferedReader inputFile = null;
        int numberOfSpaces;
        PrintWriter outputFile = null;
        // Establish connections to the text files
        try 
        {
            inputFile = new BufferedReader(new FileReader(INPUT_FILE));
        }
        catch(IOException exception)
        {
            System.out.println("***Error: Unable to connect to \"" + INPUT_FILE + "\".");
        } // end of catch (IOException exception)

        try 
        {
            outputFile = new PrintWriter(new FileWriter(OUTPUT_FILE));
        }
        catch(IOException exception)
        {
            System.out.println("***Error: Unable to connect to \"" + OUTPUT_FILE + "\".");
        } // end of catch (IOException exception)

        // Read from the first file and echo to the second
        try
        {
            lineOfText = inputFile.readLine();
        }
        catch (IOException exception)
        {
            System.out.println(exception);
        } // end of catch (IOException exception)

        while (lineOfText != null)
        {
            // Fix spaces that were supposed to be tabs
            lineOfText = lineOfText.replaceAll(SPACES_AS_TABS, TAB);
            numberOfSpaces = 1;

            if (!lineOfText.equals(EMPTY_STRING))
            {
                // Fix end of line markers
                while (lineOfText.charAt(lineOfText.length() - numberOfSpaces) == SPACE)
                {
                    lineOfText = lineOfText.substring(0, lineOfText.length() - numberOfSpaces);
                    numberOfSpaces = numberOfSpaces + 1;
                } // end of while (lineOfText.charAt(lineOfText.length() - numberOfSpaces) == SPACE)
            } // end of if (!lineOfText.equals(EMPTY_STRING))

            // Move the misplaced line to the next line 
            if (lineOfText.indexOf(MISPLACED_LINE) != -1 
            && lineOfText.indexOf(MISPLACED_LINE) > LENGTH_OF_MISPLACED_LINE - 1)
            {
                outputFile.println(lineOfText.substring(0, lineOfText.indexOf(MISPLACED_LINE)));
                outputFile.println(MISPLACED_LINE);
            } 
            else 
            {
                outputFile.println(lineOfText);
            }// end of if (lineOfText.indexOf(MISPLACED_LINE) != -1 && lineOfText.indexOf ...
            
            // Read the next line
            try
            {
                lineOfText = inputFile.readLine();
            }
            catch (IOException exception)
            {
                System.out.println(exception);
            } // end of catch (IOException exception)
        } // while(lineOfText != null)

        // Wrap up
        try 
        {
            if (inputFile != null)
            {
                inputFile.close();
            }
        }
        catch (IOException exception)
        {
            System.out.println(exception);
        } // end of catch (IOException exception)       
        outputFile.close();

    } // end of method editErrorsInFile()

    /**
     * Gathers and calculates scores for each video.
     */
    public static void getScores() 
    {
        final int CONTENT_SCORE_COLUMN = 1;
        final int CREATIVITY_SCORE_COLUMN = 4;
        final int LAYOUT_AND_DESIGN_SCORE_COLUMN = 2;
        final int TECHNICAL_ELEMENTS_SCORE_COLUMN = 3; 
        final int VIDEO_NAME_COLUMN = 0;
        final String TEXT_FILE = "editedScores.text";

        BufferedReader inputFile = null;
        String[] lineOfScores;
        boolean videoFound = false;

        // Establish a connection to the text file.
        try 
        {
            inputFile = new BufferedReader(new FileReader(TEXT_FILE));
        }
        catch(IOException exception)
        {
            System.out.println("***Error: Unable to connect to \"" + TEXT_FILE + "\".");
        } // end of catch (IOException exception)

        try
        {
            lineOfText = inputFile.readLine();
        }
        catch (IOException exception)
        {
            System.out.println(exception);
        } // end of catch (IOException exception)
        lineOfScores = lineOfText.split(TAB);

        while (lineOfText != null)
        {
            currentVideo = 0;
            do
            {   
                // Is it the right video?
                if (lineOfScores[VIDEO_NAME_COLUMN].equals(macintoshVideo[currentVideo].getTitle()))
                {
                    // Store video scores in this video object
                    macintoshVideo[currentVideo].setContentScore(Integer.parseInt(lineOfScores[CONTENT_SCORE_COLUMN]));
                    macintoshVideo[currentVideo].setCreativityScore(Integer.parseInt(lineOfScores[CREATIVITY_SCORE_COLUMN]));
                    macintoshVideo[currentVideo].setLayoutAndDesignScore(Integer.parseInt(lineOfScores[LAYOUT_AND_DESIGN_SCORE_COLUMN]));
                    macintoshVideo[currentVideo].setTechnicalElementsScore(Integer.parseInt(lineOfScores[TECHNICAL_ELEMENTS_SCORE_COLUMN]));
                    videoFound = !videoFound;
                }
                currentVideo = currentVideo + 1;
            }
            while(currentVideo < NUMBER_OF_VIDEOS && !videoFound);
            
            // Reset boolean expression
            videoFound = false;
            
            // Read the next line
            try
            {
                lineOfText = inputFile.readLine();
            }
            catch (IOException exception)
            {
                System.out.println(exception);
            } // end of catch (IOException exception)
            
            // Is it the end of the file?
            if (lineOfText != null)
            {
                lineOfScores = lineOfText.split(TAB);
            } // end of if (lineOfText != null)
        } // while(lineOfText != null)
        
        // Wrap up.
        try 
        {
            if (inputFile != null)
            {
                inputFile.close();
            }
        }
        catch (IOException exception)
        {
            System.out.println(exception);
        } // end of catch (IOException exception)  
    } // end of method getScores()
} // end of class VideoScore
