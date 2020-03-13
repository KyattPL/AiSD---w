public class IteratorFiltrujacy implements Iterator {

    private final Iterator i;
    private final PredicateIndex p;
    private final int indeks;

    public IteratorFiltrujacy(Iterator it, PredicateIndex pr, int indeks){
        this.i = it;
        this.p = pr;
        it.first();
        this.indeks = indeks;
    }

    public void filtrujDoPrzodu() {
        while (!i.isDone() && !p.test(i.current(), indeks)) {
            i.next();
        }
    }

    public void filtrujDoTylu() {
        while (!i.isDone() && !p.test(i.current(), indeks)) {
            i.previous();
        }
    }

    @Override
    public void first() {
        i.first();
        filtrujDoPrzodu();
    }

    @Override
    public void last() {
        i.last();
        filtrujDoTylu();
    }

    @Override
    public boolean isDone() {
        return i.isDone();
    }

    @Override
    public Object current() {
        return i.current();
    }

    @Override
    public void next() {
        i.next();
        filtrujDoPrzodu();
    }

    @Override
    public void previous() {
        i.previous();
        filtrujDoTylu();
    }
}