package br.com.fiap.contatos.security;

import br.com.fiap.contatos.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${mySecretWord}")
    private String secretWord;

    public String gerarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretWord);
            String token = JWT
                    .create()
                    .withIssuer("contatos")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(gerarDataExpiracao())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException erro){
            throw new RuntimeException("Não foi possível gerar o Token");
        }
    }

    public String validarToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretWord);
            return JWT.require(algorithm)
                    .withIssuer("contatos")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException erro){
            return "";
        }
    }

    public Instant gerarDataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
