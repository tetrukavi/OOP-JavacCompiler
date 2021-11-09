package filesprocessing.Filters;

import java.io.File;


/**
 * An abstract class for a "Filter By Permission" type.
 */

public abstract class FilterByPermission extends GenesisFilter {


    // ~~~ Fields ~~~ \\

    private final String havePermission;

    /**
     * @param havePermission A string - "YES" if the file has permission, "NO" otherwise.
     */
    FilterByPermission(String havePermission) {
        this.havePermission = havePermission;
    }

    String getHavePermission() {
        return havePermission;
    }

    public abstract boolean validByFilter(File file);
}
