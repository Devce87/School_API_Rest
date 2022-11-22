package school.com.web.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.com.web.app.domain.entity.Task;

public interface BaseRepositoryTask extends JpaRepository<Task, Long> {
}
