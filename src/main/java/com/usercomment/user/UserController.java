package com.usercomment.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private UserService userService;

    @GetMapping("/users/api/v2/comments ")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/api/v2/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }
    

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/users/api/v2/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/users/api/v2/find/text/{text}")
    public List<User> findByText(@PathVariable String text) {
        return userService.findByText(text);
    }

    @GetMapping("/users/api/v2/find/date/{date}")
   public List<User> findBydateofcomment(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return userService.findBydateofcomment(date);
    }
}
