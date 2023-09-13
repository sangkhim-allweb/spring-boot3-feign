package com.sangkhim.spring_boot3_feign.feign;

import com.sangkhim.spring_boot3_feign.model.dto.TodoDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "todos", url = "https://jsonplaceholder.typicode.com")
public interface TodosClient {

  @GetMapping("/todos")
  public ResponseEntity<List<TodoDTO>> getTodos();
}
