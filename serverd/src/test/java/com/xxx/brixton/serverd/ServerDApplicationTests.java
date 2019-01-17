package com.xxx.brixton.serverd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ServerDApplication.class)
@WebAppConfiguration
public class ServerDApplicationTests {

    @Test
    public void test1() {
        System.out.println("it is test !");
    }
}
