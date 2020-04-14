
public class Student {
    private String imie;
    private String nazwisko;
    private int nrIndeksu;
    private double ocenaAISD;

    public Student(String imie, String nazwisko, int nrIndeksu, double ocenaAISD) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrIndeksu = nrIndeksu;
        this.ocenaAISD = ocenaAISD;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " " + nrIndeksu + ", ocena z AiSD: " + ocenaAISD;
    }

    public void setOcena(double ocena) {
        this.ocenaAISD = ocena;
    }

    public double getOcena() {
        return this.ocenaAISD;
    }

    public int getIndeks() {
        return this.nrIndeksu;
    }
}