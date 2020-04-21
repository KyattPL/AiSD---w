import java.util.ArrayList;

public class BasicSorts {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(10);
        lista.add(5);
        lista.add(6);
        lista.add(3);
        lista.add(9);
        printList(lista);
        System.out.println();
        printList(insertionSort(lista));
        System.out.println();
        printList(selectionSort(lista));
        System.out.println();
        printList(bubbleSort(lista));
    }

    public static void printList(ArrayList<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int value = list.get(i);
            int j = i;
            while (j > 0 && list.get(j - 1) > value) {
                list.set(j, list.get(j - 1));
                j -= 1;
            }
            list.set(j, value);
        }
        return list;
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> list) {
        int size = list.size();
        for (int slot = 0; slot < size - 1; slot++) {
            int smallest = slot;
            for (int check = slot + 1; check < size; check++) {
                if (list.get(check) < list.get(smallest)) {
                    smallest = check;
                }
            }
            int temp = list.get(smallest);
            list.set(smallest, list.get(slot));
            list.set(slot, temp);
        }
        return list;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        boolean madeSwap = false;
        for (int i = 0; i < list.size(); i++) {
            madeSwap = false;
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j + 1) < list.get(j)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    madeSwap = true;
                }
            }
            if (!madeSwap) {
                break;
            }
        }
        return list;
    }
}