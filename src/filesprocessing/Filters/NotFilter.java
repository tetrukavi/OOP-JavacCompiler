package filesprocessing.Filters;


import java.io.File;

/**
 * A class for the "Not" Filter
 */

public class NotFilter extends GenesisFilter {

    private GenesisFilter filter;

    /**
     * constructor for the "Not" filter
     * @param filter gets a filter
     */
    NotFilter(GenesisFilter filter){
        this.filter = filter;
    }

    @Override
    public boolean validByFilter(File file) {
        return
                !(filter.validByFilter(file));
    }


}
