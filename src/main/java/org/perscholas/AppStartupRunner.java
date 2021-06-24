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

        employeeRepo.save(new Employee("Kobe", "Bryant", 1234567895L, "jh@perscholas.com", "Admin"));
        employeeRepo.save(new Employee("Tom", "Brady", 8563214587L, "jh@perscholas.com3", "Admin"));
        employeeRepo.save(new Employee("Nick", "Foles", 5698234587L, "albert.einstein@perscholas.com", "Owner"));
        employeeRepo.save(new Employee("Mark", "Henry", 1245879635L, "mb@my.org", "User"));
        employeeRepo.save(new Employee("Bernie", "Mac", 9658231478L, "requiredemail@bob.net", "User"));
        employeeRepo.save(new Employee("Wayne", "Gretsky", 7852365485L, "security@altcom.com", "User"));
        employeeRepo.save(new Employee("Williams", "Sisters", 2856974312L, "controller@vcs.net", "User"));

        clientRepo.save(new Client("2022-06-15", "Brennan", "Thompson", "thompson.brennan@gmail.com", 5413584464L));
        clientRepo.save(new Client("2021-08-20", "Thurgood", "Marshall", "twototwo@hotmail.com", 2365417569L));
        clientRepo.save(new Client("2021-08-19", "Willie", "Nelson", "tellechar@att.com", 8745551236L));
        clientRepo.save(new Client("2021-07-21", "Hulk", "Hogan", "caolipark@everywhere.com", 3458879654L));
        clientRepo.save(new Client("2022-06-15", "Butter", "Bean", "thefriendliest@friends.com", 3789254691L));
        clientRepo.save(new Client("2022-06-15", "Muhammed", "Ali", "abelle@parts.net", 7965412547L));
        clientRepo.save(new Client("2022-06-15", "Tiger", "Woods", "whatwhat@what.net", 7996523147L));

        appointmentRepo.save(new Appointment("thompson.brennan@gmail.com", "2022-06-15", "Edge-up", 3L, 12354L));
        appointmentRepo.save(new Appointment("twototwo@hotmail.com", "2021-08-20", "High-top Fade", 4L, 25468L));
        appointmentRepo.save(new Appointment("tellechar@att.com", "2021-08-19", "Bejing", 5L, 59864L));
        appointmentRepo.save(new Appointment("caolipark@everywhere.com", "2021-07-21", "Locs", 6L, 54287L));
        appointmentRepo.save(new Appointment("tthefriendliest@friends.com", "2022-06-15", "Bejing", 7L, 56321L));
        appointmentRepo.save(new Appointment("abelle@parts.net", "2022-06-15", "Wig Placement", 6L, 74125L));
        appointmentRepo.save(new Appointment("whatwhat@what.net", "2022-26-15", "Women's Cut", 4L, 56982L));



    }
}
