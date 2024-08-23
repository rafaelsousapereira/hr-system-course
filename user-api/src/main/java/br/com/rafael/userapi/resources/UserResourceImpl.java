package br.com.rafael.userapi.resources;

import br.com.rafael.userapi.domain.User;
import br.com.rafael.userapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users")
public class UserResourceImpl implements UserResource {

    private final UserService service;

    @Override
    public ResponseEntity<User> findById(Long id) {
        var result = service.findById(id);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        var result = service.findAll();
        return ResponseEntity.ok(result);
    }
}
