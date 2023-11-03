package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Address;
@RepositoryRestResource
public interface AddressRepository extends JpaRepository<Address, Long> {
}
