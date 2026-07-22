package br.com.studyHub.controllers;

import br.com.studyHub.database.model.StudentsEntity;
import br.com.studyHub.services.user.ListAllStudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user/list")
@RequiredArgsConstructor
public class ListStudentsController {

    private final ListAllStudentsService listAllStudentsService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentsEntity> listAllStudents() {
        return listAllStudentsService.excute();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentsEntity listOneStudent(@PathVariable UUID id){
        return
    }

}
