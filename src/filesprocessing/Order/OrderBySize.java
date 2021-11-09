package filesprocessing.Order;

import java.io.File;

/**
 * A class that represents the "OrderBySize" order - Sort files by file type, going from ’a’ to ’z’.
 */
public class OrderBySize extends GenesisOrder {
    OrderBySize() {
    }

    @Override
    public int orderFiles(File file1, File file2)  {
        if (file1.length() == file2.length()){
            return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
        }
        return (int) (file1.length() - file2.length());
    }
}
