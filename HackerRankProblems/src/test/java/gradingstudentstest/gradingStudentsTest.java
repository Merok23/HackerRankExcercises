package gradingstudentstest;
import gradingstudents.GradingStudents;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class gradingStudentsTest extends TestCase{

    public void test00GradingStudentCreatedAndItsReferenceIsNotNull(){
        GradingStudents grade = new GradingStudents();

        Assert.assertNotNull(grade);
    }

    public void test01YouGetAGradeRounded(){
        GradingStudents grader = new GradingStudents();
        int grade = 98;
        int newGrade = grader.grade(grade);


        assertEquals(100,newGrade);
    }

    public void test02LessThan38IsNotRounded(){
        GradingStudents grader = new GradingStudents();
        int grade = 27;
        int newGrade = grader.grade(grade);

        assertEquals(27, newGrade);
    }

    public void test03TheNumber38IsRounded(){
        GradingStudents grader = new GradingStudents();
        int grade = 38;
        int newGrade = grader.grade(grade);

        assertEquals(40, newGrade);
    }

    public void test04IfTheyHaveMoreThan3DifferenceIsNotRounded(){
        GradingStudents grader = new GradingStudents();
        int grade = 57;
        int newGrade = grader.grade(grade);

        assertEquals(57, newGrade);

    }

    public void test05YouCanGradeAnArray(){
        GradingStudents grader = new GradingStudents();
        int[] grades = {67, 53, 38, 27, 15, 99};
        int[] expectedGrades = {67, 55, 40, 27, 15, 100};

        int[] newGrades = grader.gradeStudents(grades);

        for (int i = 0; i < grades.length; i++){
            assertEquals(expectedGrades[i], newGrades[i]);
        }
    }

    public void test06StressTest(){
        GradingStudents grader = new GradingStudents();
        int[] grades = new int[100000];

        for (int i = 0; i < 100000; i++){
            grades[i] = i;
        }
        int[] newGrades = grader.gradeStudents(grades);

        assertNotNull(newGrades);
        assertEquals(100000, newGrades.length);
    }

    public void test07CompatibilityTest(){
        GradingStudents grader = new GradingStudents();
        List<Integer> grades = new ArrayList<Integer>();
        List<Integer> expectedGrades = new ArrayList<Integer>();
        grades.add(98);
        expectedGrades.add(100);

        List<Integer> newGrades = grader.gradeStudentsList(grades);

        assertEquals(expectedGrades, newGrades);
    }

    public void test08MultipleElementsInTheList(){
        GradingStudents grader = new GradingStudents();
        List<Integer> grades = new ArrayList<Integer>();
        List<Integer> expectedGrades = new ArrayList<Integer>();
        grades.add(98);
        grades.add(15);
        grades.add(38);
        grades.add(78);
        grades.add(73);

        expectedGrades.add(100);
        expectedGrades.add(15);
        expectedGrades.add(40);
        expectedGrades.add(80);
        expectedGrades.add(75);



        List<Integer> newGrades = grader.gradeStudentsList(grades);

        assertEquals(expectedGrades, newGrades);
    }
}
