package filesprocessing.Filters;

import java.io.File;

/**
 * A class for the "ContainsFilter" Filter - checks if the file contains the "toCompare" String.
 */

public class ContainsFilter extends FilterByName {

    /**
     *
     */
    ContainsFilter(String toCompare) {
        super(toCompare);
    }

    @Override
    public boolean validByFilter(File file) {
        return file.getName().contains(getToCompare());
    }
}
