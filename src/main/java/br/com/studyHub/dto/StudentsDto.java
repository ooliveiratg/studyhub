package br.com.studyHub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record StudentsDto(
        @NotBlank(message = "usuário deve digitar nome/senha")
        String name,

        @NotBlank
        @Email(message = "email deve ser válido")
        String email,

        @NotBlank(message = "usuário deve digitar nome/senha")
        @Length(min = 10, max = 100, message = "a senha deve ter 10 á 100 caracteres")
        String password

) {
}
