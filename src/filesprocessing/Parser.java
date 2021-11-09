package filesprocessing;

import filesprocessing.Filters.AllFilter;
import filesprocessing.Filters.FilterFactory;
import filesprocessing.Filters.GenesisFilter;
import filesprocessing.Order.GenesisOrder;
import filesprocessing.Order.OrderByAbs;
import filesprocessing.Order.OrderFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class for the parser - does the work actually - reads the files, throws exceptions, and making section
 * objects
 */
class Parser {


    // ~~~ Fields && Magic Numbers ~~~ \\
    public static final String FILTER = "FILTER";
    public static final String ORDER = "ORDER";
    public static final int NO_WARNINGS = -1;

    /**
     * reads the file
     * @param fileFromComm  command file
     * @return array of strings, all of the command file.
     * @throws IOException exception.
     */
    String[] readFile(String fileFromComm) throws IOException {
        ArrayList<String> fileLines = new ArrayList<>();
        File file = new File(fileFromComm);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String lineInFile;
            while ((lineInFile = br.readLine()) != null) {
                fileLines.add(lineInFile);
            }
        }

        String[] stringLines = new String[fileLines.size()];
        stringLines = fileLines.toArray(stringLines);
        return stringLines;
    }


    /**
     * throws exceptions, and making section objects
     * @param filtersAndOrders the lines of the files
     * @return list of sections
     * @throws InvalidFilterSection exception for invalid filter section
     * @throws InvalidOrderSection exception for invalid order section
     */
    ArrayList<Section> sectionMaker(String[] filtersAndOrders) throws InvalidFilterSection, InvalidOrderSection {
        ArrayList<Section> sectionsList = new ArrayList<>();
        int lineCounter = 0;

        while (lineCounter < filtersAndOrders.length) {
            // prepare the filter && order of the section.
            GenesisOrder order;
            GenesisFilter filter;
            // initialization of the warning list.
            int[] warningLines = new int[2];
            warningLines[0] = NO_WARNINGS;
            warningLines[1] = NO_WARNINGS;

            // if the section is smaller than 3, throw Type 2 error
            if ((filtersAndOrders[lineCounter].equals(FILTER))
                    && (filtersAndOrders.length - lineCounter >= 3)) {
                if (filtersAndOrders[lineCounter + 2].equals(ORDER)) {
                    if ((filtersAndOrders.length - lineCounter == 3)
                            || (filtersAndOrders[lineCounter + 3].equals(FILTER))) {

                        // Section Measure is 3
                        try {

                            filter = new FilterFactory(filtersAndOrders[lineCounter + 1],
                                    lineCounter + 1).makeFilter();
                        } catch (TypeOneException e) {
                            filter = new AllFilter();
                            warningLines[0] = lineCounter + 2;
                        }
                        order = new OrderByAbs();
                        sectionsList.add(new Section(filter, order, warningLines));
                        lineCounter += 3;

                        // Section Measure is 4
                    } else if (filtersAndOrders.length - lineCounter == 4
                            || filtersAndOrders[lineCounter + 4].equals(FILTER)) {
                        try {

                            filter = new FilterFactory(filtersAndOrders[lineCounter + 1],
                                    lineCounter + 1).makeFilter();
                        } catch (TypeOneException e) {
                            filter = new AllFilter();
                            warningLines[0] = lineCounter + 2;
                        }
                        try {

                            order = new OrderFactory(filtersAndOrders[lineCounter + 3],
                                    lineCounter + 3).makeOrder();
                        } catch (TypeOneException e) {
                            order = new OrderByAbs();
                            warningLines[1] = lineCounter + 4;

                        }

                        sectionsList.add(new Section(filter, order, warningLines));
                        lineCounter += 4;
                    } else {
                        throw new InvalidFilterSection();

                    }
                } else {
                    throw new InvalidOrderSection();
                }

            } else {
                throw new InvalidOrderSection();
            }

        }
        return sectionsList;
    }


}
