import entity.EntityController;
import repos.CityRepo;
import repos.ContinentRepo;
import repos.CountryRepo;

public class Main {
    public static void main(String[] args) {
        ContinentRepo cr = new ContinentRepo();
        CountryRepo cor = new CountryRepo();
        CityRepo ctr = new CityRepo();
        //ctr.create("Iasi", 1, false, 123.4, 354.5);
        //ctr.findById(1);
        //ctr.findByName("Iasi");
        //cr.create("Europe");
        //cr.findById(1);
        //cr.findByName("Europe");
        //cor.create("Romania", "RO", 2);
        //cor.findById(1);
        //cor.findByName("Romania");
        EntityController.getInstance().getEntityManagerFactory().close();
    }
}
