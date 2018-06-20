package com.huntech.web.common;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jht0701 on 2016/6/16.
 */
public class TestUtils {
    public static void main(String[] args) {
        // 测试学生
        ExportExcel<Student> ex = new ExportExcel<Student>();
        String[] headers = { "学号", "姓名", "年龄", "性别", "出生日期" };
        List<Student> dataset = new ArrayList<Student>();
        dataset.add(new Student(10000001, "张三", 20, true, new Date()));
        dataset.add(new Student(20000002, "李四", 24, false, new Date()));
        dataset.add(new Student(30000003, "王五", 22, true, new Date()));
        // 测试图书

        try {
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream("e://book.png"));
            byte[] buf = new byte[bis.available()];
            while ((bis.read(buf)) != -1) {
                //
            }


            OutputStream out = new FileOutputStream("E://a.xls");
            //OutputStream out2 = new FileOutputStream("E://b.xls");
            //ex.exportExcel(headers, dataset, out);
            ex.exportExcel("student", headers, dataset, out, "yyyy-MM-dd","xxx","        青海绿电电力运维技术有限公司","e://qhldlogo.png");
            out.close();
            JOptionPane.showMessageDialog(null, "导出成功!");
            System.out.println("excel导出成功！");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
class Student {
    private long id;
    private String name;
    private int age;
    private boolean sex;
    private Date birthday;

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(long id, String name, int age, boolean sex, Date birthday) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}