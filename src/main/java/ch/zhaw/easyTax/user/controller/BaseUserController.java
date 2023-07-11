package ch.zhaw.easyTax.user.controller;

import org.springframework.http.ResponseEntity;

public interface BaseUserController<T, D> {

    public ResponseEntity<?> getAllUsers();

    public ResponseEntity<?> getUserById(long id);

    public ResponseEntity<String> addUser(D d);
}

