package br.com.studyHub.services.user;

import br.com.studyHub.database.model.UserEntity;
import br.com.studyHub.database.repository.UserRepository;
import br.com.studyHub.dto.SimpleMessageResponseDTO;
import br.com.studyHub.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteStudentsService {
    private final UserRepository userRepository;

    public SimpleMessageResponseDTO execute(String id) {
        UserEntity existsStudenty = userRepository
                .findById(UUID.fromString(id))
                .orElseThrow(() -> new NotFoundException("Estudante não encontrado"));

        userRepository.delete(existsStudenty);
        return new SimpleMessageResponseDTO("Estudante deletado com sucesso");
    }
}
