package com.sangkhim.spring_boot3_feign.exception;

import com.sangkhim.spring_boot3_feign.exception.base.ServiceException;

/** trigger for forbidden exception */
public class ForbiddenException extends ServiceException {

  public ForbiddenException() {
    super();
  }

  public ForbiddenException(String message) {
    super(message);
  }

  public ForbiddenException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
