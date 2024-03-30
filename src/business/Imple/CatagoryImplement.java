package business.Imple;

import business.Design.IDesignCatagory;
import business.entity.Catagory;
import util.IOFile;

import java.util.List;

public class CatagoryImplement implements IDesignCatagory {
    private static List<Catagory> catagories;
    public static final String linkData = "D:\\Java\\Ss10Pracitce\\src\\data\\catagory.txt";
    static {
        catagories = IOFile.readFromFile(linkData);
    }
    @Override
    public List<Catagory> findAll() {
        return catagories;
    }

    @Override
    public Catagory findById(int id) {
        for (Catagory e: catagories){
            if(e.getId()==id){
                return e;
            }
        }
        return null;
    }

    @Override
    public void save(Catagory catagory) {
        if(findById(catagory.getId())==null){
            catagories.add(catagory);
        }else{
            catagories.set(catagories.indexOf(findById(catagory.getId())),catagory);
        }
        IOFile.writeToFile(linkData, catagories);
    }

    @Override
    public void deleteById(int id) {
        if(findById(id)!=null){
            catagories.remove(findById(id));
            IOFile.writeToFile(linkData,catagories);
        }
    }
}
