package com.sangkhim.spring_boot3_feign.controller;

import com.sangkhim.spring_boot3_feign.feign.TodoClient;
import com.sangkhim.spring_boot3_feign.model.dto.TodoDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

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

  @GetMapping("/v1/webclient/todos")
  public ResponseEntity<List<TodoDTO>> webClientGetTodos() {
    WebClient client =
        WebClient.builder()
            .baseUrl("https://jsonplaceholder.typicode.com/todos")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
    List<TodoDTO> todos = client.get().retrieve().bodyToFlux(TodoDTO.class).collectList().block();
    return new ResponseEntity<>(todos, HttpStatus.OK);
  }

  @GetMapping("/v1/webclient/todos/{id}")
  public ResponseEntity<TodoDTO> webClientGetTodoById(@PathVariable("id") Long id) {
    WebClient client =
        WebClient.builder()
            .baseUrl("https://jsonplaceholder.typicode.com/todos/" + id)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
    TodoDTO todo = client.get().retrieve().bodyToMono(TodoDTO.class).block();
    return new ResponseEntity<>(todo, HttpStatus.OK);
  }
}
