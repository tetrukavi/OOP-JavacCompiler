package filesprocessing.Filters;

import java.io.File;

/**
 * A class for the "BetweenFilter" Filter
 */

public class SmallerThan extends FilterBySize {


    /**
     *
     */
    SmallerThan(double toCompare1) {

        super(toCompare1);
    }

    @Override
    public boolean validByFilter(File file) {
        double fileSize = (double) file.length();
        return fileSize < this.getToCompare1();
    }
}
