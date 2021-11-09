package filesprocessing.Filters;

import java.io.File;

/**
 * An abstract class that represents filtering by size.
 */
public abstract class FilterBySize extends GenesisFilter {

    // ~~~ Fields ~~~ \\
    private static final double CONVERTION_FACTOR = 1024;

    private double toCompare1;

    /**
     *  gets the size to compare
     */
    FilterBySize(double toCompare1) {
        this.toCompare1 = ConvertToBytes(toCompare1);

    }

    /**
     * This method converting from k-bytes to bytes.
     * @param toConvert the size to convert.
     * @return the size in bytes
     */
    static double ConvertToBytes(double toConvert) {
        return toConvert * CONVERTION_FACTOR;
    }

    /**
     * A getter for the "toCompare"
     */
    double getToCompare1() {
        return toCompare1;
    }

    public abstract boolean validByFilter(File file);
}
