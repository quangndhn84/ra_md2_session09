package ra.session09.collection;

import java.util.HashMap;
import java.util.Map;

public class Map_Demo {
    public static void main(String[] args) {
        //Map: chứa dữ liệu kiểu Key-Value: Key là duy nhất, không trùng lặp
        Map<Integer, String> mapStudentNames = new HashMap<>();
        //put(Key,Value): thêm 1 phần tử vào danh sách map
        mapStudentNames.put(1, "Nguyễn Văn A");
        mapStudentNames.put(2, "Nguyễn Văn B");
        mapStudentNames.put(3, "Nguyễn Văn C");
        //get(Key): Lấy value phần tử theo key
        System.out.println("Tên sinh viên có key là 2 là: " + mapStudentNames.get(2));
        //remove(key): xóa phần tử theo key
        mapStudentNames.remove(1);
        System.out.println(mapStudentNames);
    }
}
