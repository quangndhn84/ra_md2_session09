package ra.session09.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCollection {
    public static void main(String[] args) {
        /*
         * 1. Sắp xếp với Comparable Interface:
         *   - B1: Lớp dữ liệu sắp xếp phải kế thừa Comparable
         *   - B2: Ghi đè phương thức compareTo để cài đặt sắp xếp
         *   - B3: Sử dụng phương thức sort của Collection để sắp xếp        *
         * */
        List<Student> listStudent = new ArrayList<>();
        Student student1 = new Student("SV001", "Nguyễn Văn A", 20);
        Student student2 = new Student("SV002", "Nguyễn Văn B", 18);
        Student student3 = new Student("SV003", "Nguyễn Văn C", 22);
        Student student4 = new Student("SV004", "Nguyễn Văn D", 25);
        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);
        listStudent.add(student4);
        System.out.println("DANH SÁCH SINH VIÊN TRƯỚC KHI SẮP XẾP:");
        for (Student student : listStudent) {
            System.out.println(student);
        }
        //Sắp xếp các sinh viên theo tuổi tăng dần sử dụng Comparable
        System.out.println("SẮP XẾP SINH VIÊN THEO TUỔI TĂNG DẦN VỚI COMPARABLE:");
        Collections.sort(listStudent);
        for (Student student : listStudent) {
            System.out.println(student);
        }
        /*
         * 2. SẮP XẾP VỚI COMPARATOR Interface
         *   - 1. Sử dụng phương thức sort của Collections để sắp xếp
         *   - 2. Khởi tạo đối tươnng Comparator
         *   - 3. Cài đặt sắp xếp với phương thức compare của đói tượng Comparator
         *
         * */
        //Sắp xếp sinh viên theo tuổi giảm dần
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                return t1.getAge() - student.getAge();
            }
        });
        System.out.println("SẮP XẾP THEO TUỔI GIẢM DẦN VỚI COMPARATOR:");
        for (Student student : listStudent) {
            System.out.println(student);
        }
        //Sắp xếp sinh viên theo tên giảm dần
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student2.getStudentName().compareTo(student1.getStudentName());
            }
        });
        System.out.println("SẮP XẾP THEO TÊN GIẢM DẦN VỚI COMPARATOR:");
        for (Student student : listStudent) {
            System.out.println(student);
        }

    }
}
