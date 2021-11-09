package filesprocessing.Filters;
import java.io.File;

/**
 * A class for the "all" Filter - all files are matched.
 */

public class AllFilter extends GenesisFilter {


    public AllFilter() {
    }

    @Override
    public boolean validByFilter(File file) {
        return true;
    }
}

