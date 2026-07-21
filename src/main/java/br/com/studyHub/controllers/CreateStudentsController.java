package br.com.studyHub.controllers;

import br.com.studyHub.dto.ApiResponse;
import br.com.studyHub.dto.StudentsDto;
import br.com.studyHub.services.user.CreateStudentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/create")
@RequiredArgsConstructor
@Validated
public class CreateStudentsController {

    private final CreateStudentsService createStudentsService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse execute(@Valid @RequestBody StudentsDto dto) {
        return createStudentsService.execute(dto);
    }
}
