package org.perscholas;

import lombok.extern.java.Log;
import org.perscholas.daos.IClientRepo;
import org.perscholas.daos.IEmployeeRepo;
import org.perscholas.daos.IEventRepo;
import org.perscholas.models.Employee;
import org.perscholas.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Component
@Log
@Transactional

public class AppStartupRunner implements CommandLineRunner {

    IEmployeeRepo employeeRepo;
    IClientRepo clientRepo;
    IEventRepo eventRepo;

    @Autowired
    public AppStartupRunner(IEmployeeRepo employeeRepo, IClientRepo clientRepo, IEventRepo eventRepo){
        this.employeeRepo = employeeRepo;
        this.clientRepo = clientRepo;
        this.eventRepo = eventRepo;
    }



    @Override
    public void run(String... args) throws Exception {

        employeeRepo.save(new Employee("Jafar", "Alhaboubi", 1234567895L, "jh@perscholas.com", "Admin"));
        employeeRepo.save(new Employee("Jafar", "Alhaboubi", 1234567895L, "jh@perscholas.com", "Admin"));
        employeeRepo.save(new Employee("Jafar", "Alhaboubi", 1234567895L, "albert.einstein@perscholas.com", "Owner"));
        employeeRepo.save(new Employee("Jafar", "Alhaboubi", 1234567895L, "mb@my.org", "User"));
        employeeRepo.save(new Employee("Jafar", "Alhaboubi", 1234567895L, "requiredemail@bob.net", "User"));
        employeeRepo.save(new Employee("Jafar", "Alhaboubi", 1234567895L, "security@altcom.com", "User"));
        employeeRepo.save(new Employee("Jafar", "Alhaboubi", 1234567895L, "controller@vcs.net", "User"));

        //eventRepo.save(new Event("Braids", 45, 54.44D, 28D));



    }
}
