package filesprocessing.Filters;
import java.io.File;

/**
 * A class for the "BetweenFilter" Filter - checks if  the File size is between (inclusive) the given
 * numbers (in k-bytes)
 */
public class BetweenFilter extends FilterBySize {

    private final double toCompare2;

    /**
     * @param toCompare1 The first parameter to compare with.
     * @param toCompare2 The second parameter to compare with.
     */
    public BetweenFilter( double toCompare1, double toCompare2) {
        super(toCompare1);
        this.toCompare2 = FilterBySize.ConvertToBytes(toCompare2);
    }

    @Override
    public boolean validByFilter(File file) {
        return (double)file.length() >= this.getToCompare1() && (double) file.length() <= this.getToCompare2();
    }

    private double getToCompare2() {
        return toCompare2;
    }
}
