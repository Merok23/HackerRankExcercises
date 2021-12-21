package gradingstudents;

import java.util.ArrayList;
import java.util.List;

public class GradingStudents {
    public GradingStudents(){
        return;
    }

    public int grade(int number) {
        int newNumber = number;
        int nextMultiple = number;
        int addedNumbers = 0;
        
        while (nextMultiple % 5 != 0 && newNumber >= 38){
            nextMultiple++;
            addedNumbers++;
        }

        if (addedNumbers < 3) newNumber = nextMultiple;
        return newNumber;
    }

    public int[] gradeStudents(int[] grades) {
        int[] newGrades = grades;

        for (int i = 0; i < grades.length; i++){
            newGrades[i] = this.grade(newGrades[i]);
        }

        return newGrades;
    }

    public List<Integer> gradeStudentsList(List<Integer> grades) {
        List<Integer> newGrades = new ArrayList<Integer>();
        for(int i = 0; i < grades.size(); i++){
            newGrades.add(i, this.grade(grades.get(i)));
        }
        return newGrades;

    }
}
