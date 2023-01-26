package ru.kata.spring.boot_security.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.dao.UserRepository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.HashSet;
import java.util.Set;

@Component
public class TestUsers implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    // @Autowired
    public TestUsers(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void run(String... arg) throws Exception {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Set<Role> adminRoles = new HashSet<>();
        Set<Role> userRoles = new HashSet<>();
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);
        adminRoles.add(roleAdmin);
        userRoles.add(roleUser);

        User userAdmin = new User("A","$2y$10$08fime4hWZ5TMO.JkPEmXuIwyBchRDIbR/5QqtOnDtXE1s1LV52De", "A", 10, "a@gmil.com",  adminRoles);
        User userUser = new User("B", "$2y$10$GuP0CFLp71MpXFxHluKAy.t391.yfdkrTdSp6XRjvv2tnzGsTeH8O", "B", 10, "b@gmil.com", userRoles);
        System.out.println(userAdmin);
        userRepository.save(userAdmin);
        System.out.println(userUser);
        userRepository.save(userUser);

    }

}
