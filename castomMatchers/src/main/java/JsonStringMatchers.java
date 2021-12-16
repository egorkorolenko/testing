import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.json.JSONObject;

public class JsonStringMatchers extends TypeSafeDiagnosingMatcher<String> {

    @Override
    protected boolean matchesSafely(String s, Description description) {
        description.appendText("НЕ содержит поле status или значение success");
        JSONObject jsonObject = new JSONObject(s);

        return jsonObject.getString("status").equals("success");
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Содержит поле status и значение success");
    }

    public static JsonStringMatchers jsonStringMatchers(){
        return new JsonStringMatchers();
    }
}
