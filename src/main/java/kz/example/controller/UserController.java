package kz.example.controller;

import kz.example.entity.PersonalData;
import kz.example.entity.User;
import kz.example.repository.PersonalDataRepository;
import kz.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;



    @GetMapping("")
    public List<User> getALLUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userRepository.findById(id).get();
    }

    @PostMapping("")
    public User createUser(@RequestBody User user){
        return userRepository.saveAndFlush(user);
    }



    @PatchMapping("/{id}")
    public User updateUserAge(@PathVariable Long id,
                              @RequestParam String password) {
        User user = userRepository.findById(id).get();
        user.setPassword(password);

        return userRepository.saveAndFlush(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        userRepository.deleteById(id);
    }



}
