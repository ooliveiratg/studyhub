package br.com.studyHub.dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String role;


}
