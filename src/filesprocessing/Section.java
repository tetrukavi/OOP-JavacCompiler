package filesprocessing;

import filesprocessing.Filters.GenesisFilter;
import filesprocessing.Order.GenesisOrder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * a class for the section - represents valid section, that have a filter and an order, and warnings if
 * there are.
 */
public class Section {

    // ~~~ Fields && Magic Numbers ~~~ \\
    private GenesisFilter filter;

    private GenesisOrder order;

    // an array that represents the warnings indexes - first element is the index for the filer, second is
    // for the order index
    private int[] warnings;
    private static final String WARNING_IN_LINE = "Warning in line ";


    Section(GenesisFilter filter, GenesisOrder order, int[] warnings){
        this.filter = filter;
        this.order = order;
        this.warnings = warnings;
    }

    public GenesisFilter getFilter() {
        return filter;
    }

    public GenesisOrder getOrder() {
        return order;
    }

    /**
     * this method filtering, sorting and prints the sorted files.
     * @param filesArray files array from the directory.
     * @throws IOException exception
     */
    void printSection(File[] filesArray) throws IOException {
        ArrayList<File> filteredFiles = new ArrayList<>();

        for (File file : filesArray) {
            if (this.filter.validByFilter(file)) {
                filteredFiles.add(file);
            }
        }
        File[] filteredFilesArray = new File[filteredFiles.size()];
        filteredFilesArray = filteredFiles.toArray(filteredFilesArray);
        SortingAlgorithm.sortHelper(filteredFilesArray,filteredFilesArray.length ,this.order);
        for(int warning: this.warnings){

            // check if there are any warnings...
            if (warning > -1){
                System.err.println(WARNING_IN_LINE + warning );
            }
        }


        for (File file:filteredFilesArray){
            System.out.println(file.getName());
        }
    }


}
