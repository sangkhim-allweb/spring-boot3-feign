package com.sangkhim.spring_boot3_feign.controller;

import com.sangkhim.spring_boot3_feign.feign.TodoClient;
import com.sangkhim.spring_boot3_feign.model.dto.TodoDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {

  private final TodoClient todosClient;

  @GetMapping("/v1/todos")
  public ResponseEntity<List<TodoDTO>> getTodos() {
    List<TodoDTO> todos = todosClient.getTodos().getBody();
    return new ResponseEntity<>(todos, HttpStatus.OK);
  }

  @GetMapping("/v1/todos/{id}")
  public ResponseEntity<TodoDTO> getTodoById(@PathVariable("id") Long id) {
    TodoDTO todo = todosClient.getTodoById(id).getBody();
    return new ResponseEntity<>(todo, HttpStatus.OK);
  }
}
