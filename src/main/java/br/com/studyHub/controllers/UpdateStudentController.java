package br.com.studyHub.controllers;

import br.com.studyHub.dto.ApiResponse;
import br.com.studyHub.dto.StudentsDto;
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
    public ApiResponse updateStudent(@PathVariable String id, @RequestBody StudentsDto dto) {
        return updateStudentService.execute(id, dto);
    }
}
