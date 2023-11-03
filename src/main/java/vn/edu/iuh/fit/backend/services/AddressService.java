package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.repositories.AddressRepository;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
}
