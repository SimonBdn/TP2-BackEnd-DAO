package monprojet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import monprojet.entity.Country;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring 
//

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "SELECT SUM(City.population) as populations "
            + " FROM City "
            + " INNER JOIN Country ON City.country_id = Country.id "
            + " WHERE Country.ID = :idPays ",
        nativeQuery = true)
public int nbPopu(int idPays);

    @Query(value = " SELECT Country.name as nom, SUM(City.population) as popu "
            + " FROM City "
            + " INNER JOIN Country ON City.country_id = Country.id "
            + " GROUP BY nom ",
    nativeQuery = true)
    public List<CountryPopu> CountryPopuByName();
}
