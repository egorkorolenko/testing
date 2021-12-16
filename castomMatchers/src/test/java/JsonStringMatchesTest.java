import org.json.JSONException;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;


public class JsonStringMatchesTest {

    @Test
    public void testJsonParser(){
        String str = "{\"status\": \"success\"}";
        assertThat(str, JsonStringMatchers.jsonStringMatchers());

    }

    @Test(expected = AssertionError.class)
    public void testJsonParserFail(){
        String str = "{\"status\": \"error\"}";
        assertThat(str, JsonStringMatchers.jsonStringMatchers());
    }

    @Test(expected = JSONException.class)
    public void testJsonParserFail2(){
        String str = "";
        assertThat(str, JsonStringMatchers.jsonStringMatchers());
    }
}
