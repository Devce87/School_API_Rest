package school.com.web.app.mapper;

import org.springframework.stereotype.Component;
import school.com.web.app.domain.dto.TaskDto;
import school.com.web.app.domain.entity.Task;
import school.com.web.app.mapper.interfaces.taskMapper;

import java.util.ArrayList;
import java.util.List;


@Component
public class TaskDtoMapper implements taskMapper {

    @Override
    public Task taskDtoToTask(TaskDto taskDto) {

        return Task.builder()
                .name(taskDto.getName())
                .build();
    }

    @Override
    public TaskDto taskToTaskDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .build();
    }

    @Override
    public List<Task> toTasktList(List<TaskDto> taskDtoList) {
        if(taskDtoList==null){
            return null;
        }
        List<Task> tasks = new ArrayList<>(taskDtoList.size());
        for (TaskDto taskDto:taskDtoList) {
            tasks.add(taskDtoToTask(taskDto));
        }

        return tasks;
    }

    @Override
    public List<TaskDto> toStudentDtoList(List<Task> taskList) {
        if(taskList==null){
            return null;
        }
        List<TaskDto> taskDtos = new ArrayList<>(taskList.size());
        for (Task task:taskList) {
            taskDtos.add(taskToTaskDto(task));
        }
        return taskDtos;
    }
}
