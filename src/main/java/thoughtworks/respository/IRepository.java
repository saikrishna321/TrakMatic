package thoughtworks.respository;

import java.util.Map;

/**
 * Created by bsneha on 21/07/17.
 */
public interface IRepository<T> {
    public void store(String json);

    public T readData( Map<String, String> parameters );

    public void deleteData( Map<String, String> data);
}
