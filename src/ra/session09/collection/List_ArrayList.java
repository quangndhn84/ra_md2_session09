package ra.session09.collection;

import java.util.ArrayList;
import java.util.List;

public class List_ArrayList {
    public static void main(String[] args) {
        //Khởi tạo danh sách sinh viên từ List Interface và ArrayList Class
        List<Student> listStudent = new ArrayList<>();
        Student student1 = new Student("SV001", "Nguyễn Văn A", 20);
        Student student2 = new Student("SV002", "Nguyễn Văn B", 18);
        Student student3 = new Student("SV003", "Nguyễn Văn C", 22);
        Student student4 = new Student("SV004", "Nguyễn Văn D", 25);
        //add(E): Thêm 1 phần tử vào cuối danh sách
        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);
        //size(): trả ra số phần tử của danh sách
        System.out.println("Số sinh viên trong danh sách: " + listStudent.size());
        //isEmpty(): Kiểm tra danh sách có chứa phần tử nào chưa
        System.out.println("Kiểm tra trong danh sách đã chứa sinh viên chưa: " + listStudent.isEmpty());
        //contains(obj): kiểm tra đối tượng obj có trong danh sách hay không
        System.out.println("Kiểm tra sinh viên 2 có trong danh sách không: " + listStudent.contains(student2));
        //toArray(): Chuyển từ kiểu Collection sang Array
        for (int i = 0; i < listStudent.toArray().length; i++) {

        }
        //remove(obj): Xóa 1 phần tử trong danh sách
        listStudent.remove(student1);
        //containsALl(Collection<?>): Kiểm tra danh sách có trong danh sách hay không
        List<Student> list1 = new ArrayList<>();
        list1.add(student3);
        System.out.println("Kiểm tra danh sách 1 có trong danh sách không: " + listStudent.containsAll(list1));
        //addAll(Collection<?>): Thêm 1 danh sách vào danh sách
        List<Student> list2 = new ArrayList<>();
        list2.add(student1);
        list2.add(student4);
        listStudent.addAll(list2);
        //removeAll(Collection<?>): xóa 1 danh sách trong danh sách
        listStudent.removeAll(list2);
        //clear(): xóa toàn bộ các phần tử trong danh sách:
//        listStudent.clear();
        //get(int index): lấy phần tử theo chỉ số
        System.out.println("Sinh viên ở chỉ số 1 trong danh sách: "+listStudent.get(1));
        //set(int index, Object obj): Đè đối tượng obj vào chỉ số index
        listStudent.set(0,student1);//SV001 - SV003
        //add(int index, Object obj): Chèn đối tượng obj vào chỉ số index
        listStudent.add(1,student2);//SV001 - SV002 - SV003
        //remove(int index): xóa phần tử theo chỉ số
        listStudent.remove(2);
        //indexOf(Object obj): trả ra chỉ số của obj trong danh sách
        System.out.println("Chỉ số sinh viên 1 trong danh sách: "+listStudent.indexOf(student1));
        //lastIndexOf(Object obj): trả ra chỉ số phần tử obj cuối cùng trong danh sách
        listStudent.add(student1);
        System.out.println("Chỉ số sinh viên 1 cuối cùng trong danh sách: "+listStudent.lastIndexOf(student1));


        System.out.println("THÔNG TIN DANH SÁCH SINH VIÊN:");
        for (Student student : listStudent) {
            System.out.println(student);
        }
    }
}
