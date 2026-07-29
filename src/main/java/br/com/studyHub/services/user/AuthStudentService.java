package br.com.studyHub.services.user;

import br.com.studyHub.database.model.StudentsEntity;
import br.com.studyHub.database.repository.StudentsRepository;
import br.com.studyHub.dto.AuthResponseDTO;
import br.com.studyHub.dto.AuthSudentsDTO;
import br.com.studyHub.exception.BadRequestException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthStudentService {
    @Value("${security.token.key}")
    private String secretkey;

    private final StudentsRepository studentsRepository;
    private final PasswordEncoder encoder;

    public AuthResponseDTO execute(AuthSudentsDTO dto) {
        StudentsEntity user = studentsRepository.findByEmail(dto.email()).orElseThrow(() -> new BadRequestException("Email ou senha incorretos"));

        Algorithm algorithm = Algorithm.HMAC256(secretkey);

        Boolean verifyPassword = encoder.matches(dto.password(), user.getPassword());

        if (verifyPassword == false) {
            throw new BadRequestException("Email ou senha incorretos");
        }

        System.out.println(user.getId().toString());

        String authUser = JWT
                .create()
                .withIssuer("studyhub")
                .withExpiresAt(Instant.now().plus(Duration.ofMinutes(15)))
                .withSubject(user.getId().toString())
                .sign(algorithm);

        AuthResponseDTO responseDTO = AuthResponseDTO.builder()
                .access_token(authUser)
                .build();

        return responseDTO;
    }
}
