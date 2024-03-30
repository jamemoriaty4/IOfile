package business.Design;

import business.entity.Catagory;

import java.util.List;

public interface IDesignCatagory {
    List<Catagory> findAll();// lay ra danh sach danh muc
    Catagory findById(int id);//tim kiem danh muc theo id
    void save(Catagory catagory);//them hoac cap nhat danh muc
    void deleteById(int id);//xoa theo id

}
