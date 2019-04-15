package service;

import model.User;
import service.exception.UserException;

import java.util.Collection;

public interface UserService {

    public void addUser (User user);

    public Collection<User> getUsers ();

    public User getUser (String id);

    public User editUser (User user) throws UserException;

    public User deleteUser (String id);

    public boolean existUser (String id);
}
