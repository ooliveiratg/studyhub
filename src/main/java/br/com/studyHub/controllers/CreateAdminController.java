package br.com.studyHub.controllers;

import br.com.studyHub.dto.ApiResponseDTO;
import br.com.studyHub.dto.StudentsDTO;
import br.com.studyHub.services.user.CreateAdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/admin")
@RequiredArgsConstructor
@Validated
public class CreateAdminController {

    private final CreateAdminService createAdminServiceService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDTO execute(@Valid @RequestBody StudentsDTO dto) {
        return createAdminServiceService.execute(dto);
    }
}
