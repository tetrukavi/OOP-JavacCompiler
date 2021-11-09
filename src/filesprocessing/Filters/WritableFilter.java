package filesprocessing.Filters;

import java.io.File;

/**
 * A class for the "WritableFilter" Filter - checks if the file have writing permission (for the current
 * user)
 */

public class WritableFilter extends FilterByPermission {

    private static final String HAVE_PERMISSION = "YES";

    /**
     * @param havePermission A string - "YES" if the file has permission, "NO" otherwise.
     */
    WritableFilter(String havePermission) {
        super( havePermission);
    }

    @Override
    public boolean validByFilter(File file) {
        if (this.getHavePermission().equals(HAVE_PERMISSION)){
            return file.canWrite();
        }
        return !file.canWrite();

    }
}
