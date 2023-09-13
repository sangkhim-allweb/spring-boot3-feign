package com.sangkhim.spring_boot3_feign.model.dto;

import lombok.Data;

@Data
public class TodoDTO {

  private String userId;
  private String id;
  private String title;
  private String completed;
}
