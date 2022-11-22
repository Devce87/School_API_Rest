package school.com.web.app.service.interfaces;

import java.util.List;

public interface StudentTaskService <T>{

    boolean saveStudentTask(long studentID, long taskId);
    T getStudentTaskById(long id);
    List<T> showAllStudentTask();
    boolean updateStudentTask(long studentTaskId, long studentId, long taskId);
    boolean deleteStudentTask (long id);

}
