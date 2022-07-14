package com.aybaroud.junitExamples.restapiExamples.service;

import com.aybaroud.junitExamples.restapiExamples.repositories.StudentRepository;
import com.aybaroud.junitExamples.restapiExamples.model.Gender;
import com.aybaroud.junitExamples.restapiExamples.model.Student;
import com.aybaroud.junitExamples.restapiExamples.exception.BadRequestException;
import com.aybaroud.junitExamples.restapiExamples.service.StudentService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StudentService(studentRepository);
    }

    @Test
    void getAllStudents() {
        //when
        underTest.getAllStudents();
        //then
        verify(studentRepository).findAll();
    }

    @Test
    void canAddStudent() {
        //given
        Student student = new Student(
                "melanie",
                "melanie@gmail.com",
                Gender.FEMALE
        );
        //when
        underTest.addStudent(student);

        //then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(student);
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
        assertThatThrownBy(()->underTest.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");

        verify(studentRepository, never()).save(any());
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}