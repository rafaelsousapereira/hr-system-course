package br.com.rafael.userapi.services;

import br.com.rafael.userapi.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();
}
