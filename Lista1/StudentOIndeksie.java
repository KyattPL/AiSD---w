public class StudentOIndeksie implements PredicateIndex {

    @Override
    public boolean test(Object o, int index) {
       Student temp = (Student) o;
       return temp.getIndeks() == index;
    }
    
}