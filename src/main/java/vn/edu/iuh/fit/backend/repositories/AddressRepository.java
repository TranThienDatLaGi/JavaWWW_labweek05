package vn.edu.iuh.fit.backend.repositories;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.entities.Address;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

//    public static Optional<Address> findAddressByInfor(String street, String city, String number, String zipcode, CountryCode countryCode){
//        Optional
//    }
//}
}