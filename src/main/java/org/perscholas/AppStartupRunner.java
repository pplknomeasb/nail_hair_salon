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



        employeeRepo.save(new Employee("Kobe", "Bryant", 1234567895L, "jhadsf@perscholas.com", "Admin", "gibberish"));
        employeeRepo.save(new Employee("Clinton", "Bigsby", 8563214587L, "jadh@perscholas.com", "Admin", "givverish"));
        employeeRepo.save(new Employee("Stella", "Bloomsburg", 5698234587L, "alfbert.einstein@perscholas.com", "Owner", "givverish"));
        employeeRepo.save(new Employee("Colton", "Tribiani", 1245879635L, "mbdaa@my.org", "User", "givverish"));
        employeeRepo.save(new Employee("Hunter", "Blogswall", 9658231478L, "redquiredemail@bob.net", "User", "givverish"));
        employeeRepo.save(new Employee("Tom", "Othy", 7852365485L, "secudrity@altcom.com", "User", "givverish"));
        employeeRepo.save(new Employee("Eric", "PlainUser", 2856974312L, "codntroller@vcs.net", "User", "givverish"));

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

        eventRepo.save(new Event("Braids", 4D,60D, 3D));
        eventRepo.save(new Event("Corn-Rows", 7D, 60D, 3D));
        eventRepo.save(new Event("Extensions",5D, 150D, 3D));
        eventRepo.save(new Event("Bejing", 5D, 60D, 2D));
        eventRepo.save(new Event("Wig Placement", 6D, 200D, 1D));
        eventRepo.save(new Event("High-top Fade", 4D, 20D, 0.5D));
        eventRepo.save(new Event("Locs", 5D, 150D, 8D));
        eventRepo.save(new Event("Women's Cut", 4D, 150D, 4D));
        eventRepo.save(new Event("Hair Dye",4D, 60D, 2D));
        eventRepo.save(new Event("Staight-cut", 7D, 20D, 0.5D));
        eventRepo.save(new Event("Mohawk", 5D, 120D, 1D));
        eventRepo.save(new Event("Edge-up", 6D, 20D, .25D));

    }
}
