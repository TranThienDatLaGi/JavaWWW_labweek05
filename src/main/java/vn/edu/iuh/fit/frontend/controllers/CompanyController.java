package vn.edu.iuh.fit.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.entities.Address;
import vn.edu.iuh.fit.backend.entities.Candidate;
import vn.edu.iuh.fit.backend.entities.Company;
import vn.edu.iuh.fit.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.backend.services.CandidateServices;
import vn.edu.iuh.fit.backend.services.CompanyServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private  CompanyRepository companyRepository;
    @Autowired
    private CompanyServices companyServices;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateServices candidateServices;

    @GetMapping
    public String manage(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int sizeInteger = size.orElse(10);
        Page<Company> companies = companyServices.findAll(page.orElse(1), sizeInteger, "id", "asc");
        long count = companyRepository.count();
        int numberPages = (int) Math.ceil((double) count / sizeInteger);

        model.addAttribute("companies", companies);
        model.addAttribute("pages", IntStream.rangeClosed(1, numberPages).boxed().collect(Collectors.toList()));
        return "/companies/companyManage";
    }

    @GetMapping("/add")
    public String addController(Model model) {
        Company company = new Company();
        Address address = new Address();
        company.setAddress(address);
        model.addAttribute("company", company);
        model.addAttribute("address", address);
        model.addAttribute("countryCodes", CountryCode.values());
        return "/companies/add";
    }
    @PostMapping("/add")
    public String addController(@ModelAttribute("company") Company company, @ModelAttribute("address") Address address, Model model) {
        try {
            Address addressSave = addressRepository.save(address);
            company.setAddress(addressSave);
            companyRepository.save(company);
            return "redirect:/companies";
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("company", company);
        model.addAttribute("address", address);
        model.addAttribute("countryCodes", CountryCode.values());

        return "/companies/add";
    }
    @PostMapping ("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        companyRepository.deleteById(id);
        return "redirect:/companies";
    }
}
