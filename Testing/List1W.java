public class List1W {
    Element head;

    class Element {
        int value;
        Element next;

        public Element(int val) {
            this.value = val;
        }
    }

    private int maxRec(Element e) {
        if (e == null) {
            return -1;
        } else if (e.next == null) {
            return e.value;
        } else {
            return Math.max(e.value, maxRec(e.next));
        }
    }

    public int max() {
        return maxRec(head);
    }

    private Element addRec(Element e, int x) {
        if (e == null) {
            e = new Element(x);
            return e;
        } else if (e.next == null) {
            e.next = new Element(x);
            return head;
        } else {
            return addRec(e.next, x);
        }
    }

    public void add(int x) {
        head = addRec(head, x);
    }

    private int sumRec(Element e) {
        if (e == null) {
            return 0;
        } else {
            return e.value + sumRec(e.next);
        }
    }

    public int sumRec() {
        return sumRec(head);
    }

    private int countRec(Element e) {
        if (e == null) {
            return 0;
        } else {
            return 1 + countRec(e.next);
        }
    }

    public int countRec() {
        return countRec(head);
    }

    private void normShow(Element e) {
        if (e == null) {

        } else {
            System.out.println(e.value);
            normShow(e.next);
        }
    }

    public void normShow() {
        normShow(head);
    }

    private void revShow(Element e) {
        if (e == null) {

        } else if (e.next == null) {
            System.out.println(e.value);
        } else {
            revShow(e.next);
            System.out.println(e.value);
        }
    }

    public void revShow() {
        revShow(head);
    }

    public List1W() {
        head = null;
    }
}