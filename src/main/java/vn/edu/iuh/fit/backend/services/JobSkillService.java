package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.repositories.JobRepository;
import vn.edu.iuh.fit.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.backend.repositories.SkillRepository;
@Service
public class JobSkillService {
    private final JobSkillRepository jobSkillRepository;
    private final JobRepository jobRepository;
    private final SkillRepository skillRepository;

    @Autowired
    public JobSkillService(JobSkillRepository jobSkillRepository, JobRepository jobRepository, SkillRepository skillRepository) {
        this.jobSkillRepository = jobSkillRepository;
        this.jobRepository = jobRepository;
        this.skillRepository = skillRepository;
    }
}
