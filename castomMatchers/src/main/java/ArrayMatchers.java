import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayMatchers extends TypeSafeDiagnosingMatcher<Integer[]> {

    private final Integer[] array;

    public ArrayMatchers(Integer[] array){
        this.array = array;
    }

    @Override
    protected boolean matchesSafely(Integer[] integers, Description description) {
        description.appendText("Содержат одни и те же числа");
        Set<Integer> set1 = new HashSet<>(Arrays.asList(integers));

        Set<Integer> set2 = new HashSet<>(Arrays.asList(array));
        return set1.equals(set2);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Не содержат одни и те же числа");
    }

    public static ArrayMatchers arrayMatchers(Integer[] arr){
        return new ArrayMatchers(arr);
    }
}
