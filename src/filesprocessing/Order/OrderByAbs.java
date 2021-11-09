package filesprocessing.Order;

import java.io.File;
import java.util.Comparator;

/**
 * A class that represents the "OrderByAbs" order - Sort files by absolute name
 * going from ’a’ to ’z’.
 */
public class OrderByAbs extends GenesisOrder {


    public OrderByAbs() {
    }

    @Override
    public int orderFiles(File file1, File file2)  {
        return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
    }


}
