package br.com.studyHub.controllers;

import br.com.studyHub.dto.ApiResponseDTO;
import br.com.studyHub.dto.StudentsDTO;
import br.com.studyHub.services.user.UpdateStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/update")
@RequiredArgsConstructor
public class UpdateStudentController {

    private final UpdateStudentService updateStudentService;

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDTO updateStudent(@PathVariable String id, @RequestBody StudentsDTO dto) {
        return updateStudentService.execute(id, dto);
    }
}
