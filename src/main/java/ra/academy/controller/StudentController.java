package ra.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.academy.entity.Student;
import ra.academy.service.IStudentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api.myservice.com/v1/students")
@CrossOrigin("*")
public class StudentController {
    private final IStudentService studentService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> findById(@PathVariable String id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Student student,@PathVariable Long id){
        student.setId(id);
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteById(@PathVariable String id){
        studentService.delete(id);
        return ResponseEntity.ok("Delete Success!");
    }

}
