package br.com.studyHub.services.user;

import br.com.studyHub.database.model.UserEntity;
import br.com.studyHub.database.repository.UserRepository;
import br.com.studyHub.dto.ApiResponseDTO;
import br.com.studyHub.dto.StudentsDTO;
import br.com.studyHub.exception.BadRequestException;
import br.com.studyHub.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateStudentService {
    private final UserRepository userRepository;

    public ApiResponseDTO execute(String id, StudentsDTO dto) {
        UserEntity existStudent = userRepository
                .findById(UUID.fromString(id))
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        if (dto.password() == null || dto.name() == null || dto.email() == null) {
            throw new BadRequestException("Para esta atualização todos os campos devem ser preenchidos");
        }

        existStudent.setName(dto.name());
        existStudent.setEmail(dto.email());
        existStudent.setPassword(dto.password());

        userRepository.save(existStudent);

        return new ApiResponseDTO("Dados atualizados com sucesso", existStudent);
    }
}
