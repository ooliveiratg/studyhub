package br.com.studyHub.controllers;

import br.com.studyHub.dto.AuthResponseDTO;
import br.com.studyHub.dto.AuthSudentsDTO;
import br.com.studyHub.services.user.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthStudentsController {
    private final AuthService authStudentService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AuthResponseDTO execute(@Validated @RequestBody AuthSudentsDTO dto) {
        return authStudentService.execute(dto);

    }
}
