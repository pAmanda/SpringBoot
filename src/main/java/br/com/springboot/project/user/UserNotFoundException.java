package br.com.springboot.project.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

  private static final long serialVersionUID = 1L;

  public UserNotFoundException() {
    super();
  }
  
  public UserNotFoundException(String message) {
    super(message);
  }

}