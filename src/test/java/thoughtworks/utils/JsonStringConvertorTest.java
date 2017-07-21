package thoughtworks.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

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

    @Test
    public void shouldConvertAnyMapWithValueAsStringArrayAndKeyAsStringToJsonString() throws JSONException, JsonProcessingException {
        HashMap<String, String[]> test = new HashMap<>();
        test.put("foo", new String[]{"bar"});
        test.put("js", new String[]{"react"});

        String jsonString = JsonStringConvertor.convert(test);
        Assert.assertEquals("{\"foo\":\"bar\",\"js\":\"react\"}", jsonString);
    }


}
