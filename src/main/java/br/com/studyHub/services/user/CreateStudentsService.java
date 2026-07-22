package br.com.studyHub.services.user;

import br.com.studyHub.database.model.StudentsEntity;
import br.com.studyHub.database.repository.StudentsRepository;
import br.com.studyHub.dto.ApiResponse;
import br.com.studyHub.dto.StudentsDto;
import br.com.studyHub.exception.BadRequestExeception;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStudentsService {
    private final StudentsRepository studentsRepository;

    public ApiResponse execute(StudentsDto dto) {
        StudentsEntity students = studentsRepository.findByEmail(dto.email()).orElse(null);

        if (students != null) {
            throw new BadRequestExeception("Usuário já existe");
        }
        studentsRepository.save(
                StudentsEntity.builder()
                        .name(dto.name())
                        .email(dto.email())
                        .password(dto.password())
                        .build());

        return new ApiResponse<>("aluno criado com sucesso", dto);
    }
}
