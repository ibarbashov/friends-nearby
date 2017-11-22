package io.dudes.friendsnearby;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/hello")
    public String greeting() {
        return "Hello world!";
    }

    @GetMapping("/version")
    @SneakyThrows
    public String version() {
        List<String> strings = Files.readAllLines(Paths.get("../.git_version_tag"));
        return strings.get(0);
    }
}