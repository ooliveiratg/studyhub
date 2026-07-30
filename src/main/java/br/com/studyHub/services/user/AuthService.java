package br.com.studyHub.services.user;

import br.com.studyHub.database.model.UserEntity;
import br.com.studyHub.database.repository.UserRepository;
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
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Value("${security.token.key}")
    private String secretkey;

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public AuthResponseDTO execute(AuthSudentsDTO dto) {
        UserEntity user = userRepository.findByEmail(dto.email()).orElseThrow(() -> new BadRequestException("Email ou senha incorretos"));

        Algorithm algorithm = Algorithm.HMAC256(secretkey);

        Boolean verifyPassword = encoder.matches(dto.password(), user.getPassword());

        if (verifyPassword == false) {
            throw new BadRequestException("Email ou senha incorretos");
        }

        String authUser = JWT
                .create()
                .withIssuer("studyhub")
                .withExpiresAt(Instant.now().plus(Duration.ofMinutes(15)))
                .withSubject(user.getId().toString())
                .withClaim("roles", Arrays.asList(user.getRole().getName()))
                .sign(algorithm);

        AuthResponseDTO responseDTO = AuthResponseDTO.builder()
                .access_token(authUser)
                .build();

        return responseDTO;
    }
}
