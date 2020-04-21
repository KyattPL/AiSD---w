
public class Test {
    public static void main(String[] args) {
        List1W lista = new List1W();
        lista.add(3);
        lista.add(10);
        lista.add(4);
        lista.add(2);
        // System.out.println(lista.countRec());
        // System.out.println(lista.sumRec());
        lista.add(5);
        // System.out.println(lista.sumRec());
        // lista.normShow();
        // lista.revShow();
        System.out.println(lista.max());
    }
}