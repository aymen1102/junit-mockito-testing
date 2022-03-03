package com.aybaroud.examples.datajpa.student;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentEmailExists() {
        // given
        String email = "amina@gmail.com";
        Student student = new Student(
                "Amina",
                email,
                Gender.FEMALE
        );
        underTest.save(student);
        // when
        Boolean expected = underTest.selectExistsEmail(email);
        // then
        Assertions.assertThat(expected).isTrue();

    }

    @Test
    void itShouldCheckIfStudentEmailDoesNotExists() {
        // given
        String email = "amina@gmail.com";
        // when
        Boolean expected = underTest.selectExistsEmail(email);
        // then
        Assertions.assertThat(expected).isFalse();

    }
}