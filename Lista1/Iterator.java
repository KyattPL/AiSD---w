public interface Iterator {
    public void first();

    public void last();

    public void next();

    public void previous();

    public Object current();

    public boolean isDone();
}