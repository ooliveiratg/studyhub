package br.com.studyHub.services.user;

import br.com.studyHub.database.model.UserEntity;
import br.com.studyHub.database.repository.UserRepository;
import br.com.studyHub.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListOneStudentService {
    private final UserRepository userRepository;

    public UserEntity execute(String id) {
        UserEntity students = userRepository
                .findById(UUID.fromString(id))
                .orElseThrow(() -> new NotFoundException("Estudante não encontrado"));
        return students;

    }
}
