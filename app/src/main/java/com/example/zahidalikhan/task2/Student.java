package com.example.zahidalikhan.task2;

public class Student {
    private String studentId;
    private String studentName;
    private String studentClass;

    public Student(String studentId, String studentName, String studentClass) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public Student(){

    }

}
