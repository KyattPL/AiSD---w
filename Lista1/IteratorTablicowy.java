public class IteratorTablicowy implements Iterator {

    public final int beginning;
    public final int end;
    public final Object[] tab;
    public int current;

    public IteratorTablicowy(Object[] tab) {
        this.tab = tab;
        this.beginning = 0;
        this.end = tab.length - 1;
        this.current = 0;
    }

    @Override
    public void first() {
        this.current = 0;
    }

    @Override
    public void last() {
        this.current = tab.length - 1;
    }

    @Override
    public void next() {
        this.current += 1;
    }

    @Override
    public void previous() {
        this.current -= 1;
    }

    @Override
    public boolean isDone() {
        return (current < beginning || current > end);
    }

    @Override
    public Object current() {
        return this.tab[current];
    }

}