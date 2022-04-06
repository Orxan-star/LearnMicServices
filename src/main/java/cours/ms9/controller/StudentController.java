package cours.ms9.controller;

import cours.ms9.dto.StudentDto;
import cours.ms9.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return service.getStudentById(id);
    }

    @PostMapping
    public StudentDto creatStudent(@RequestBody StudentDto dto){
        return service.createStudent(dto);
    }

    @PutMapping
    public StudentDto updateStudent(@RequestBody StudentDto dto){
        return service.updateStudent(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
    }
}
