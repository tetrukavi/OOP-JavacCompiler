package filesprocessing.Filters;

import java.io.File;


/**
 * An abstract class for a "FilterByName" filter.
 */

public abstract class FilterByName extends GenesisFilter {

    // ~~~ Fields ~~~ \\

    private final String toCompare;

    /**
     * @param toCompare The string that we need to check
     */
    FilterByName(String toCompare) {

        this.toCompare = toCompare;
    }

    String getToCompare() {
        return toCompare;
    }

    public abstract boolean validByFilter(File file);
}
