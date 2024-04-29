package net.scholnick.gradle.checker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
@Component
public class Processor {
    public void process(String gradleFilePath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(gradleFilePath)).stream()
                .filter(l -> l.contains("implementation") || l.contains("testImplementation"))
                .map(String::trim)
                .toList()
            ;
            System.out.println(lines);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
