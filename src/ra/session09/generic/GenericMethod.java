package ra.session09.generic;

import java.util.List;

public class GenericMethod {
    //<E>: kiểu dữ liệu generic khai báo trong phương thức
    public <E> void printArray(E[] arr) {
        for (E element : arr) {
            System.out.println(element);
        }
    }

    public void printList(List<?> list){

    }
}
