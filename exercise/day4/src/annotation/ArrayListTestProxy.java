package annotation;

import java.lang.reflect.Method;
import java.util.Objects;

public class ArrayListTestProxy implements PerformanceTestable{
    private final PerformanceTestable performanceTestable;

    public ArrayListTestProxy(PerformanceTestable performanceTestable) {
        this.performanceTestable = performanceTestable;
    }

    @Override
    public void test() {
        if(hasStopWatch()) {
            System.out.println("ArrayListTest");
            long start = System.currentTimeMillis();
            System.out.println("## ArrayList 시간 측정 시작: " + start);
            performanceTestable.test();
            long end = System.currentTimeMillis();
            System.out.println("## ArrayList 시간 측정 종료: " +  end);
            long result = (end - start)/1000;
            System.out.println("ArrayList 실행시간(초): " + result);

            System.out.print(System.lineSeparator());

            System.out.println("LinkedListTest");
            Long start2 = System.currentTimeMillis();
            System.out.println("## LinkedList 시간 측정 시작: " + start);
            performanceTestable.test();
            long end2 = System.currentTimeMillis();
            System.out.println("## LinkedList 시간 측정 종료: " + end2);
            long result2 = (end2 - start)/1000;
            System.out.println("LinkedList 실행시간(초): " + result2);
        }
    }

    private boolean hasStopWatch() {
        for(Method method: performanceTestable.getClass().getDeclaredMethods()) {
            StopWatch stopWatch = method.getAnnotation(StopWatch.class);
            if(Objects.nonNull(stopWatch)) {
                return true;
            }
        }
        return false;
    }

}
