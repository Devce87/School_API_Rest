package school.com.web.app.mapper;

import org.springframework.stereotype.Component;
import school.com.web.app.domain.dto.StudentDto;
import school.com.web.app.domain.entity.Student;
import school.com.web.app.mapper.interfaces.studentMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDtoMapper implements studentMapper {

    @Override
    public Student studentDTOtoStudent(StudentDto studentDto) {

        return Student.builder()
                .name(studentDto.getName())
                .lastName(studentDto.getLastName())
                .build();
    }

    @Override
    public StudentDto studentTostudentDTO(Student student) {

        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .lastName(student.getLastName())
                .build();
    }

    @Override
    public List<Student> toStudentList(List<StudentDto> studentDtoList) {
        if(studentDtoList==null){
            return null;
        }
        List<Student> students = new ArrayList<>(studentDtoList.size());
        for (StudentDto studentDto:studentDtoList) {
            students.add(studentDTOtoStudent(studentDto));
        }

        return students;
    }

    @Override
    public List<StudentDto> toStudentDtoList(List<Student> studentList) {
        if(studentList==null){
            return null;
        }
        List<StudentDto> studentDtos = new ArrayList<>(studentList.size());
        for (Student student:studentList) {
            studentDtos.add(studentTostudentDTO(student));
        }
        return studentDtos;
    }
}
