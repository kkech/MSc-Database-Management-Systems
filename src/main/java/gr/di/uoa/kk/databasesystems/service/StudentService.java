package gr.di.uoa.kk.databasesystems.service;

import gr.di.uoa.kk.databasesystems.repository.StudentRepository;
import gr.di.uoa.kk.databasesystems.entities.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public Iterable<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Integer studentId){
      return studentRepository.findOne(studentId);
  }
}
