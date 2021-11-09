package filesprocessing.Filters;

import java.io.File;

/**
 * A class for the "SuffixFilter" Filter - checks if toCompare is the suffix of the file name (excluding
 * path)
 */

public class SuffixFilter extends FilterByName {
    /**
     * @param toCompare
     */
    SuffixFilter(String toCompare) {
        super( toCompare);
    }

    @Override
    public boolean validByFilter(File file) {
        return file.getName().endsWith(getToCompare());

    }
}
