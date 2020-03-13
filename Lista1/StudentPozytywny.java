public class StudentPozytywny implements Predicate {

    @Override
    public boolean test(Object o) {
        Student temp = (Student) o;
        return temp.getOcena() >= 3.0;
    }
}