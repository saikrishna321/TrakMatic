package thoughtworks.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.junit.Test;
import thoughtworks.respository.Repository;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;


public class RepositoryTest {

    @Test
    public void shouldStoreStringJsonToRepository() throws JSONException, JsonProcessingException {
        Repository repository = new Repository();
        repository.store("{\"name\":\"sherlock\",\"foo\":\"bar\"}");
        repository.store("{\"foo\":\"bar\",\"js\":\"react\"}");
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("foo", "bar");
        assertTrue(repository.readData(parameters).size() == 2);
    }
}
