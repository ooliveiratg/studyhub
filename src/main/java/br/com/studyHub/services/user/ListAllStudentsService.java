package br.com.studyHub.services.user;

import br.com.studyHub.database.model.UserEntity;
import br.com.studyHub.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListAllStudentsService {
    private final UserRepository userRepository;

    public List<UserEntity> excute() {
        List<UserEntity> students = userRepository.findAll();

        return students;
    }
}
