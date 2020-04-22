public class Testing {
    Element head, tail;

    class Element {
        int value;
        Element next;

        public Element(int value) {
            this.value = value;
        }
    }

    public void enqueue(int value) {
        if (head == null) {
            head = new Element(value);
            tail = head;
        }
        Element newElem = new Element(value);
        tail.next = newElem;
        tail = newElem;
    }

    public int dequeue() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        int retVal = head.value;
        head = head.next;
        return retVal;
    }
}