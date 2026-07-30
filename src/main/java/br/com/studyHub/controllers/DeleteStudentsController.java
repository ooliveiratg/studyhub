package br.com.studyHub.controllers;

import br.com.studyHub.dto.SimpleMessageResponseDTO;
import br.com.studyHub.services.user.DeleteStudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class DeleteStudentsController {

    private final DeleteStudentsService deleteStudentsService;

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SimpleMessageResponseDTO deleteStudent(@PathVariable String id) {
        return deleteStudentsService.execute(id);
    }

}
