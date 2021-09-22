package tech.rpish.po;

import java.util.List;

public class Class {
    private int id;
    private String name;
    private List<Students> studentList;

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Students> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Students> studentList) {
        this.studentList = studentList;
    }
}
