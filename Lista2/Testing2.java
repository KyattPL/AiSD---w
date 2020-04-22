public class Testing2 {
    Element head;

    class Element {
        int value;
        Element next;

        public Element(int value) {
            this.value = value;
        }
    }

    public void push(int value) {
        if (head == null) {
            head = new Element(value);
        } else {
            Element newElem = new Element(value);
            newElem.next = head;
            head = newElem;
        }
    }

    public int pop() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        } else {
            int retVal = head.value;
            head = head.next;
            return retVal;
        }
    }
}