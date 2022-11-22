package school.com.web.app.service;


import org.springframework.stereotype.Service;
import school.com.web.app.domain.dto.StudentTaskDto;
import school.com.web.app.domain.entity.StudentTask;
import school.com.web.app.domain.repository.*;
import school.com.web.app.exception.ExceptionMessage;
import school.com.web.app.mapper.StudentTaskDtoMapper;
import school.com.web.app.service.interfaces.StudentTaskService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentTaskServiceImpl implements StudentTaskService<StudentTaskDto> {

    private static final String ID_NOT_FOUND = "El ID %id no existe";

    private final BaseRepositoryStudent baseRepositoryStudent;
    private final BaseRepositoryStudentTask baseRepositoryStudentTask;
    private final BaseRepositoryTask baseRepositoryTask;
    private final StudentTaskDtoMapper studentTaskDtoMapper;

    public StudentTaskServiceImpl(BaseRepositoryStudent baseRepositoryStudent, BaseRepositoryStudentTask baseRepositoryStudentTask, BaseRepositoryTask baseRepositoryTask, StudentTaskDtoMapper studentTaskDtoMapper) {
        this.baseRepositoryStudent = baseRepositoryStudent;
        this.baseRepositoryStudentTask = baseRepositoryStudentTask;
        this.baseRepositoryTask = baseRepositoryTask;
        this.studentTaskDtoMapper = studentTaskDtoMapper;
    }

    @Override
    public boolean saveStudentTask(long studentId, long taskId) {

        baseRepositoryStudentTask.save(
                StudentTask.builder()
                        .student(baseRepositoryStudent.getReferenceById(studentId))
                        .task(baseRepositoryTask.getReferenceById(taskId))
                        .build());
        return true;
    }

    @Override
    public StudentTaskDto getStudentTaskById(long id) {

        return studentTaskDtoMapper.studentTaskToDto(baseRepositoryStudentTask.findById(id)
                .orElseThrow(() -> new ExceptionMessage(ID_NOT_FOUND)));
    }

    @Override
    public List<StudentTaskDto> showAllStudentTask() {

        List<StudentTask> studentTasks = baseRepositoryStudentTask.findAll()
                .stream()
                .filter(studentTask -> studentTask.getStudent()!=null && studentTask.getTask()!=null)
                .collect(Collectors.toList());

        if (studentTasks == null || studentTasks.isEmpty())
            throw new ExceptionMessage("La lista no contiene elementos");

        return studentTaskDtoMapper.toStudentTaskList(studentTasks);
    }

    @Override
    public boolean updateStudentTask(long studentTaskId, long studentId, long taskId) {

        StudentTask studentTask = baseRepositoryStudentTask.findById(studentTaskId)
                        .orElseThrow(()-> new ExceptionMessage(ID_NOT_FOUND));

        studentTask.setStudent(baseRepositoryStudent.getReferenceById(studentId));
        studentTask.setTask(baseRepositoryTask.getReferenceById(taskId));

        baseRepositoryStudentTask.save(studentTask);
        return true;
    }

    @Override
    public boolean deleteStudentTask(long id) {

        baseRepositoryStudentTask.deleteById(getStudentTaskById(id).getId());

        return true;
    }


}
