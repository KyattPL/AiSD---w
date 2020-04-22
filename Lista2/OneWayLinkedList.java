import java.util.AbstractList;
import java.util.Iterator;

public class OneWayLinkedList<E> extends AbstractList<E> {
    private class Element {
        E value;
        Element next;

        public E getValue() {
            return this.value;
        }

        public Element getNext() {
            return this.next;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        Element(E data) {
            this.value = data;
            this.next = null;
        }
    }

    private class InnerIterator implements Iterator<E> {
        Element actElem;

        public InnerIterator() {
            actElem = head;
        }

        @Override
        public boolean hasNext() {
            return actElem != null;
        }

        @Override
        public E next() {
            E value = actElem.getValue();
            actElem = actElem.getNext();
            return value;
        }

    }

    Element head;

    public OneWayLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean add(E value) {
        if (isEmpty()) {
            head = new Element(value);
            return true;
        }
        Element actElem = head;
        while (actElem.getNext() != null) {
            actElem = actElem.getNext();
        }
        Element newElem = new Element(value);
        actElem.setNext(newElem);
        return true;
    }

    public E removeAt(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = null;
        }
        int counter = 1;
        Element actElem = head;
        while (index - 1 != counter && actElem.getNext() != null) {
            counter++;
            actElem = actElem.getNext();
        }
        if (index - 1 == counter) {
            E retVal = actElem.getNext().getValue();
            actElem.setNext(actElem.getNext().getNext());
            return retVal;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public E get(int index) {
        if (isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head.getValue();
        }
        Element actElem = head;
        // System.out.println(head.getValue());
        int counter = 0;
        while (index != counter && actElem.getNext() != null) {
            actElem = actElem.getNext();
            counter += 1;
        }
        if (index == counter) {
            return actElem.getValue();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    @Override
    public boolean contains(Object value) {
        E valueConv = (E) value;
        if (isEmpty()) {
            return false;
        }
        Element actElem = head;
        while (actElem.getNext() != null && actElem.getValue() != valueConv) {
            actElem = actElem.getNext();
        }
        if (actElem.getValue() == valueConv) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        // ye whatever
        return 0;
    }

}