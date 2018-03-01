package br.com.springboot.project.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResorce {

  @Autowired
  private UserDaoService service;

  @GetMapping("/users")
  public List<User> retriveAllUsers(){
     return service.findAll();
  }

  @GetMapping("/users/{id}")
  public Resource<User> retriveUser(@PathVariable int id) throws UserNotFoundException {
    User user = service.findOne(id);
    if (user == null) {
        throw new UserNotFoundException("id-" + id);
    }

    Resource<User> resource = new Resource<>(user);
    ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retriveAllUsers());
    resource.add(linkTo.withRel("all-users"));
    return resource;
  }

  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
     User result = service.save(user);
     URI location = ServletUriComponentsBuilder
       .fromCurrentRequest()
       .path("/{id}")
       .buildAndExpand(result.getId()).toUri();
     return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public User deleteUser(@PathVariable int id) throws UserNotFoundException {
    User user = service.deleteById(id);
    if(user == null){
      throw new UserNotFoundException("id-" + id);
    }
    return null;
  }

}
