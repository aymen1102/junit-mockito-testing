package com.aybaroud.junitExamples.restapiExamples.service;

import com.aybaroud.junitExamples.restapiExamples.Repositories.StudentRepository;
import com.aybaroud.junitExamples.restapiExamples.model.Student;
import com.aybaroud.junitExamples.restapiExamples.exception.StudentNotFoundException;
import com.aybaroud.junitExamples.restapiExamples.exception.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Boolean existsEmail = studentRepository
                .selectExistsEmail(student.getEmail());
        if (existsEmail) {
            throw new BadRequestException(
                    "Email " + student.getEmail() + " taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(
                    "Student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
