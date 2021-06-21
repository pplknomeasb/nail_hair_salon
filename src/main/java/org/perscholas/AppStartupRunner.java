package org.perscholas;

import lombok.extern.java.Log;
import org.perscholas.daos.IAppointmentRepo;
import org.perscholas.daos.IClientRepo;
import org.perscholas.daos.IEmployeeRepo;
import org.perscholas.daos.IEventRepo;
import org.perscholas.models.Appointment;
import org.perscholas.models.Client;
import org.perscholas.models.Employee;
import java.util.Date;
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
    IAppointmentRepo appointmentRepo;

    @Autowired
    public AppStartupRunner(IEmployeeRepo employeeRepo, IClientRepo clientRepo, IEventRepo eventRepo, IAppointmentRepo appointmentRepo){
        this.employeeRepo = employeeRepo;
        this.clientRepo = clientRepo;
        this.eventRepo = eventRepo;
        this.appointmentRepo = appointmentRepo;
    }



    @Override
    public void run(String... args) throws Exception {

        employeeRepo.save(new Employee("Jafar", "Alhaboubi", 1234567895L, "jh@perscholas.com", "Admin"));
        employeeRepo.save(new Employee("Veronica", "Vodka", 8563214587L, "jh@perscholas.com3", "Admin"));
        employeeRepo.save(new Employee("Trevor", "Bloomsburg", 5698234587L, "albert.einstein@perscholas.com", "Owner"));
        employeeRepo.save(new Employee("Leah", "Tribiani", 1245879635L, "mb@my.org", "User"));
        employeeRepo.save(new Employee("Hunter", "Blogswall", 9658231478L, "requiredemail@bob.net", "User"));
        employeeRepo.save(new Employee("Tom", "Othy", 7852365485L, "security@altcom.com", "User"));
        employeeRepo.save(new Employee("Erik", "PlainUser", 2856974312L, "controller@vcs.net", "User"));

        clientRepo.save(new Client("2022-06-15", "Brennan", "Thompson", "thompson.brennan@gmail.com", 5413584464L));
        clientRepo.save(new Client("2021-08-20", "Evan", "Thompson", "ethompson@gmail.com", 2365417569L));
        clientRepo.save(new Client("2021-08-19", "Chelsea", "Page", "chelsea.page@rhd.org", 8745551236L));
        clientRepo.save(new Client("2021-07-21", "Dayvon", "Colston", "thompson.brennan@gmail.com", 3458879654L));
        clientRepo.save(new Client("2022-06-15", "Tracie", "Thompson", "tracie.thompson@rhd.org", 3789254691L));
        clientRepo.save(new Client("2022-06-15", "Audri", "Belle", "abelle@parts.net", 7965412547L));
        clientRepo.save(new Client("2022-06-15", "Tyrone", "Greenwood", "thompson.brennan@gmail.com", 7996523147L));

        appointmentRepo.save(new Appointment("thompson.brennan@gmail.com", "2022-06-15", 1L, 3L, 12354L));



    }
}
