package ra.oop.th3.entity;

import ra.oop.th3.run.ShopManagement;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner) {
        this.catalogId = inputCatalogId();
        this.catalogName = inputCatalogName(scanner);
        this.descriptions = inputDescription(scanner);
        this.catalogStatus = inputCatalogStaus(scanner);
    }

    public int inputCatalogId() {
        if (ShopManagement.indexCatalog == 0) {
            return 1;
        } else {
            int max = ShopManagement.arrCategories[0].getCatalogId();
            for (int i = 1; i < ShopManagement.indexCatalog; i++) {
                if (max < ShopManagement.arrCategories[i].getCatalogId()) {
                    max = ShopManagement.arrCategories[i].getCatalogId();
                }
            }
            return max + 1;
        }
    }

    public String inputCatalogName(Scanner scanner) {
        System.out.println("Nhập vào tên danh mục:");
        do {
            String catalogName = scanner.nextLine();
            if (catalogName.length() <= 50) {
                boolean isExist = false;
                for (int i = 0; i < ShopManagement.indexCatalog; i++) {
                    if (ShopManagement.arrCategories[i].getCatalogName().equals(catalogName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
                } else {
                    return catalogName;
                }
            } else {
                System.err.println("Tên danh mục có độ dài tối đa 50 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputDescription(Scanner scanner) {
        System.out.println("Nhập vào mô tả danh mục:");
        return scanner.nextLine();
    }

    public boolean inputCatalogStaus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái danh mục:");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận giá trị true | false, vui lòng nhập lại");
            }
        } while (true);
    }

    public void displayData() {
        System.out.printf("Mã danh mục: %d - Tên danh mục: %s - Mô tả: %s - Trạng thái: %s\n",
                this.catalogId, this.catalogName, this.descriptions, this.catalogStatus ? "Hoạt động" : "Không hoạt động");
    }
}
