package school.com.web.app.mapper.interfaces;

import org.mapstruct.Mapper;
import school.com.web.app.domain.dto.StudentDto;
import school.com.web.app.domain.entity.Student;

import java.util.List;

@Mapper
public interface studentMapper  {

    Student studentDTOtoStudent(StudentDto studentDto);
    StudentDto studentTostudentDTO(Student student);

    List<Student> toStudentList(List<StudentDto> studentDtoList);

    List<StudentDto> toStudentDtoList(List<Student> studentList);
}
