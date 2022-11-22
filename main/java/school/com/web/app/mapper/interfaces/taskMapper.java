package school.com.web.app.mapper.interfaces;

import org.mapstruct.Mapper;
import school.com.web.app.domain.dto.StudentDto;
import school.com.web.app.domain.dto.TaskDto;
import school.com.web.app.domain.entity.Student;
import school.com.web.app.domain.entity.Task;

import java.util.List;


@Mapper
public interface taskMapper {


    Task taskDtoToTask(TaskDto taskDto);
    TaskDto taskToTaskDto(Task task);

    List<Task> toTasktList(List<TaskDto> taskDtoList);

    List<TaskDto> toStudentDtoList(List<Task> taskList);
}
