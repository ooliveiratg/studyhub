package br.com.studyHub.database.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

//pegar valores
@Getter
//setar(atualizar valores)
@Setter
//construtor vaio o0u seja não precisa passar um valor quando esta instanciando tipo User user =new User ("thiago", 15, "menezeshtfgds@gmail.com")
@NoArgsConstructor
//construtor com argumentos voce pode fazer User user =new User ("thiago", 15, "menezeshtfgds@gmail.com"), mas não user.setNome("teste")
@AllArgsConstructor
//para ficar assim user.builder().name("teste").build()
@Builder
@Entity(name = "students")
public class StudentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "usuário deve digitar nome/senha")
    private String name;

    @NotBlank
    @Email(message = "email deve ser válido")
    private String email;

    @NotBlank(message = "usuário deve digitar nome/senha")
    @Min(value = 5, message = "senha deve ter mais que 5 caracteres")
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
