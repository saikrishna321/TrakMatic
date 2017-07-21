package thoughtworks.respository;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by bsneha on 21/07/17.
 */
@Component
public class Respository implements IRepository<LinkedList<Object>> {
    private LinkedList<Object> data;

    public Respository() {
        this.data = new LinkedList<>();
    }

    @Override
    public void store(String json) {
        this.data.add(json);
    }

    @Override
    public LinkedList<Object> readData( Map<String, String> parameters) {
        return null;
    }

    @Override
    public void deleteData( Map<String, String> data) {

    }

}
