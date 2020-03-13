import java.util.Scanner;

public class Lista1 {
    public static void main(String[] args){
        Student[] study = new Student[3];
        study[0] = new Student(1, "Bartek", "Biruk", 3.0);
        study[1] = new Student(2, "Kajet", "Pynka", 5.5);
        study[2] = new Student(3, "Pawel", "Chmiel", 4.0);
        IteratorTablicowy it = new IteratorTablicowy(study);
        wyswietlListe(it);
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj nr indeksu: ");
        int indeks = scan.nextInt();
        System.out.print("Podaj ocene: ");
        double ocena = scan.nextDouble();
        scan.close();
        StudentOIndeksie studo = new StudentOIndeksie();
        IteratorFiltrujacy filt = new IteratorFiltrujacy(it, studo, indeks);
        nadajOcene(indeks, ocena, filt);
        wyswietlListe(it);
        System.out.println(sredniaWsrodZdajacych(filt));
    }

    public static void wyswietlListe(Iterator iter){
        for (iter.first(); !iter.isDone(); iter.next()){
            Student stud = (Student) iter.current();
            System.out.println(stud);
        }
    }

    public static void nadajOcene(int indeks, double ocena, Iterator iter) {
        for (iter.first(); !iter.isDone(); iter.next()){
            Student curr = (Student) iter.current();
            curr.setOcena(ocena);
        }
    }

    public static double sredniaWsrodZdajacych(Iterator iter){
        double suma = 0;
        int liczbaZdajacych = 0;
        for (iter.first(); !iter.isDone(); iter.next()){
            Student temp = (Student) iter.current();
            suma += temp.getOcena();
            liczbaZdajacych += 1;
        }
        return suma/liczbaZdajacych;
    }
}