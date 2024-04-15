package net.scholnick.gradle.checker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@Slf4j
@SpringBootApplication
public class Main {
        public static void main(String... args) {
            try {
                if (args == null || args.length == 0) {
                    System.err.println("Usage: java -jar gradle-checker.jar gradle-file");
                    System.exit(-1);
                }

                new SpringApplicationBuilder(Main.class).headless(false).run(args)
                        .getBean(Processor.class).process(args[0]);

                System.exit(0);
            }
            catch (Exception e) {
                log.error("Unable to run gradle-checker",e);
                System.exit(-1);
            }
        }
}
