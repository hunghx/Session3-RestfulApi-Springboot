package ra.academy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import ra.academy.entity.Student;
import ra.academy.repository.IStudentRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{

    private final IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String id)  {
        return studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Khoong tim thay tai nguyen"));

    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(String id) {
        studentRepository.findById(id).orElseThrow(() -> new  NoSuchElementException("Khong tim thay id"));
        studentRepository.deleteById(id);
    }
}
