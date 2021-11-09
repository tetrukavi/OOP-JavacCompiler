package filesprocessing;

import filesprocessing.Order.GenesisOrder;

import java.io.File;
import java.io.IOException;


/**
 * a class for the sorting method.
 */
class SortingAlgorithm {

    /**
     * sort an array of files with helper.
     * @param allFilesArrayList all the files to sort.
     * @param rightFilesArrayList the right side of the array.
     * @param leftFilesArrayList left side of the array.
     * @param right right index.
     * @param left left index.
     * @param order the order we want to sort with
     * @throws IOException  an exception.
     */
    private static void sort(File[] allFilesArrayList, File[] rightFilesArrayList,
                             File[] leftFilesArrayList, int right, int left, GenesisOrder order) throws IOException {
        int i = 0; int j = 0; int k = 0;
        while (i < left && j < right){
            if (order.orderFiles(leftFilesArrayList[i], rightFilesArrayList[j]) < 0) {
                allFilesArrayList[k++] = leftFilesArrayList[i++];

            }else {
                allFilesArrayList[k++] = rightFilesArrayList[j++];

            }
        }while (i < left){
            allFilesArrayList[k++] = leftFilesArrayList[i++];

        }
        while (j < right){
            allFilesArrayList[k++] = rightFilesArrayList[j++];

        }
    }

    /**
     * an helper for the sort.
     * @param allFilesArrayList all of the files array.
     * @param n a pivot.
     * @param order the order we want to sort with.
     * @throws IOException an exception.
     */
    static void sortHelper(File[] allFilesArrayList, int n, GenesisOrder order) throws IOException {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        File[] leftFilesArrayList = new File[mid];
        File[] rightFilesArrayList = new File[n - mid];

        System.arraycopy(allFilesArrayList, 0, leftFilesArrayList, 0, mid);
        for (int i = mid; i < n; i++) {
            rightFilesArrayList[i - mid] = allFilesArrayList[i];
        }
        sortHelper(leftFilesArrayList, mid,order);
        sortHelper(rightFilesArrayList,n - mid,order);


        sort(allFilesArrayList, rightFilesArrayList, leftFilesArrayList, n-mid, mid, order);
    }
}
