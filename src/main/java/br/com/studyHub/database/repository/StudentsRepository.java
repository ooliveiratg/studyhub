package br.com.studyHub.database.repository;

import br.com.studyHub.database.model.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentsRepository extends JpaRepository<StudentsEntity, UUID> {
    Optional<StudentsEntity> findByEmail(String email);
}
