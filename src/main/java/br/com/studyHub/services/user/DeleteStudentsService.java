package br.com.studyHub.services.user;

import br.com.studyHub.database.model.StudentsEntity;
import br.com.studyHub.database.repository.StudentsRepository;
import br.com.studyHub.dto.SimpleMessageResponseDTO;
import br.com.studyHub.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteStudentsService {
    private final StudentsRepository studentsRepository;

    public SimpleMessageResponseDTO execute(String id) {
        StudentsEntity existsStudenty = studentsRepository
                .findById(UUID.fromString(id))
                .orElseThrow(() -> new NotFoundException("Estudante não encontrado"));

        studentsRepository.delete(existsStudenty);
        return new SimpleMessageResponseDTO("Estudante deletado com sucesso");
    }
}
