package filesprocessing.Order;
import filesprocessing.TypeOneException;


/**
 * Factory class for the order. makes one order if valid, in case not, throws Type1 exception.
 */
public class OrderFactory {

    /// Fields && Magic Numbers \\\
    private static final String DIFFERENTIATE = "#";
    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;
    private static final String REVERSES = "REVERSE";
    private static final String ABS = "abs";
    private GenesisOrder order;
    private static String orderLine;
    private static int orderIndex;
    private static final String TYPE = "type";
    private static final String SIZE = "size";


    /**
     * constructor for the factory
     * @param orderFromCommand order from command line as a string.
     * @param orderIndex the index of the order.
     */
    public OrderFactory(String orderFromCommand, int orderIndex)  {
        orderLine = orderFromCommand;
        OrderFactory.orderIndex = orderIndex;
    }

    /**
     * @return  a getter for the order - returns it.
     */
    public GenesisOrder getOrder() {
        return order;
    }

    /**
     * Makes one order if valid, in case not, throws Type1 exception.
     * @return an order.
     * @throws TypeOneException TypeOneException.
     */
    public GenesisOrder makeOrder() throws TypeOneException  {
        String string = orderLine;
        String[] orderArray = string.split(DIFFERENTIATE);
        switch (orderArray[FIRST_ELEMENT]) {
                    case ABS:
                        if (orderArray.length == 1){
                            return new OrderByAbs();
                        }
                        if (orderArray.length == 2 && orderArray[SECOND_ELEMENT].equals(REVERSES)){
                            OrderByAbs temporaryOrder = new OrderByAbs();
                            return new ReversedOrder(temporaryOrder);
                        }
                        throw new TypeOneException();

                    case TYPE:
                        if (orderArray.length == 1){
                            return new OrderByType();
                        }
                        if (orderArray.length == 2 && orderArray[1].equals(REVERSES)){
                            OrderByType temporaryOrder = new OrderByType();
                            return new ReversedOrder(temporaryOrder);
                        }
                        throw new TypeOneException();

                    case SIZE:

                        if (orderArray.length == 1){
                            return new OrderBySize();
                        }
                        if (orderArray.length == 2 && orderArray[1].equals(REVERSES)){
                            OrderBySize temporaryOrder = new OrderBySize();
                            return new ReversedOrder(temporaryOrder);
                        }
                        throw new TypeOneException();

                }throw new TypeOneException();


    }
}
