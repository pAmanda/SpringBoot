package br.com.springboot.project.user;

import java.util.Date;


public class ExceptionResponse {

  private Date timesTamp;
  private String message;
  private String details;

  public ExceptionResponse(Date timesTamp, String message, String details) {
    this.timesTamp = timesTamp;
    this.message = message;
    this.details = details;
  }

  public Date getTimesTamp() {
    return timesTamp;
  }

  public String getMessage() {
    return message;
  }

  public String getDetails() {
    return details;
  }

}
