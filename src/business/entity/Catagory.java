package business.entity;

import util.InputMethods;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Catagory implements Serializable {
//    field
    private int id;
    private  String name;
    private boolean stutus;

//    constructor

    public Catagory() {
    }

    public Catagory(int id, String name, boolean stutus) {
        this.id = id;
        this.name = name;
        this.stutus = stutus;
    }
    //  getter and setter


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

    public boolean isStutus() {
        return stutus;
    }

    public void setStutus(boolean stutus) {
        this.stutus = stutus;
    }

//    function active
    public void inputData(List<Catagory> catagories){
        this.id = newId(catagories);
        this.name= inputName(catagories);
        this.stutus = inputStatus();

    }
    //id tu tang
    private int newId(List<Catagory> catagories){
        int idMax=0;
        for (Catagory e: catagories){
            if(e.getId()>idMax){
                idMax= getId();
            }
        }
        return idMax+1;
    }
    //nhap ten
    private String inputName(List<Catagory> catagories){
        while (true){
            System.out.println("nhap ten cho danh muc");
            String name = InputMethods.getString();
            if(!existByName(name,catagories)){
                return name;
            }
            System.err.println("tên đã tồn tại");
        }
    }
    //kiem tra ten da ton tai hahy chua
    private boolean existByName(String name ,List<Catagory> catagories){
        for (Catagory e: catagories){
            if(Objects.equals(e.getName(), name)){
                return true;
            }
        }
        return false;
    }
//    nhap vao trang thai
    public boolean inputStatus(){
        System.out.println("nhap vào trạng thái");
        System.out.println("1.Hoạt đông");
        System.out.println("2. Khong hoat động");
        System.out.println("nhap lua chon");
        byte choice = InputMethods.getByte();
        return choice ==1;
    }
}
