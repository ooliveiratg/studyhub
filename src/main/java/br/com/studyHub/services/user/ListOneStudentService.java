package br.com.studyHub.services.user;

import br.com.studyHub.database.model.StudentsEntity;
import br.com.studyHub.database.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListOneStudentService {
    private final StudentsRepository studentsRepository;

    public StudentsEntity execute(UUID id) {
        studentsRepository.findById(id).orElseThrow(throw new )

    }
}
