package service.implementation;

import model.User;
import service.UserService;
import service.exception.UserException;

import java.util.Collection;
import java.util.HashMap;

public class UserServiceMapImpl implements UserService {

    private HashMap<String, User> usersMap;

    private static UserServiceMapImpl instance = null;

    private UserServiceMapImpl() {
        this.usersMap = new HashMap<String, User>();
    }

    private UserServiceMapImpl(HashMap<String, User> usersMap) {
        this.usersMap = usersMap;
    }

    public static UserServiceMapImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceMapImpl();
        }
        return instance;
    }

    @Override
    public void addUser(User user) {
        usersMap.put(String.valueOf(user.getId()), user);
    }

    @Override
    public Collection<User> getUsers() {
        return usersMap.values();
    }

    @Override
    public User getUser(String id) {
        return usersMap.get(id);
    }

    @Override
    public User editUser(User user) throws UserException {
        try {
            if (user.getId() == 0) {
                throw new UserException("Id cant be 0(zero) or null.");
            }
            if (this.existUser(String.valueOf(user.getId()))) {
                User studentToEdit = usersMap.get(user.getId());
                if (user.getLastName() != null) {
                    studentToEdit.setLastName(user.getLastName());
                }
                if (user.getFirstName() != null) {
                    studentToEdit.setFirstName(user.getFirstName());
                }
                return studentToEdit;
            }
            return null;
        } catch (Exception e){
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public User deleteUser(String id) {
        return usersMap.remove(id);
    }

    @Override
    public boolean existUser(String id) {
        return usersMap.containsKey(id);
    }
}
