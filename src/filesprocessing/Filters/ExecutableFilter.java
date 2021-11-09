package filesprocessing.Filters;

import java.io.File;

/**
 * A class for the "ExecutableFilter" Filter - checks if the file can execute or not.
 */

public class ExecutableFilter extends FilterByPermission {

    private static final String CAN_EXECUTE = "YES";

    /**
     * @param havePermission A string - "YES" if the file has permission, "NO" otherwise.
     */
    ExecutableFilter(String havePermission) {
        super( havePermission);
    }

    @Override
    public boolean validByFilter(File file) {
        if (this.getHavePermission().equals(CAN_EXECUTE)){
            return file.canExecute();
        }
        return !file.canExecute();

    }
}
