
public class Lista2 {
    public static void main(String[] args) {
        OneWayLinkedList<Integer> lista = new OneWayLinkedList<Integer>();
        lista.add(3);
        lista.add(8);
        lista.add(10);
        System.out.println(lista.get(1));
    }
}