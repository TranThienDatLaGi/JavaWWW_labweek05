package vn.edu.iuh.fit.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.services.CandidateService;

@RestController("/api/vi")
public class CandidateResources {
    @Autowired
    private CandidateService services;
}
