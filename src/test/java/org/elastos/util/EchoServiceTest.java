package org.elastos.util;

import org.elastos.service.EchoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EchoServiceTest {
    @Autowired
    EchoService echoService;

    @Test
    public void callTest() throws Exception {
        echoService.call("did", "key", "data");
    }

}