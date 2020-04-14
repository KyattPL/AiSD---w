public class Lista1 {
    public static void main(String[] args) {
        Student[] studenci = new Student[3];
        studenci[0] = new Student("John", "Wombo", 1, 2.0);
        studenci[1] = new Student("Will", "Maku", 2, 4.0);
        studenci[2] = new Student("Cole", "Roland", 3, 5.0);
        IteratorTablicowy it = new IteratorTablicowy(studenci);
        wyswietlListe(it);
        System.out.println(sredniaOcen(it));
        wpiszOcene(it, 2, 5.0);
        wyswietlOblanych(it);
    }

    public static void wyswietlListe(IteratorTablicowy it) {
        it.first();
        while (!it.isDone()) {
            Student temp = (Student) it.current();
            System.out.println(temp.toString());
            it.next();
        }
    }

    public static void wpiszOcene(IteratorTablicowy it, int indeks, double ocena) {
        it.first();
        while (!it.isDone()) {
            Student temp = (Student) it.current();
            if (temp.getIndeks() == indeks) {
                temp.setOcena(ocena);
            }
            it.next();
        }

    }

    public static double sredniaOcen(IteratorTablicowy it) {
        it.first();
        double sum = 0;
        int zdajacy = 0;
        while (!it.isDone()) {
            Student temp = (Student) it.current();
            if (temp.getOcena() >= 3.0) {
                sum += temp.getOcena();
                zdajacy += 1;
            }
            it.next();
        }
        return sum / zdajacy;
    }

    public static void wyswietlOblanych(IteratorTablicowy it) {
        it.first();
        while (!it.isDone()) {
            Student temp = (Student) it.current();
            if (temp.getOcena() < 3.0) {
                System.out.println(temp.toString());
            }
            it.next();
        }
    }
}