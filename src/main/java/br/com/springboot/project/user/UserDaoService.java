package br.com.springboot.project.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/*
 * O Spring adotou algumas anotações que representam camadas em uma aplicação. 
 * Este conceito de ter anotações com uma semântica melhor definida é chamado de Stereotypes.
 * São elas: @Component, @Controller, @Service, @Repository,
 * 
 * */
@Component
public class UserDaoService {

  private static List<User> users = new ArrayList<User>();

  private static int count = 3;

  static {
    users.add(new User(1, "Adam", new Date()));
    users.add(new User(2, "Amanda", new Date()));
    users.add(new User(3, "Kaka", new Date()));
  }

  public List<User> findAll(){
    return users;
  }

  public User save(User user) {
    if(user.getId() == null) {
      user.setId(++count);
    }
    users.add(user);
    return user;
  }

  public User findOne(int id) {
    for(User user: users) {
      if(user.getId() == id) {
        return user;
      }
    }
    return null;
  }

}
