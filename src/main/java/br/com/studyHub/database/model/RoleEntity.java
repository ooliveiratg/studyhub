package br.com.studyHub.database.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class RoleEntity implements GrantedAuthority {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String nome;


    @Override
    public @Nullable String getAuthority() {
        return "";
    }


}
