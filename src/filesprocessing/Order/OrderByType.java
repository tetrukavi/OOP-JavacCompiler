package filesprocessing.Order;

import java.io.File;

/**
 * A class that represents the "OrderBySize" order - Sort files by file type, going from ’a’ to ’z’.
 */
public class OrderByType extends GenesisOrder {


    private static final String STR = ".";
    private static final String SEPARATOR = STR;
    private static final int ZERO = 0;
    private static final String EMPTY_STRING = "";

    @Override
    public int orderFiles(File file1, File file2)  {
        if (getFileExtension(file1).equals(getFileExtension(file2))){
            return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
        }
        return getFileExtension(file1).compareTo(getFileExtension(file2));
    }

    /**
     * get the file extension.
     * @param file the file we want to get extension from.
     * @return the file extension
     */
    private String getFileExtension(File file){
        String fileName = file.getName();
        if ((fileName.lastIndexOf(SEPARATOR)!= ZERO)&&(fileName.lastIndexOf(SEPARATOR)!=-1)){
            return fileName.substring((fileName.lastIndexOf(SEPARATOR))+1);
        } return EMPTY_STRING;
    }
}
