import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class AdvancedSorts {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(10);
        lista.add(3);
        lista.add(9);
        lista.add(2);
        lista.add(12);
        lista.add(11);
        lista.add(5);
        printList(lista);
        printList(mergeSort(lista, 0, lista.size() - 1));
        // quickSort(lista, 0, lista.size());
        // heapSort(lista, lista.size());
        // countingSort(lista, 12);
        printList(lista);
    }

    public static void printList(ArrayList<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(list.get(startIndex));
            return temp;
        }
        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        return merge(mergeSort(list, startIndex, splitIndex), mergeSort(list, splitIndex + 1, endIndex));
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> l = left.iterator();
        Iterator<Integer> r = right.iterator();
        Integer elemL = null, elemR = null;
        boolean contL, contR;
        if (contL = l.hasNext()) {
            elemL = l.next();
        }
        if (contR = r.hasNext()) {
            elemR = r.next();
        }
        while (contL && contR) {
            if (elemL <= elemR) {
                result.add(elemL);
                if (contL = l.hasNext()) {
                    elemL = l.next();
                } else {
                    result.add(elemR);
                }
            } else {
                result.add(elemR);
                if (contR = r.hasNext()) {
                    elemR = r.next();
                } else {
                    result.add(elemL);
                }
            }
        }
        while (l.hasNext()) {
            result.add(l.next());
        }
        while (r.hasNext()) {
            result.add(r.next());
        }
        return result;
    }

    public static void quickSort(ArrayList<Integer> list, int startIndex, int endIndex) {
        if (endIndex - startIndex > 1) {
            int partition = parition(list, startIndex, endIndex);
            quickSort(list, startIndex, partition);
            quickSort(list, partition + 1, endIndex);
        }
    }

    private static int parition(ArrayList<Integer> list, int nFrom, int nTo) {
        Random rng = new Random();
        int rnd = nFrom + rng.nextInt(nTo - nFrom);
        swap(list, nFrom, rnd);
        Integer value = list.get(nFrom);
        int idxBigger = nFrom + 1;
        int idxLower = nTo - 1;
        do {
            while (idxBigger <= idxLower && list.get(idxBigger) <= value) {
                idxBigger++;
            }
            while (list.get(idxLower) > value) {
                idxLower--;
            }
            if (idxBigger < idxLower) {
                swap(list, idxBigger, idxLower);
            }
        } while (idxBigger < idxLower);
        swap(list, idxLower, nFrom);
        return idxLower;
    }

    private static void swap(ArrayList<Integer> list, int left, int right) {
        if (left != right) {
            Integer temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }

    public static void sink(ArrayList<Integer> heap, int idx, int n) {
        int idxOfBigger = 2 * idx + 1;
        if (idxOfBigger < n) {
            if (idxOfBigger + 1 < n && heap.get(idxOfBigger) < heap.get(idxOfBigger + 1)) {
                idxOfBigger++;
            }
            if (heap.get(idx) < heap.get(idxOfBigger)) {
                swap(heap, idx, idxOfBigger);
                sink(heap, idxOfBigger, n);
            }
        }
    }

    private static void heapAdjustment(ArrayList<Integer> heap, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            sink(heap, i, n);
        }
    }

    public static void heapSort(ArrayList<Integer> heap, int n) {
        heapAdjustment(heap, n);
        for (int i = n - 1; i > 0; i--) {
            swap(heap, i, 0);
            sink(heap, 0, i);
        }
    }

    public static void countingSort(ArrayList<Integer> list, int k) {
        k++;
        int n = list.size();
        int[] pos = new int[k];
        int[] result = new int[n];
        int i, j;
        for (i = 0; i < k; i++) {
            pos[i] = 0;
        }
        for (j = 0; j < n; j++) {
            pos[list.get(j)]++;
        }
        pos[0]--;
        for (i = 1; i < k; i++) {
            pos[i] += pos[i - 1];
        }
        for (j = n - 1; j >= 0; j--) {
            result[pos[list.get(j)]] = list.get(j);
            pos[list.get(j)]--;
        }
        for (j = 00; j < n; j++) {
            list.set(j, result[j]);
        }
    }
}