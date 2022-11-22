package school.com.web.app.service;

import org.springframework.stereotype.Service;
import school.com.web.app.domain.dto.TaskDto;
import school.com.web.app.domain.entity.Task;
import school.com.web.app.domain.repository.BaseRepositoryTask;
import school.com.web.app.exception.ExceptionMessage;
import school.com.web.app.mapper.TaskDtoMapper;
import school.com.web.app.service.interfaces.BaseService;

import java.util.List;

@Service
public class TaskService implements BaseService<TaskDto> {

    private static final String ID_NOT_FOUND = "El ID %id no existe";

    private final BaseRepositoryTask baseRepositoryTask;

    private final TaskDtoMapper taskDtoMapper;

    public TaskService(BaseRepositoryTask baseRepositoryTask, TaskDtoMapper taskDtoMapper) {
        this.baseRepositoryTask = baseRepositoryTask;
        this.taskDtoMapper = taskDtoMapper;
    }

    @Override
    public boolean save(TaskDto taskDto) {
        baseRepositoryTask.save(taskDtoMapper.taskDtoToTask(taskDto));
        return true;
    }

    @Override
    public TaskDto findById(long id) {
        return taskDtoMapper.taskToTaskDto(baseRepositoryTask.findById(id)
                .orElseThrow(()->new ExceptionMessage(ID_NOT_FOUND)));
    }

    @Override
    public List<TaskDto> showAll() {
        List<Task> tasks = baseRepositoryTask.findAll();

        if(tasks.isEmpty()){
            System.out.println("No hay elementos en la lista");
        }
        return taskDtoMapper.toStudentDtoList(tasks);
    }

    @Override
    public boolean update(TaskDto taskDto, Long id) {

        Task  task = taskDtoMapper.taskDtoToTask(findById(id));
        task.setId(id);
        task.setName(taskDto.getName());
        baseRepositoryTask.save(task);

        return true;
    }

    @Override
    public boolean delete(Long id) {

        baseRepositoryTask.deleteById(findById(id).getId());

        return true;
    }
}
