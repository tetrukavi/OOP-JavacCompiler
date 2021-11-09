package filesprocessing.Filters;

import filesprocessing.TypeOneException;


import java.io.File;

/**
 * Factory class for the filter. makes one filter if valid, in case not, throws Type1 exception.
 */
public class FilterFactory {

    /// Fields && Magic Numbers \\\
    private static final String DIFFERENTIATE = "#";
    private static final int FIRST_ELEMENT = 0;
    private static final String GREATER_THAN = "greater_than";
    public static final String NOT = "NOT";
    private static final String BETWEEN = "between";
    private static final String SMALLER_THAN = "smaller_than";
    private static final String FILE = "file";
    private static final String CONTAINS = "contains";
    private static final String PREFIX = "prefix";
    private static final String SUFFIX = "suffix";
    private static final String WRITABLE = "writable";
    public static final String YES = "YES";
    public static final String NO = "NO";
    private static final String EXECUTABLE = "executable";
    private static final String HIDDEN = "hidden";
    private static final String ALL = "all";
    private static final int SECOND_ELEMENT = 1;
    private static final int THIRD_ELEMENT = 2;
    private static String filterLine;
    private static int filterIndex;
    private static GenesisFilter filter;
    public File file;
    public File[] files;


    public FilterFactory(String filterFromCommand, int filterLine) {

        FilterFactory.filterLine = filterFromCommand;
        filterIndex = filterLine;

    }

    /**
     * makes one filter if valid, in case not, throws Type1 exception.
     *
     * @return filter
     * @throws TypeOneException exception.
     */
    public GenesisFilter makeFilter() throws TypeOneException {
        String string = filterLine;
        String[] filter = string.split(DIFFERENTIATE);
        switch (filter[FIRST_ELEMENT]) {
            case GREATER_THAN:
                if (Double.parseDouble(filter[SECOND_ELEMENT]) < 0) {
                    break;
                }
                if (filter.length == 3 && filter[THIRD_ELEMENT].equals(NOT)) {
                    GreaterThan temporaryFilter =
                            new GreaterThan(Double.parseDouble(filter[SECOND_ELEMENT]));
                    return new NotFilter(temporaryFilter);
                }
                if (filter.length == THIRD_ELEMENT) {
                    return new GreaterThan(Double.parseDouble(filter[SECOND_ELEMENT]));
                }
                break;

            case BETWEEN:
                if (Double.parseDouble(filter[SECOND_ELEMENT]) < 0 ||
                        Double.parseDouble(filter[THIRD_ELEMENT]) < 0 ||
                        Double.parseDouble(filter[THIRD_ELEMENT]) -
                                Double.parseDouble(filter[SECOND_ELEMENT]) < 0) {
                    break;
                }
                if (filter.length == 4 && filter[3].equals(NOT)) {
                    BetweenFilter temporaryFilter = new
                            BetweenFilter(Double.parseDouble(filter[SECOND_ELEMENT]),
                            Double.parseDouble(filter[THIRD_ELEMENT]));
                    return new NotFilter(temporaryFilter);
                }
                if (filter.length == 3) {
                    return new BetweenFilter(Double.parseDouble(filter[SECOND_ELEMENT]),
                            Double.parseDouble(filter[THIRD_ELEMENT]));
                }
                break;


            case SMALLER_THAN:
                if (Double.parseDouble(filter[SECOND_ELEMENT]) < 0) {
                    break;
                }
                if (filter.length == 3 && filter[THIRD_ELEMENT].equals(NOT)) {
                    SmallerThan temporaryFilter = new
                            SmallerThan(Double.parseDouble(filter[SECOND_ELEMENT]));
                    return new NotFilter(temporaryFilter);
                }
                if (filter.length == 2) {
                    return new SmallerThan(Double.parseDouble(filter[SECOND_ELEMENT]));
                }
                break;

            case FILE:
                if (filter.length == 3 && filter[THIRD_ELEMENT].equals(NOT)) {
                    FileFilter temporaryFilter = new FileFilter(filter[SECOND_ELEMENT]);
                    return new NotFilter(temporaryFilter);
                }
                if (filter.length == 2) {
                    return new FileFilter(filter[SECOND_ELEMENT]);
                }
                break;


            case CONTAINS:

                if (filter.length == 3 && filter[THIRD_ELEMENT].equals(NOT)) {
                    ContainsFilter temporaryFilter = new ContainsFilter(filter[SECOND_ELEMENT]);
                    return new NotFilter(temporaryFilter);
                }
                if (filter.length == 2) {
                    return new ContainsFilter(filter[SECOND_ELEMENT]);
                }
                break;

            case PREFIX:
                if (filter.length == 3 && filter[THIRD_ELEMENT].equals(NOT)) {
                    PrefixFilter temporaryFilter = new PrefixFilter(filter[SECOND_ELEMENT]);
                    return new NotFilter(temporaryFilter);
                }
                if (filter.length == 2) {
                    return new PrefixFilter(filter[SECOND_ELEMENT]);
                }
                break;

            case SUFFIX:
                if (filter.length == 3 && filter[THIRD_ELEMENT].equals(NOT)) {
                    SuffixFilter temporaryFilter = new SuffixFilter(filter[SECOND_ELEMENT]);
                    return new NotFilter(temporaryFilter);
                }
                if (filter.length == 2) {
                    return new SuffixFilter(filter[SECOND_ELEMENT]);
                }
                break;

            case WRITABLE:
                if (filter.length == 1) {
                    break;
                }

                if (!filter[SECOND_ELEMENT].equals(YES) && !filter[SECOND_ELEMENT].equals(NO)) {
                    break;

                }
                if (filter.length == 3 && filter[THIRD_ELEMENT].equals(NOT)) {
                    WritableFilter temporaryFilter = new WritableFilter(filter[SECOND_ELEMENT]);
                    return new NotFilter(temporaryFilter);
                }
                if (filter.length == 2) {
                    return new WritableFilter(filter[SECOND_ELEMENT]);
                }

                break;

            case EXECUTABLE:
                if (filter.length == 1) {
                    break;
                }
                if (!filter[SECOND_ELEMENT].equals(YES) && !filter[SECOND_ELEMENT].equals(NO)) {
                    break;

                }

                if (filter.length == 3 && filter[THIRD_ELEMENT].equals(NOT)) {
                    ExecutableFilter temporaryFilter = new ExecutableFilter(filter[SECOND_ELEMENT]);
                    return new NotFilter(temporaryFilter);
                }
                if (filter.length == 2) {
                    return new ExecutableFilter(filter[SECOND_ELEMENT]);
                }

                break;


            case HIDDEN:
                if (filter.length == 1) {
                    break;
                }
                if (!filter[SECOND_ELEMENT].equals(YES) && !filter[SECOND_ELEMENT].equals(NO)) {
                    break;
                }
                if (filter.length == 3 && filter[THIRD_ELEMENT].equals(NOT)) {
                    HiddenFilter temporaryFilter = new HiddenFilter(filter[SECOND_ELEMENT]);
                    return new NotFilter(temporaryFilter);
                }
                if (filter.length == 2) {
                    return new HiddenFilter(filter[SECOND_ELEMENT]);
                }

                break;

            case ALL:
                if (filter.length == 2 && filter[SECOND_ELEMENT].equals(NOT)) {
                    AllFilter temporaryFilter = new AllFilter();
                    return new NotFilter(temporaryFilter);
                }
                if (filter.length == 1) {
                    return new AllFilter();
                }

                break;

        }
        throw new TypeOneException();
    }


}
