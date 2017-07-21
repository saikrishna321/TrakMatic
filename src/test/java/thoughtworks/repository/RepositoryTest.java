package thoughtworks.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.junit.Test;
import thoughtworks.respository.Repository;

import java.util.HashMap;

/**
 * Created by bsneha on 21/07/17.
 */
public class RepositoryTest {
    @Test
    public void shouldStoreStringJsonToRepository() throws JSONException, JsonProcessingException {
        Repository repository = new Repository();
        repository.store("{\"name\":\"sherlock\",\"foo\":\"bar\"}");
        repository.store("{\"foo\":\"bar\",\"js\":\"react\"}");
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("foo","bar");
        repository.readData(parameters);
    }
}
