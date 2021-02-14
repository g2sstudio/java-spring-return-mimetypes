package com.fastcodetricks.javaspringapi.entrypoint;

import com.fastcodetricks.javaspringapi.entrypoint.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserEntrypoint {

    private Map<Long, User> users = Map.of(
        1L, new User(1L, "Peter"),
            2L, new User(2L, "John")
    );

    @GetMapping(produces = {"application/json", "application/xml"})
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    @GetMapping(value = "/{userId}", produces = {"application/json", "application/xml"})
    public User getUserAccept(@PathVariable Long userId) {
        return users.get(userId);
    }

    @GetMapping(value= "/{userId}/xml", produces = "application/xml")
    public User getUserXml(@PathVariable Long userId) {
        return users.get(userId);
    }

    @GetMapping(value = "/{userId}/json", produces = "application/json")
    public User getUserJson(@PathVariable Long userId) {
        return users.get(userId);
    }

    @GetMapping(value= "/{userId}/text")
    public String getUserText(@PathVariable Long userId) {
        return users.get(userId).toString();
    }

    @GetMapping(value= "/{userId}/bytes")
    public byte[] getUserBytes(@PathVariable Long userId) {
        return users.get(userId).toString().getBytes();
    }

}
