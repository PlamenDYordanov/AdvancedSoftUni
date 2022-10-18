package Advanced.Exam_April_2021_10.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public String registerStudent(Student student) {

        boolean isExist = false;
        String output = "";
        for (Student curStudent : this.students) {
            if (curStudent.getFirstName().equals(student.getFirstName()) && curStudent.getLastName().equals(student.getLastName())) {
                output = "Student is already in the Advanced.Exam_April_2021_10.university";
                isExist = true;
                break;
            }
        }
        if (capacity <= this.students.size() && !isExist) {
            output = "No seats in the Advanced.Exam_April_2021_10.university";
        } else if (capacity > this.students.size() && !isExist) {
            this.students.add(student);
            output = String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
        return output;
    }

    public String dismissStudent(Student student) {
        boolean isExist = false;
        String output = "";
        int index = 0;
        for (Student curStudent : this.students) {
            if (curStudent.getFirstName().equals(student.getFirstName()) && curStudent.getLastName().equals(student.getLastName())) {
                this.students.remove(index);
                isExist = true;
                output = String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
                break;
            }
            index++;
        }
        if (!isExist) {
            output = "Student not found";
        }
        return output;
    }

    public Student getStudent(String firstName, String lastName) {
        Student student = null;
        for (Student curStud : this.students) {
            if (curStud.getFirstName().equals(firstName) && curStud.getLastName().equals(lastName)) {
                student = curStud;
            }
        }
        return student;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Student student : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", student.getFirstName(), student.getLastName(), student.getBestSubject()));
            sb.append("\n");
        }
        return sb.toString();
    }
}
