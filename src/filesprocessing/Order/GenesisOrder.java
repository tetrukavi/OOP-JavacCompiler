package filesprocessing.Order;

import java.io.File;
import java.io.IOException;

/**
 * An abstract class that represents a "basic" order - indicates the order
 * in which the filtered files are printed.
 */
public abstract class GenesisOrder {

    // ~~~ Fields ~~~ \\
    protected File file1;

    protected File file2;


    /**
     * constructor for the order.
     */
    GenesisOrder(){
    }


    /**
     * this method is compering between to files according to a specific parameter (works as a comparator)
     * @param file1 the first file we want to check
     * @param file2 the second file we want to check
     * @return an int that represents the status between the two files.
     * @throws IOException exception.
     */
    public abstract int orderFiles(File file1, File file2) throws IOException;

}
