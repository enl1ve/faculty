package ua.com.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.faculty.entity.User;
import ua.com.faculty.repository.UserRepository;

@Service
public class UsersService {
    private final UserRepository usersRepository;

    @Autowired
    public UsersService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean getLogicByUsernameAndPassword(String username, String pass) {
        boolean logic = false;

        if(!usersRepository.findAllByUsernameAndPassword(username, pass).isEmpty()) {
            logic = true;
        }

        return logic;
    }

    public User getUserByUsernameAndPassword (String username, String pass) {
        User users;
        users = (User) usersRepository.findByUsernameAndPassword(username, pass);

        return users;
    }
}
