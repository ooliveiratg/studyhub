package br.com.studyHub.services.user;

import br.com.studyHub.database.model.StudentsEntity;
import br.com.studyHub.database.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListAllStudentsService {
    private final StudentsRepository studentsRepository;

    public List<StudentsEntity> excute() {
        List<StudentsEntity> students = studentsRepository.findAll();

        System.out.println(students);
        return students;
    }
}
