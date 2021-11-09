package filesprocessing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * a class that runs the program.
 */

public class DirectoryProcessor {

    private static final int SOURCE_DIR = 0;
    private static final String ERROR_INVALID_INPUT = "ERROR: Invalid Input \n";
    private static final String ERROR_IO_EXCEPTION = "ERROR: IO Exception \n";
    private static final String ERROR_THERE_IS_A_PROBLEM_WITH_THE_FILTER_SECTION = "ERROR: There is a " +
            "problem with the FILTER section \n";
    private static final String ERROR_THERE_IS_A_PROBLEM_WITH_THE_ORDER_SECTION = "ERROR: There is a " +
            "problem with the ORDER section \n";
    private static final String ERROR_EMPTY_COMMAND_FILE = "ERROR: Empty Command File \n";
    private static final String ERROR_EMPTY_DIRECTORY = "ERROR: Empty Directory \n";
    private static final int EMPTY_FILE = 0;

    public static void main(String[] args) {
        Parser parcer = new Parser();
        if (args.length != 2){
            System.err.println(ERROR_INVALID_INPUT);
            return;
        }

        try {
            File[] files = CheckDir(args[SOURCE_DIR]);
            String[] file = parcer.readFile(args[1]);
            if (file.length == EMPTY_FILE)
            {
                throw new InvalidFileException();
            }
            ArrayList<Section> sections = parcer.sectionMaker(file);

            for (Section section : sections) {

                section.printSection(files);
            }
        }catch (IOException e){
            System.err.println(ERROR_IO_EXCEPTION);
        }catch (InvalidFilterSection e) {
            System.err.println(ERROR_THERE_IS_A_PROBLEM_WITH_THE_FILTER_SECTION);
        }catch (InvalidOrderSection e){
            System.err.println(ERROR_THERE_IS_A_PROBLEM_WITH_THE_ORDER_SECTION);
        }catch (InvalidFileException e) {
            System.err.println(ERROR_EMPTY_COMMAND_FILE);
        }catch (InvalidDir e){
            System.err.println(ERROR_EMPTY_DIRECTORY);
        }

    }

    /**
     * check the directory
     * @param arg the input
     * @return the files array
     * @throws InvalidDir an exception
     */
    private static File[] CheckDir(String arg) throws InvalidDir {
        File[] files1 = new File(arg).listFiles();
        ArrayList<File> onlyFiles = new ArrayList<>();
        if (files1.length > 0){
            for (File file:files1){
                if (file.isFile()){
                    onlyFiles.add(file);
                }
            }
            return  onlyFiles.toArray(new File[0]);
        }
        throw new InvalidDir();


    }
}
