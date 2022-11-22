package school.com.web.app.service.interfaces;

import java.util.List;

public interface BaseService <R>{

    public boolean save(R entidad);
    public R findById(long id);
    public List<R> showAll();
    public boolean update(R entidad, Long id);
    public boolean delete (Long id);
}
