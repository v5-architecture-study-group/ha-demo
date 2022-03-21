package foo.v5archstudygroup.samples.ha.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyEntity(
        Instant myTimestamp,
        String host,
        String message
) {
}
