package be.com.springweb;


import io.quarkus.logging.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/demo")
public class DemoController {
    Logger logger = org.apache.logging.log4j.LogManager.getLogger(this.getClass().getName());

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {

        Log.info("Spring hello path called");
        logger.info("log4j Spring hello path called {}", UUID.randomUUID().toString());

        return ResponseEntity.ok("Hello Spring ");
    }

    @PostMapping("/hello-post")
    public ResponseEntity<?> hello(@RequestBody DemoRequest request) {
        Log.infof("Spring hello post path called request: %s", request);

        return ResponseEntity.ok(DemoResponse.builder().result(request.getText()).build());
    }


}
