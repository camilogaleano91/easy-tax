package ch.zhaw.easyTax.user.service;

import java.util.List;


public interface BaseUserService<T> {

    public List<T> getAllUsers();

    public T getUserById(Long id);

    public T addUser(T t);

    public T saveUser(T t);
}
