package presentation;

import business.Design.IDesignCatagory;
import business.Imple.CatagoryImplement;
import business.entity.Catagory;
import util.InputMethods;

import java.util.List;

public class CatagoryManagement {
    private static IDesignCatagory designCatagory = new CatagoryImplement();

    public static void main(String[] args) {


        while (true) {
            System.out.println(categoryMenu());
            System.out.println("Hay nhap lua chon ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    showAllCatagories();
                    break;
                case 2:
                    addNewCatagories();
                    break;
                case 3:
                    updateCatagories();
                    break;
                case 4:deleteCatagory();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("nhap lai lua chon cua ban");
                    break;
            }
            if (choice == 5) {
                System.out.println("ket thuc chuong trinh");
                break;
            }
        }
    }

    public static String categoryMenu() {
        return "===============MENU=================\n" +
                "1. Hiển thị tất cả category\n" +
                "2. Thêm mới category\n" +
                "3. Sửa thông tin category\n" +
                "4. Xóa thông tin category\n" +
                "5. Dừng chương trình\n";
    }

    public static void showAllCatagories() {
        List<Catagory> list = designCatagory.findAll();
        if (list.isEmpty()) {
            System.err.println("Danh muc rong!");
        } else {
            System.out.printf("| %-3s | %-15s | %-15s |\n", "ID", "Name", "Status");
            for (Catagory cat : list) {
                System.out.printf("| %-3s | %-15s | %-15s |\n", cat.getId(), cat.getName(), cat.isStutus() ? "Hoạt động" : "Không hoạt động");
            }
        }
    }

    public static void addNewCatagories() {
        System.out.println("nhap so luong muon them mơi");
        int count = InputMethods.getInteger();
        for (int i = 0; i < count; i++) {
            System.out.println("nhap thong tin cho danh muc thu " + (i + 1));
            Catagory newCatagory = new Catagory();
            newCatagory.inputData(designCatagory.findAll());
            designCatagory.save(newCatagory);
            System.out.println("da them thanh cong!");
        }
    }
    public static void updateCatagories(){

        System.out.println("nhap vao id can sửa");
        byte choice = InputMethods.getByte();

        if(designCatagory.findById(choice) == null){
            System.err.println("khong tim thay id phu hop");
        }else{
            System.out.println("sua thong tin");
                Catagory updateCatagory = new Catagory();
                updateCatagory.inputData(designCatagory.findAll());
                designCatagory.save(updateCatagory);
            System.out.println("sua thanh cong");

        }

    }

    public static void deleteCatagory(){
        System.out.println("nhap vao id can xoa");
        byte choice = InputMethods.getByte();
        if(designCatagory.findById(choice)==null){
            System.err.println("khong tim thay id can xoa");
        }else{
            designCatagory.deleteById(choice);
            System.out.println("xoa thanh cong");
        }
    }
}
