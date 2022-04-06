package cours.ms9.service;

import cours.ms9.dto.StudentDto;

public interface StudentService {

    StudentDto getStudentById(Long id);

    StudentDto createStudent(StudentDto dto);

    void deleteStudent(Long id);

    StudentDto updateStudent(StudentDto dto);

}
