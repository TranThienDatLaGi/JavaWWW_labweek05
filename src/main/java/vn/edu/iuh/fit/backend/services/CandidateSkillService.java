package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.backend.repositories.SkillRepository;

@Service
public class CandidateSkillService {
    CandidateSkillRepository candidateSkillRepository;
    CandidateRepository candidateRepository;
    SkillRepository skillRepository;

    @Autowired
    public CandidateSkillService(CandidateSkillRepository candidateSkillRepository, CandidateRepository candidateRepository, SkillRepository skillRepository) {
        this.candidateSkillRepository = candidateSkillRepository;
        this.candidateRepository = candidateRepository;
        this.skillRepository = skillRepository;
    }
}
