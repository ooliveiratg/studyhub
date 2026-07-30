package br.com.studyHub.services.user;

import br.com.studyHub.database.model.RoleEntity;
import br.com.studyHub.database.model.UserEntity;
import br.com.studyHub.database.repository.RoleRepository;
import br.com.studyHub.database.repository.UserRepository;
import br.com.studyHub.dto.ApiResponseDTO;
import br.com.studyHub.dto.StudentsDTO;
import br.com.studyHub.dto.UsersResponseDTO;
import br.com.studyHub.enums.RolesEnum;
import br.com.studyHub.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAdminService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    private final RoleRepository rolesRepository;

    public ApiResponseDTO execute(StudentsDTO dto) {
        UserEntity students = userRepository.findByEmail(dto.email()).orElse(null);

        if (students != null) {
            throw new BadRequestException("Usuário já existe");
        }

        String passwordEncoder = encoder.encode(dto.password());

        RoleEntity roles = rolesRepository
                .findByName(RolesEnum.ROLE_ADMIN.name())
                .orElseGet(() -> rolesRepository.save(RoleEntity.builder()
                        .name(RolesEnum.ROLE_ADMIN.name())
                        .build()));


        UserEntity user = userRepository.save(
                UserEntity.builder()
                        .name(dto.name())
                        .email(dto.email())
                        .password(passwordEncoder)
                        .role(roles)
                        .build());

        UsersResponseDTO response = UsersResponseDTO.builder()
                .id(user.getId())
                .name(dto.name())
                .email(dto.email())
                .role(roles.getName())
                .build();

        return new ApiResponseDTO<>("aluno criado com sucesso", response);
    }
}
