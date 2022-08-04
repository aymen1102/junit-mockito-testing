package com.aybaroud.mockitoExamples.restApiExample.repositories;

import com.aybaroud.mockitoExamples.restApiExample.model.Gender;
import com.aybaroud.mockitoExamples.restApiExample.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentEmailExists_assertj() {
        String email = "amina@gmail.com";
        Student student = new Student("Amina",email,Gender.FEMALE);
        studentRepository.save(student);
        Boolean expected = studentRepository.selectExistsEmail(email);
        Assertions.assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckIfStudentEmailExists_mockito(){
        /* mock studentRepository*/
        StudentRepository studentRepositorySpy = Mockito.spy(StudentRepository.class);
        /* given */
        boolean given = true;
        String email = "amina@gmail.com";
        Student student = new Student("Amina",email,Gender.FEMALE);
        studentRepositorySpy.save(student);
        Mockito.verify(studentRepositorySpy).save(student);
        /* when then */
        Mockito.doReturn(given)
                .when(studentRepositorySpy)
                .selectExistsEmail(email);
        Mockito.doReturn(email)
                .when(studentRepositorySpy)
                .findAll().get(0).getEmail().toString();
        /* begin test */
        boolean actual = studentRepositorySpy.selectExistsEmail(email);
        assertEquals(email,studentRepositorySpy.findAll().get(0).getEmail());
        assertTrue(actual);
    }

    @Test
    void itShouldCheckIfStudentEmailExists_mockito_mock(){
        /* mock studentRepository*/
        StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
        /* given */
        boolean given = true;
        String email = "amina@gmail.com";
        Student student = new Student("Amina",email,Gender.FEMALE);
        studentRepository.save(student);
        /* when then */
        Mockito.when(studentRepository.selectExistsEmail(email))
                .thenReturn(given);
        /* begin test */
        boolean actual = studentRepository.selectExistsEmail(email);
        assertEquals(email,studentRepository.findAll().get(0).getEmail());
        assertTrue(actual);
    }

    @Test
    void itShouldCheckIfStudentEmailDoesNotExists() {
        String email = "amina@gmail.com";
        Boolean expected = studentRepository.selectExistsEmail(email);
        Assertions.assertThat(expected).isFalse();
    }
}