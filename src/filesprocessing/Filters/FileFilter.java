package filesprocessing.Filters;


import java.io.File;

/**
 * A class for the "FileFilter" Filter checks if the value equals the file name (excluding path)
 */

public class FileFilter extends FilterByName {


    FileFilter(String toCompare) {
        super(toCompare);
    }

    @Override
    public boolean validByFilter(File file) {
        return file.getName().equals(getToCompare());
    }
}
