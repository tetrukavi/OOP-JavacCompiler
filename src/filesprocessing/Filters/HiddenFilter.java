package filesprocessing.Filters;

import java.io.File;

/**
 * A class for the "HiddenFilter" Filter - checks if the file a hidden file.
 */

public class HiddenFilter extends FilterByPermission {

    public static final String IS_HIDDEN = "YES";

    /**
     * @param havePermission A string - "YES" if the file has permission, "NO" otherwise.
     */
    HiddenFilter(String havePermission) {
        super( havePermission);
    }

    @Override
    public boolean validByFilter(File file) {
        if (this.getHavePermission().equals(IS_HIDDEN)){
            return file.isHidden();
        }
        return !file.isHidden();

    }

}
