package br.com.studyHub.services.user;

import br.com.studyHub.database.model.StudentsEntity;
import br.com.studyHub.database.repository.StudentsRepository;
import br.com.studyHub.dto.ApiResponseDTO;
import br.com.studyHub.dto.StudentsDTO;
import br.com.studyHub.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStudentsService {
    private final StudentsRepository studentsRepository;
    private final PasswordEncoder encoder;


    public ApiResponseDTO execute(StudentsDTO dto) {
        StudentsEntity students = studentsRepository.findByEmail(dto.email()).orElse(null);

        if (students != null) {
            throw new BadRequestException("Usuário já existe");
        }

        String passwordEncoder = encoder.encode(dto.password());

        studentsRepository.save(
                StudentsEntity.builder()
                        .name(dto.name())
                        .email(dto.email())
                        .password(passwordEncoder)
                        .build());

        return new ApiResponseDTO<>("aluno criado com sucesso", dto);
    }
}
