/**********************************************
 Workshop 5
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 8 Mar 2023
 **********************************************/
import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * MadLibs
 */
public class MadLibs {
    /**
     * main
     */
    public MadLibs(){}
    /**
     * Choices between C, V, and Q
     * @param args  args
     * @throws FileNotFoundException    ex
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        String response;
        boolean ok = false;

        welcome();
        while (!ok) {
            System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
            response = scan.nextLine().toLowerCase();

            if (response.equals("q"))
                break;
            else if (response.equals("c") || response.equals("v")) {
                File InputFile = EnterFileName("Input file name: ", scan);
                while (!InputFile.exists()) {
                    InputFile = EnterFileName("File not found. Try again: ", scan);
                    if (InputFile.getName().equalsIgnoreCase("q")) {
                        return;
                    }
                }
                Scanner ScanFile = new Scanner(InputFile);
                //only C makes output file
                if (response.equals("c")) {
                    File OutputFile = EnterFileName("Output file name: ", scan);
                    GenerateMadLib(scan, ScanFile, OutputFile);
                }
                else {
                    ReadFile(ScanFile);
                }
                ok = false;
            } else {
                System.out.println("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? I don't understand.");
                //prompts any response of C, V or Q only
            }
        }
    }

    /**
     * Prompt entering file name
     * @param prompt    prompt
     * @param scan      scan
     * @return          file name
     */
    public static File EnterFileName(String prompt, Scanner scan) {
        System.out.print(prompt);
        return new File(scan.nextLine());
    }
    /**
     * Welcome message
     */
    public static void welcome() {
        System.out.println("Welcome to the game of Mad Libs.");
        System.out.println("I will ask you to provide various words");
        System.out.println("and phrases to fill in a story.");
        System.out.println("The result will be written to an output file.\n");
    }
    /**
     * View file
     * @param scan  read input
     */
    public static void ReadFile(Scanner scan) {
        System.out.println();
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
        System.out.println();
        scan.close();
    }
    /**
     * Create
     * @param scan      scan
     * @param input     input
     * @param OutputFile    output
     * @throws FileNotFoundException    ex
     */
    public static void GenerateMadLib(Scanner scan, Scanner input, File OutputFile)
            throws FileNotFoundException {

        System.out.println();
        try (PrintStream WriteIn = new PrintStream(OutputFile)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Scanner LocalScan = new Scanner(line);

                while (LocalScan.hasNext()) {
                    String word = LocalScan.next();
                    if (word.startsWith("<") && word.endsWith(">")) {
                        String placeholder = word.replace("-", " ").substring(1, word.length() - 1);
                        //fetch strings like <funny-noise>
                        //ignore < and >, replace hyphen with space, so, funny noise
                        System.out.print("Please type");
                        if (placeholder.toLowerCase().startsWith("a") ||
                                placeholder.toLowerCase().startsWith("e") ||
                                placeholder.toLowerCase().startsWith("i") ||
                                placeholder.toLowerCase().startsWith("o") ||
                                placeholder.toLowerCase().startsWith("u"))
                        {
                            System.out.print(" an ");
                        }
                        else {
                            System.out.print(" a ");
                        }
                        System.out.print(placeholder + ": ");//Please type a funny noise
                        word = scan.nextLine();//all original lines
                    }
                    WriteIn.print(word + " ");//each word/token from input file separate by space
                }
                WriteIn.println();
            }
            System.out.println("Your mad-lib has been created!\n");
        }
    }
}
