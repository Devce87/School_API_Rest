package school.com.web.app.controller;

import org.springframework.web.bind.annotation.*;
import school.com.web.app.domain.dto.TaskDto;
import school.com.web.app.domain.entity.Task;
import school.com.web.app.service.interfaces.BaseService;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final BaseService<TaskDto> baseService;

    public TaskController(BaseService<TaskDto> baseService) {
        this.baseService = baseService;
    }

    @PostMapping(value = "/save")
    public void saveTask(@RequestBody TaskDto taskDto) {
        baseService.save(taskDto);
    }

    @GetMapping(value = "/find/{id}")
    public TaskDto getTaskById(@PathVariable Long id) {
        return baseService.findById(id);
    }

    @GetMapping(value = "/showAll")
    public List<TaskDto> showAllTasks() {
        return baseService.showAll();
    }

    @PutMapping(value = "/update/{id}")
    public void updateTask(@RequestBody TaskDto taskDto, @PathVariable Long id) {
        baseService.update(taskDto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        baseService.delete(id);
    }

}
