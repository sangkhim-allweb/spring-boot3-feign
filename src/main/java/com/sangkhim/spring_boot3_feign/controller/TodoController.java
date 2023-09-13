package com.sangkhim.spring_boot3_feign.controller;

import com.sangkhim.spring_boot3_feign.feign.TodosClient;
import com.sangkhim.spring_boot3_feign.model.dto.TodoDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {

  private final TodosClient todosClient;

  @GetMapping("/v1/todos")
  public ResponseEntity<List<TodoDTO>> getTodos() {
    List<TodoDTO> todos = todosClient.getTodos().getBody();
    return new ResponseEntity<>(todos, HttpStatus.OK);
  }
}
