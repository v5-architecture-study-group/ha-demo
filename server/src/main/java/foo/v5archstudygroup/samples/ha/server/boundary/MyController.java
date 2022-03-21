package foo.v5archstudygroup.samples.ha.server.boundary;

import foo.v5archstudygroup.samples.ha.server.control.MyControl;
import foo.v5archstudygroup.samples.ha.server.entity.MyEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private final MyControl myControl;

    public MyController(MyControl myControl) {
        this.myControl = myControl;
    }

    @PostMapping("/store")
    public MyEntity storeMessage(@RequestBody String message) {
        return myControl.createAndReturnEntity(message);
    }
}
