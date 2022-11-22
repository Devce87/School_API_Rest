package school.com.web.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.com.web.app.domain.entity.Student;

public interface BaseRepositoryStudent extends JpaRepository<Student, Long>{
}
