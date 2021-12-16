import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class ArrayMatcherTest {

    @Test
    public void test(){
        Integer[] arr1 = {1,2,3,4,4,4};
        Integer[] arr2 = {4,3,2,1};

        assertThat(arr1, ArrayMatchers.arrayMatchers(arr2));
    }
}
