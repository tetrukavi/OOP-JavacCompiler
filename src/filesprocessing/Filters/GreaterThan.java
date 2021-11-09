package filesprocessing.Filters;

import java.io.File;

/**
 * A class for the "BetweenFilter" Filter - File size is between (inclusive) the given numbers (in k-bytes)
 */

public class GreaterThan extends FilterBySize {

    /**
     */
    GreaterThan(double toCompare1) {
        super(toCompare1);
    }


    @Override
    public boolean validByFilter(File file) {
        double fileSize = (double) file.length();
        return fileSize > this.getToCompare1();

    }
}
