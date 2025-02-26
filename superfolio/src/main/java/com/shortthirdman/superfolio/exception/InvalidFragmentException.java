package com.shortthirdman.superfolio.exception;

public class InvalidFragmentException extends RuntimeException {

  public InvalidFragmentException(String message) {
    super(message);
  }

  public InvalidFragmentException(String message, Throwable cause) {
    super(message, cause);
  }
}
