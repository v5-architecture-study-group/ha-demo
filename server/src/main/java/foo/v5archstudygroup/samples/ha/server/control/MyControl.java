package foo.v5archstudygroup.samples.ha.server.control;

import foo.v5archstudygroup.samples.ha.server.entity.MyEntity;
import foo.v5archstudygroup.samples.ha.server.entity.MyEntityRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;

@Component
public class MyControl {

    private final MyEntityRepository myEntityRepository;

    public MyControl(MyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    @Transactional
    public MyEntity createAndReturnEntity(String message) {
        var timestamp = Instant.now();
        var host = getHost();
        return myEntityRepository.saveAndFlush(new MyEntity(timestamp, host, message));
    }

    private String getHost() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        }
    }
}
