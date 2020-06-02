import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
/**
 * Write a description of class Tester here.
 * 
 * @author GivenName FamilyName
 * @version 1.0 yyyy-mm-dd
 */
public class Tester
{
    public static void editErrorsInFile() throws IOException
    {
        final String EMPTY_STRING = "";
        final String INPUT_FILE = "2016-12-21_Welcome_to_Macintosh_combined.text";
        final int LENGTH_OF_MISPLACED_LINE = 7;
        final String MISPLACED_LINE = "Block A";
        final String OUTPUT_FILE = "editedScores.text";
        final char SPACE = ' ';
        final String SPACES_AS_TABS = "   ";
        int numberOfSpaces;
        // Establish connections to the text files
        BufferedReader inputFile = new BufferedReader(new FileReader(INPUT_FILE));
        PrintWriter outputFile = new PrintWriter(new FileWriter(OUTPUT_FILE));

        // Read from the first file and echo to the second
        String lineOfText = inputFile.readLine();

        while (lineOfText != null)
        {
            // Fix spaces that were supposed to be tabs
            lineOfText = lineOfText.replaceAll(SPACES_AS_TABS, "\t");
            numberOfSpaces = 1;
            if (!lineOfText.equals(EMPTY_STRING))
            {
                while (lineOfText.charAt(lineOfText.length() - numberOfSpaces) == SPACE)
                {
                    lineOfText = lineOfText.substring(0, lineOfText.length() - numberOfSpaces);
                    numberOfSpaces = numberOfSpaces + 1;
                } // end of while (lineOfText.charAt(lineOfText.length() - numberOfSpaces) == SPACE)
            } // end of if (!lineOfText.equals(EMPTY_STRING))
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
            lineOfText = inputFile.readLine();
        } // while(lineOfText != null)

        // Wrap up.
        inputFile.close();
        outputFile.close();

    } // end of method editErrorsInFile()

    public static void testerORiginal()
    {
        final String TAB = "    ";
        String line = "ICS3U7-01 Pod 1\t10\t20\t30\t41";
        String [] scores;
        scores = line.split("\t");
        String score = scores[0];
        Video video1 = new Video();
        video1.setContentScore (Integer.parseInt(scores[4]));
        video1.setTitle(scores[0]);
        System.out.println(video1.getContentScore());
        System.out.println(video1.getTitle());
    }

    public static void test()
    {
        String test = "ICS4U1-02C Pod 5 4   4   4   4";
        System.out.println(test.replaceAll("   ", "hi"));
    }

    public static void main(String[] arguments) throws IOException
    {      
        // Establish connections to the console and to a text file.

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter outputFile = null;

        do 
        {
            System.out.print("File name? ");
            String textFile = console.readLine();
            try 
            {
                outputFile = new PrintWriter(new FileWriter(textFile));

            }
            catch(IOException exception)
            {
                System.out.println("***Error: Unable to connect to \"" + textFile + "\".");
            } // end of catch (IOException exception)

            // Prompt for input and echo to the console and to the file.
            try
            {
                System.out.print("Input? ");
                String lineOfText = console.readLine();
                System.out.println("Just read: \"" + lineOfText + "\"");
                outputFile.println(lineOfText);
            }
            catch (IOException exception)
            {
                System.out.println(exception);
            } // end of catch (IOException exception)
            outputFile.close();
        }
        while (outputFile != null);
    } // end of method main(String[] arguments) throws IOException
    
    }} // end of class ReadFromConsoleAndWriteToFileWithoutLoop

