package filesprocessing.Order;

import java.io.File;
import java.io.IOException;


/**
 * A class that represents the "ReversedOrder" order - the files
 * are sorted in the opposite way of the original order.
 */
public class ReversedOrder extends GenesisOrder {

    public static final int REVERSE = -1;

    private GenesisOrder order;

    /**
     * a constructor for the reversed order, getting a certain order
     * @param order certain order.
     */
    ReversedOrder(GenesisOrder order) {
        this.order = order;
    }

    @Override
    public int orderFiles(File file1, File file2) throws IOException {
        return REVERSE * this.order.orderFiles(file1, file2);
    }
}
