public class Student {
    private int nrIndeksu;
    private String imie;
    private String nazwisko;
    private double ocenaAISD;

    public Student(int nr, String im, String nazw, double ocena){
        this.nrIndeksu = nr;
        this.imie = im;
        this.nazwisko = nazw;
        this.ocenaAISD = ocena;
    }

    @Override
    public String toString() {
        return nrIndeksu + " " + imie + " " + nazwisko + " Ocena: " + ocenaAISD;
    }

    public int getIndeks() {
        return nrIndeksu;
    }

    public double getOcena() {
        return ocenaAISD;
    }

    public void setOcena(double ocena) {
        this.ocenaAISD = ocena;
    }
}