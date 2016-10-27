package eremushkin.service.impl;

import eremushkin.entity.Student;
import eremushkin.repository.StudentRepository;
import eremushkin.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements EntityService<Student> {

    @Autowired
    private StudentRepository repository;

    public Student addBank(Student student) {
        Student savedStudent = repository.saveAndFlush(student);
        return savedStudent;
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public Student getById(long id) {
        return repository.findOne(id);
    }

    public Student edit(Student student) {
        return repository.saveAndFlush(student);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }
}
