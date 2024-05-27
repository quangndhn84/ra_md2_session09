package ra.oop.th3.run;

import ra.oop.th3.entity.Categories;
import ra.oop.th3.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    public static Categories[] arrCategories = new Categories[100];
    public static int indexCatalog = 0;
    public static Product[] arrProducts = new Product[100];
    public static int indexProduct = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**********SHOP MENU***********");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ShopManagement.displayMenuCatalog(scanner);
                    break;
                case 2:
                    ShopManagement.displayProduct(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-3");
            }
        } while (true);
    }

    public static void displayMenuCatalog(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("*************CATEGORIES MENU************");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputListCategories(scanner);
                    break;
                case 2:
                    displayListCategories();
                    break;
                case 3:
                    updateCategories(scanner);
                    break;
                case 4:
                    deleteCatalog(scanner);
                    break;
                case 5:
                    updateCatalogStatus(scanner);
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (isExit);
    }

    public static void inputListCategories(Scanner scanner) {
        System.out.println("Nhập vào số danh mục cần nhập thông tin:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrCategories[indexCatalog] = new Categories();
            arrCategories[indexCatalog].inputData(scanner);
            indexCatalog++;
        }
    }

    public static void displayListCategories() {
        for (int i = 0; i < indexCatalog; i++) {
            arrCategories[i].displayData();
        }
    }

    public static void updateCategories(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần cập nhật thông tin:");
        int catalogIdUpdate = Integer.parseInt(scanner.nextLine());
        int indexUpdate = getIndexByCatalogId(catalogIdUpdate);
        if (indexUpdate >= 0) {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên danh mục");
                System.out.println("2. Cập nhật mô tả danh mục");
                System.out.println("3. Cập nhật trạng thái danh mục");
                System.out.println("4. Thoát");
                System.out.print("Lựa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên danh mục cần cập nhật:");
                        arrCategories[indexUpdate].setCatalogName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào mô tả danh mục cần cập nhật:");
                        arrCategories[indexUpdate].setDescriptions(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập vào trạng thái cần cập nhật:");
                        arrCategories[indexUpdate].setCatalogStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 4:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-4");

                }
            } while (isExit);
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static void updateCatalogStatus(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần cập nhật trạng thái:");
        int catalogId = Integer.parseInt(scanner.nextLine());
        int indexUpdate = getIndexByCatalogId(catalogId);
        if (indexUpdate >= 0) {
            arrCategories[indexUpdate].setCatalogStatus(!arrCategories[indexUpdate].isCatalogStatus());
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static int getIndexByCatalogId(int catalogId) {
        for (int i = 0; i < indexCatalog; i++) {
            if (arrCategories[i].getCatalogId() == catalogId) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteCatalog(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần xóa:");
        int catalogIdDelete = Integer.parseInt(scanner.nextLine());
        int indexDelete = getIndexByCatalogId(catalogIdDelete);
        if (indexDelete >= 0) {
            for (int i = indexDelete; i < indexCatalog - 1; i++) {
                arrCategories[i] = arrCategories[i + 1];
            }
            arrCategories[indexCatalog - 1] = null;
            indexCatalog--;
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static void displayProduct(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("**************PRODUCT MENU****************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm theo khoảng giá a-b");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    isExit = true;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (isExit);
    }
}
