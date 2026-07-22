package br.com.studyHub.services.user;

import br.com.studyHub.database.model.StudentsEntity;
import br.com.studyHub.database.repository.StudentsRepository;
import br.com.studyHub.dto.ApiResponse;
import br.com.studyHub.dto.StudentsDto;
import br.com.studyHub.exception.BadRequestException;
import br.com.studyHub.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateStudentService {
    private final StudentsRepository studentsRepository;

    public ApiResponse execute(String id, StudentsDto dto) {
        StudentsEntity existStudent = studentsRepository
                .findById(UUID.fromString(id))
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        if (dto.password() == null || dto.name() == null || dto.email() == null) {
            throw new BadRequestException("Para esta atualização todos os campos devem ser preenchidos");
        }

        existStudent.setName(dto.name());
        existStudent.setEmail(dto.email());
        existStudent.setPassword(dto.password());

        studentsRepository.save(existStudent);

        return new ApiResponse("Dados atualizados com sucesso", existStudent);
    }
}
