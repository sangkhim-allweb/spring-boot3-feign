package com.sangkhim.spring_boot3_feign.exception;

import com.sangkhim.spring_boot3_feign.exception.base.ServiceException;

/** trigger for unauthorized exception */
public class UnauthorizedException extends ServiceException {

  public UnauthorizedException() {
    super();
  }

  public UnauthorizedException(String message) {
    super(message);
  }

  public UnauthorizedException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
