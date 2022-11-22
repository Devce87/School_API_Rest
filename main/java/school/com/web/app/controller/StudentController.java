package school.com.web.app.controller;

import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import school.com.web.app.domain.dto.StudentDto;
import school.com.web.app.domain.entity.Student;
import school.com.web.app.service.interfaces.BaseService;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final BaseService<StudentDto> baseService;

    public StudentController(BaseService<StudentDto> baseService) {
        this.baseService = baseService;

    }

    @PostMapping(value = "/save")
    public void saveStudent(@RequestBody StudentDto studentDto) {
        baseService.save(studentDto);
    }

    @GetMapping(value = "/showAll")
    public List<StudentDto> showAllStudents() {
        return baseService.showAll();
    }

    @GetMapping(value = "/find/{id}")
    public StudentDto getStudentById(@PathVariable long id) {
        return baseService.findById(id);
    }

    @PutMapping(value= "/update/{id}")
    public void updateStudent(@RequestBody StudentDto studentDto, @PathVariable long id){
        baseService.update(studentDto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteStudent (@PathVariable long id){
        baseService.delete(id);
    }

}
