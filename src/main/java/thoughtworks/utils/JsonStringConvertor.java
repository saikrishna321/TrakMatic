package thoughtworks.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by bsneha on 21/07/17.
 */
public class JsonStringConvertor {

    public static String convert( Object data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.writeValueAsString(data);
    }
}
