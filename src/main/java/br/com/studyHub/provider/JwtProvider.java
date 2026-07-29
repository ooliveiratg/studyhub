package br.com.studyHub.provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


//provider = component
@Service
public class JwtProvider {

    @Value("${security.token.key}")
    private String secretKey;

    public String validate(String token) {
        token = token.replace("Bearer ", "");
        try {
            Algorithm secret = Algorithm.HMAC256(secretKey);
            var subject = JWT.require(secret).build().verify(token).getSubject();
            return subject;

        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return "";
        }
    }
}
