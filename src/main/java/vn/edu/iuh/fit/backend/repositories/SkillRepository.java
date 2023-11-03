package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.edu.iuh.fit.backend.models.Skill;
@RepositoryRestResource
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
