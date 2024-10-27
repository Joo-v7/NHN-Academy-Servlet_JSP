package annotation;

public class ArrayListTestMain {
    public static void main(String[] args) {
//        ArrayListTest arrayListTest = new ArrayListTest();
//        arrayListTest.test();

        /* main 실행을 ArrayListTestProx를 통해서 실행 */
        ArrayListTestProxy arrayListTestProxy = new ArrayListTestProxy(new ArrayListTest());
        arrayListTestProxy.test();
    }
}
