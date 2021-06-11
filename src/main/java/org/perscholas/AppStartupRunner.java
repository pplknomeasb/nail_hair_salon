package org.perscholas;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Log
@Transactional

public class AppStartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }
}
