package school.com.web.app.service.interfaces;

public interface UserService <T>{

    public boolean save (T entity);
    public T findByEmail(String email);



}
