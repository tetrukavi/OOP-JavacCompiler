package filesprocessing.Filters;

import java.io.File;

/**
 * A class for the "PrefixFilter" Filter - checks if toCompare is the prefix of the file
 * name (excluding path)
 */

public class PrefixFilter extends FilterByName {

    PrefixFilter(String toCompare) {
        super(toCompare);
    }

    @Override
    public boolean validByFilter(File file) {
        return file.getName().startsWith(getToCompare());
    }
}
