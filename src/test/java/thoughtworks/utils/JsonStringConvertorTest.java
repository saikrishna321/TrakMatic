package thoughtworks.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

public class JsonStringConvertorTest {

    class TestClass {
        public String name;
        public String password;

        public TestClass(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }

    @Test
    public void shouldConvertAnyObjectToJSONString() throws JSONException, JsonProcessingException {
        TestClass test = new TestClass("sherlock", "secret");
        String jsonString = JsonStringConvertor.convert(test);
        Assert.assertEquals("{\"name\":\"sherlock\",\"password\":\"secret\"}", jsonString);
    }


}
