package cours.ms9.service;

import cours.ms9.dto.StudentDto;
import cours.ms9.model.Student;
import cours.ms9.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImple implements StudentService {

    private final StudentRepository repository;
    private final ModelMapper mapper;


    @Override
    public StudentDto getStudentById(Long id) {
        Student byId = repository.getById(id);
        StudentDto dto = mapper.map(byId, StudentDto.class);
        return dto;
    }

    @Override
    public StudentDto createStudent(StudentDto dto) {
        Student student = mapper.map(dto,Student.class);
        Student save = repository.save(student);
        return mapper.map(save, StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(StudentDto dto) {
        Student student =
        repository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setAge(dto.getAge());
        student.setName(dto.getName());
        Student save = repository.save(student);
        return mapper.map(save , StudentDto.class);
    }
}
