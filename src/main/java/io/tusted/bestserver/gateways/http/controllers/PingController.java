package io.tusted.bestserver.gateways.http;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ping")
@RequiredArgsConstructor
public class PingController {

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void pingServer(@PathVariable String ipAddress) throws IOException {

  }



}
