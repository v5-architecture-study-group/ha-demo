package foo.v5archstudygroup.samples.ha.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
public class HaClientApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HaClientApp.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .rootUri("http://10.37.132.40:8080/api")
                .setConnectTimeout(Duration.ofSeconds(2))
                .setReadTimeout(Duration.ofSeconds(10))
                .build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            while (true) {
                var message = "This is a message from my client sent at " + Instant.now();
                try {
                    var response = restTemplate.postForObject("/store", message, MyEntity.class);
                    System.out.println(response);
                } catch (Exception ex) {
                    System.err.println("ERROR: " + ex.getMessage());
                }
                Thread.sleep(1000);
            }
        };
    }
}
