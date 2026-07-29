package br.com.studyHub.controllers;

import br.com.studyHub.dto.ApiResponseDTO;
import br.com.studyHub.dto.StudentsDTO;
import br.com.studyHub.services.user.CreateStudentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class CreateStudentsController {

    private final CreateStudentsService createStudentsService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDTO execute(@Valid @RequestBody StudentsDTO dto) {
        return createStudentsService.execute(dto);
    }
}
