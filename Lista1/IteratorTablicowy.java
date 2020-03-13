public class IteratorTablicowy implements Iterator {

    final Object[] tablica;
    final int pierwszy;
    final int ostatni;
    int biezacy;

    public IteratorTablicowy(Object[] tab){
        this.tablica = tab;
        this.pierwszy = 0;
        this.ostatni = tab.length - 1;
    }

    @Override
    public void first() {
        this.biezacy = this.pierwszy;
    }

    @Override
    public void last() {
        this.biezacy = this.ostatni;
    }

    @Override
    public boolean isDone() {
        return (biezacy < pierwszy || biezacy > ostatni);
    }

    @Override
    public Object current() {
        return tablica[biezacy];
    }

    @Override
    public void next() {
        biezacy += 1;
    }

    @Override
    public void previous() {
        biezacy -= 1;
    }
}