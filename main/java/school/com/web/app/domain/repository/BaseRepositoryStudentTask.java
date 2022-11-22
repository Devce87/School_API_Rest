package school.com.web.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.com.web.app.domain.entity.StudentTask;

import java.util.List;

public interface BaseRepositoryStudentTask extends JpaRepository<StudentTask, Long> {

    @Query(value="SELECT * FROM student_task JOIN student JOIN task ON student_task.deleted=0 AND student.deleted=0 AND task.deleted=0;", nativeQuery = true )
    public List<StudentTask> findAllQ();
}
