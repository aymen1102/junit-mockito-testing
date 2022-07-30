package com.aybaroud.mockitoExamples.restApiExample.repositories;

import com.aybaroud.mockitoExamples.restApiExample.model.Gender;
import com.aybaroud.mockitoExamples.restApiExample.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentEmailExists() {
        // given
        String email = "amina@gmail.com";
        Student student = new Student("Amina",email,Gender.FEMALE);
        studentRepository.save(student);
        // when
        Boolean expected = studentRepository.selectExistsEmail(email);
        // then
        Assertions.assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckIfStudentEmailDoesNotExists() {
        // given
        String email = "amina@gmail.com";
        // when
        Boolean expected = studentRepository.selectExistsEmail(email);
        // then
        Assertions.assertThat(expected).isFalse();
    }
}