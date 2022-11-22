package school.com.web.app.controller;

import org.springframework.web.bind.annotation.*;
import school.com.web.app.domain.dto.StudentTaskDto;
import school.com.web.app.domain.entity.StudentTask;
import school.com.web.app.service.interfaces.StudentTaskService;

import java.util.List;

@RestController
@RequestMapping("/studenttask")
public class StudentTaskController {
    private final StudentTaskService<StudentTaskDto> studentTaskService;

    public StudentTaskController(StudentTaskService<StudentTaskDto> studentTaskService) {
        this.studentTaskService = studentTaskService;
    }

    @PostMapping(value = "/student{studentId}/task{taskId}")
    public void saveStudentTask(@PathVariable long studentId, @PathVariable long taskId){
        studentTaskService.saveStudentTask(studentId,taskId);

    }

    @GetMapping(value = "/showAll")
    public List<StudentTaskDto> showAllStudentTasks(){
        return studentTaskService.showAllStudentTask();
    }

    @GetMapping(value = "/getById/{id}")
    public StudentTaskDto getStudentTaskById(@PathVariable long id){
        return studentTaskService.getStudentTaskById(id);
    }

    @PutMapping(value = "/studentTask{studentTaskId}/student{studentId}/task{taskId}")
    public void updateStudentTask(@PathVariable long studentTaskId, @PathVariable long studentId, @PathVariable long taskId){
        studentTaskService.updateStudentTask(studentTaskId, studentId, taskId);
    }

    @DeleteMapping(value= "/delete{id}")
    public void deleteStudentTask(@PathVariable long id){
        studentTaskService.deleteStudentTask(id);
    }

}
