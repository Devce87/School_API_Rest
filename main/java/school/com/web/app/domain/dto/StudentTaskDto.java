package school.com.web.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class StudentTaskDto {

    private long id;

    private StudentDto studentDto;

    private TaskDto taskDto;
}
