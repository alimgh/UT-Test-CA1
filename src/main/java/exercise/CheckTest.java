package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckTest {

    @Test
    void hasPassedPre() {
        // Test 1 - 2 passed
        Course course = new Course();
        course.id = 1;
        course.pre = List.of(2, 3);
        Record record1 = new Record();
        record1.courseId = 2;
        record1.grade = 10;
        record1.isMehman = false;
        Record record2 = new Record();
        record2.courseId = 3;
        record2.grade = 10;
        record2.isMehman = false;
        assertTrue(Check.hasPassedPre(List.of(record1, record2), course));

        // Test 2 - 3 passed
        course = new Course();
        course.id = 1;
        course.pre = List.of(2, 3);
        record1 = new Record();
        record1.courseId = 2;
        record1.grade = 10;
        record1.isMehman = false;
        record2 = new Record();
        record2.courseId = 3;
        record2.grade = 10;
        record2.isMehman = false;
        Record record3 = new Record();
        record3.courseId = 4;
        record3.grade = 10;
        record3.isMehman = false;
        assertTrue(Check.hasPassedPre(List.of(record1, record2, record3), course));

        // Test 3 - 2 pre passed
        course = new Course();
        course.id = 1;
        course.pre = List.of(2, 3);
        record1 = new Record();
        record1.courseId = 2;
        record1.grade = 10;
        record1.isMehman = false;
        record2 = new Record();
        record2.courseId = 3;
        record2.grade = 10;
        record2.isMehman = false;
        record3 = new Record();
        record3.courseId = 4;
        record3.grade = 9;
        record3.isMehman = false;
        assertTrue(Check.hasPassedPre(List.of(record1, record2, record3), course));

        // Test 4 - Not passed
        course = new Course();
        course.id = 1;
        course.pre = List.of(2, 3);
        record1 = new Record();
        record1.courseId = 2;
        record1.grade = 9;
        record1.isMehman = false;
        record2 = new Record();
        record2.courseId = 3;
        record2.grade = 10;
        record2.isMehman = false;
        record3 = new Record();
        record3.courseId = 4;
        record3.grade = 11;
        record3.isMehman = false;
        assertFalse(Check.hasPassedPre(List.of(record1, record2, record3), course));

        // Test 5 - Don't have the record 3
        course = new Course();
        course.id = 1;
        course.pre = List.of(2, 3);
        record1 = new Record();
        record1.courseId = 2;
        record1.grade = 10;
        record1.isMehman = false;
        assertFalse(Check.hasPassedPre(List.of(record1), course));

        // Test 6 - Mehman passed
        course = new Course();
        course.id = 1;
        course.pre = List.of(2, 3);
        record1 = new Record();
        record1.courseId = 2;
        record1.grade = 10;
        record1.isMehman = false;
        record2 = new Record();
        record2.courseId = 3;
        record2.grade = 12;
        record2.isMehman = true;
        assertTrue(Check.hasPassedPre(List.of(record1, record2), course));

        // Test 7 - Mehman not passed
        course = new Course();
        course.id = 1;
        course.pre = List.of(2, 3);
        record1 = new Record();
        record1.courseId = 2;
        record1.grade = 10;
        record1.isMehman = true;
        record2 = new Record();
        record2.courseId = 3;
        record2.grade = 12;
        record2.isMehman = true;
        assertFalse(Check.hasPassedPre(List.of(record1, record2), course));

        // Test 8 - float not passed
        course = new Course();
        course.id = 1;
        course.pre = List.of(2, 3);
        record1 = new Record();
        record1.courseId = 2;
        record1.grade = 9.99;
        record1.isMehman = false;
        record2 = new Record();
        record2.courseId = 3;
        record2.grade = 11.99;
        record2.isMehman = true;
        assertFalse(Check.hasPassedPre(List.of(record1, record2), course));

        // Test 9 - Invalid grade
        course = new Course();
        course.id = 1;
        course.pre = List.of(2, 3);
        record1 = new Record();
        record1.courseId = 2;
        record1.grade = 21;
        record1.isMehman = false;
        record2 = new Record();
        record2.courseId = 3;
        record2.grade = 21;
        record2.isMehman = true;
        Record finalRecord1 = record1;
        Record finalRecord2 = record2;
        Course finalCourse = course;
        assertThrows(IllegalArgumentException.class, () -> Check.hasPassedPre(List.of(finalRecord1, finalRecord2), finalCourse));

        // Test 10 - Not unique courseID in recordع
        course = new Course();
        course.id = 1;
        course.pre = List.of(2, 3);
        record1 = new Record();
        record1.courseId = 2;
        record1.grade = 10;
        record1.isMehman = false;
        record2 = new Record();
        record2.courseId = 3;
        record2.grade = 10;
        record2.isMehman = false;
        record3 = new Record();
        record3.courseId = 2;
        record3.grade = 10;
        record3.isMehman = false;
        assertFalse(Check.hasPassedPre(List.of(record1, record2, record3), course));
    }
}