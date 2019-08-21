package com.example.test_demo.student;

public class student {

    private int student_id;
    private String student_name;
    private int student_age;
    static public int soluong;

    //Hàm tạo không đối số
    public student()
    {
        student_id = 0;
        student_name = "";
        student_age = 0;
    }
    public student(int id, String name,int age)
    {
        student_id=id;
        student_name=name;
        student_age = age;
    }
    public int getStudent_id()
    {
        return student_id;
    }

    public int getStudent_age() {
        return student_age;
    }

    public void setStudent_age(int student_age) {
        this.student_age = student_age;
    }

    public String getStudent_name()
    {
        return student_name;
    }
    public void setStudent_id(int id)
    {
        this.student_id=id;
    }
    public void setStudent_name(String name)
    {
        this.student_name= name;
    }
    //Trả về thông tin sinh viên
    public String toString()
    {
        return "Mssv : " +this.student_id+" - Tên : "+this.student_name+" - Tuổi :"+ this.student_age;
    }
}
