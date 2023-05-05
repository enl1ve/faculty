package ua.com.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.faculty.entity.Roles;
import ua.com.faculty.entity.Student;
import ua.com.faculty.entity.User;
import ua.com.faculty.repository.RolesRepository;
import ua.com.faculty.repository.StudentRepository;
import ua.com.faculty.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserManagerService implements UserDetailsService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final RolesRepository roleRepository;

    @Autowired
    public UserManagerService(UserRepository userRepository, StudentRepository studentRepository, RolesRepository roleRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
    }


    public boolean getLogicByUser(String username) {

//        boolean logic = false;
//        if(!userRepository.findAllByUsername(username).isEmpty()) logic=true;
//        return logic;

        return (!userRepository.findAllByUsername(username).isEmpty()) ? true : false;
    }


    public User saveNewUserToDB(User user){

        user.setRoles(Collections.singleton(new Roles(1L, "ROLE_User")));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));


//        Users user1 = userRepository.save(user);
//        return user1;

        return userRepository.save(user);
    }


    public List<Student> getCustomerList() {
        return studentRepository.findAll();
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        User user1 = userRepository.findByUsername(username);

        System.out.println(user1);

        if(user1==null){
            throw new UsernameNotFoundException("User not found!!!");
        }

        return user1;
    }
}
