package br.com.studyHub.controllers;

import br.com.studyHub.database.model.UserEntity;
import br.com.studyHub.services.user.ListAllStudentsService;
import br.com.studyHub.services.user.ListOneStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class ListStudentsController {
    private final ListAllStudentsService listAllStudentsService;
    private final ListOneStudentService listOneStudentService;
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> listAllStudents() {
        return listAllStudentsService.excute();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity listOneStudent(@PathVariable String id) {
        return listOneStudentService.execute(id);
    }

}
