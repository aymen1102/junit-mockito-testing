package com.aybaroud.mockitoExamples.restApiExample.service;

import com.aybaroud.mockitoExamples.restApiExample.exception.BadRequestException;
import com.aybaroud.mockitoExamples.restApiExample.model.Gender;
import com.aybaroud.mockitoExamples.restApiExample.model.Student;
import com.aybaroud.mockitoExamples.restApiExample.repositories.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository);
    }

    @Test
    void getAllStudents() {
        //when
        studentService.getAllStudents();
        //then
        verify(studentRepository).findAll();
    }

    @Test
    void addStudent() {
        //given
        Student student = new Student(
                "melanie",
                "melanie@gmail.com",
                Gender.FEMALE
        );
        //when
        studentService.addStudent(student);
        //then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository)
                .save(studentArgumentCaptor.capture());  // ArgumentCaptor allows us to capture an argument passed to a method in order to inspect it.
                                                         // This is especially useful when we can't access the argument outside of the method we'd like to test.
        Student capturedStudent = studentArgumentCaptor.getValue();
        Assertions.assertThat(capturedStudent).isEqualTo(student);
    }


    @Test
    void willThrowWhenEmail() {
        //given
        Student student = new Student(
                "melanie",
                "melanie@gmail.com",
                Gender.FEMALE
        );
        given(studentRepository.selectExistsEmail(anyString()))
                .willReturn(true);
        //when
        //then
        assertThatThrownBy(()->studentService.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");
        verify(studentRepository, never()).save(any());
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}