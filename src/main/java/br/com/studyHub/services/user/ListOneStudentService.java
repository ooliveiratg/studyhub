package br.com.studyHub.services.user;

import br.com.studyHub.database.model.StudentsEntity;
import br.com.studyHub.database.repository.StudentsRepository;
import br.com.studyHub.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListOneStudentService {
    private final StudentsRepository studentsRepository;

    public StudentsEntity execute(String id) {
        StudentsEntity students = studentsRepository
                .findById(UUID.fromString(id))
                .orElseThrow(() -> new NotFoundException("Estudante não encontrado"));
        return students;

    }
}
