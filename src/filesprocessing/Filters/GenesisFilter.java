package filesprocessing.Filters;

import java.io.File;

/**
 * An abstract class that represents a "basic" filter.
 */
public abstract class GenesisFilter {

    // ~~~ Fields ~~~ \\
    protected File file;


    /**
     * Constructor for the filter
     */
    GenesisFilter() {

    }


    /**
     * This method "filters" the file according to certain criterion, that described in the classes that
     * extends this class
     * @return True if the file match a certain criterion, false otherwise.
     */
    public abstract boolean validByFilter(File file);


}

