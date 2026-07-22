package br.com.studyHub.controllers;

import br.com.studyHub.dto.SimpleMessageResponseDto;
import br.com.studyHub.services.user.DeleteStudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/delete")
@RequiredArgsConstructor
public class DeleteStudentsController {

    private final DeleteStudentsService deleteStudentsService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SimpleMessageResponseDto deleteStudent(@PathVariable String id){
        return deleteStudentsService.execute(id);
    }

}
