package br.com.studyHub.controllers;

import br.com.studyHub.database.model.StudentsEntity;
import br.com.studyHub.services.user.ListAllStudentsService;
import br.com.studyHub.services.user.ListOneStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class ListStudentsController {

    private final ListAllStudentsService listAllStudentsService;
    private final ListOneStudentService listOneStudentService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentsEntity> listAllStudents() {
        return listAllStudentsService.excute();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentsEntity listOneStudent(@PathVariable String id) {
        return listOneStudentService.execute(id);
    }

}
