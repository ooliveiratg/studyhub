package br.com.studyHub.provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


//provider = component
@Service
public class JwtProvider {

    @Value("${security.token.key}")
    private String secretKey;

    public DecodedJWT validate(String header) {
        header = header.replace("Bearer ", "");
        try {
            Algorithm secret = Algorithm.HMAC256(secretKey);
            var token = JWT.require(secret).build().verify(header);
            return token;

        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
