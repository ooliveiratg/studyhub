package br.com.studyHub.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
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
@Table(name = "users")
@Entity()
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "usuário deve digitar nome/senha")
    @Length(min = 10, max = 100, message = "a senha deve ter 10 á 100 caracteres")
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private RoleEntity role;


}
