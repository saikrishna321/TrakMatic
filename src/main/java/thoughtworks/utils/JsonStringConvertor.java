package thoughtworks.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bsneha on 21/07/17.
 */
public class JsonStringConvertor {

    public static String convert( Object data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.writeValueAsString(data);
    }


    public static String convert( Map<String,String[]> data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> processedData = new HashMap<>();
        data.forEach((key,value)->{
            processedData.put(key, value[0]);
        });
        return  mapper.writeValueAsString(processedData);
    }
}
