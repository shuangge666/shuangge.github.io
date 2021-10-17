package streamStudy;

public class TupleTest<A,B>{
    A a;
    B b;

    public TupleTest(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "TupleTest{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public static void main(String[] args) {
        TupleTest<String ,Integer>tup=new TupleTest<>("testString",666);
        System.out.println(tup.toString());
    }
}
