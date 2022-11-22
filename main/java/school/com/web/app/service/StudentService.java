package school.com.web.app.service;

import org.springframework.stereotype.Service;
import school.com.web.app.domain.dto.StudentDto;
import school.com.web.app.domain.entity.Student;
import school.com.web.app.domain.repository.BaseRepositoryStudent;
import school.com.web.app.domain.repository.BaseRepositoryStudentTask;
import school.com.web.app.domain.repository.BaseRepositoryTask;
import school.com.web.app.exception.ExceptionMessage;
import school.com.web.app.mapper.StudentDtoMapper;
import school.com.web.app.service.interfaces.BaseService;

import javax.persistence.EntityManager;
import java.util.List;

@Service //Anotacion-Bean para indicar que esta clase tiene la logica de negocio y es consumible por Controller
public class StudentService implements BaseService<StudentDto> {

    private static final String ID_NOT_FOUND = "El ID %id no existe";
    private final BaseRepositoryStudent baseRepositoryStudent;
    private final StudentDtoMapper studentDtoMapper;

    public StudentService(BaseRepositoryStudent baseRepositoryStudent, StudentDtoMapper studentDtoMapper) {
        this.baseRepositoryStudent = baseRepositoryStudent;
        this.studentDtoMapper = studentDtoMapper;
    }

    @Override
    public boolean save(StudentDto entidad) {

        baseRepositoryStudent.save(studentDtoMapper.studentDTOtoStudent(entidad));
        return true;
    }

    @Override
    public StudentDto findById(long id) {

        return studentDtoMapper.studentTostudentDTO(baseRepositoryStudent.findById(id)
                .orElseThrow(() -> new ExceptionMessage(ID_NOT_FOUND)));
    }

    @Override
    public List<StudentDto> showAll() {

        List<Student> students = baseRepositoryStudent.findAll();

        if (students.isEmpty()) {
            throw new ExceptionMessage("La lista no tiene elementos.");
        }

        return studentDtoMapper.toStudentDtoList(students);
    }


    @Override
    public boolean update(StudentDto entidad, Long id) {

        Student student = studentDtoMapper.studentDTOtoStudent(findById(id));

        student.setName(entidad.getName());
        student.setLastName(entidad.getLastName());

        baseRepositoryStudent.save(student);

        return true;
    }

    @Override
    public boolean delete(Long id) {

        baseRepositoryStudent.deleteById(findById(id).getId());
        return true;
    }


}
