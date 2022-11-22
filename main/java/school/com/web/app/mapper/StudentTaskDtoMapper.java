package school.com.web.app.mapper;

import org.springframework.stereotype.Component;
import school.com.web.app.domain.dto.StudentDto;
import school.com.web.app.domain.dto.StudentTaskDto;
import school.com.web.app.domain.entity.StudentTask;
import school.com.web.app.mapper.interfaces.studentTaskMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentTaskDtoMapper implements studentTaskMapper {

    private final StudentDtoMapper studentDtoMapper;

    private final TaskDtoMapper taskDtoMapper;

    public StudentTaskDtoMapper(StudentDtoMapper studentDtoMapper, TaskDtoMapper taskDtoMapper) {
        this.studentDtoMapper = studentDtoMapper;
        this.taskDtoMapper = taskDtoMapper;
    }


    @Override
    public StudentTaskDto studentTaskToDto(StudentTask studentTask) {

        return StudentTaskDto.builder()
                .id(studentTask.getId())
                .studentDto(studentDtoMapper.studentTostudentDTO(studentTask.getStudent()))
                .taskDto(taskDtoMapper.taskToTaskDto(studentTask.getTask()))
                .build();
    }

    @Override
    public StudentTask studentTaskDtoToStudentTask(StudentTaskDto studentTaskDto) {

        return StudentTask.builder()
                .id(studentTaskDto.getId())
                .student(studentDtoMapper.studentDTOtoStudent(studentTaskDto.getStudentDto()))
                .task(taskDtoMapper.taskDtoToTask(studentTaskDto.getTaskDto()))
                .build();
    }

    @Override
    public List<StudentTaskDto> toStudentTaskList(List<StudentTask> studentTasksList) {

        if(studentTasksList==null){
            return null;
        }

        List<StudentTaskDto> studentTaskDtoList = new ArrayList<>();
        for (StudentTask studentTask: studentTasksList) {
            studentTaskDtoList.add(studentTaskToDto(studentTask));
        }

        return studentTaskDtoList;
    }
}
