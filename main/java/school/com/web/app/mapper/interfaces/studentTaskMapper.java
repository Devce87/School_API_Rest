package school.com.web.app.mapper.interfaces;

import org.mapstruct.Mapper;
import school.com.web.app.domain.dto.StudentDto;
import school.com.web.app.domain.dto.StudentTaskDto;
import school.com.web.app.domain.entity.StudentTask;

import java.util.List;

@Mapper
public interface studentTaskMapper {

    StudentTaskDto studentTaskToDto(StudentTask studentTask);

    StudentTask studentTaskDtoToStudentTask(StudentTaskDto studentTaskDto);

    List<StudentTaskDto> toStudentTaskList(List<StudentTask> studentTasksList);
}
