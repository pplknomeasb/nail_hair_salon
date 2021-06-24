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

        employeeRepo.save(new Employee("Kobe", "Bryant", 1234567895L, "jh@perscholas.com", "Admin", "gibberish"));
        employeeRepo.save(new Employee("Clinton", "Bigsby", 8563214587L, "jh@perscholas.com3", "Admin", "givverish"));
        employeeRepo.save(new Employee("Stella", "Bloomsburg", 5698234587L, "albert.einstein@perscholas.com", "Owner", "givverish"));
        employeeRepo.save(new Employee("Colton", "Tribiani", 1245879635L, "mb@my.org", "User", "givverish"));
        employeeRepo.save(new Employee("Hunter", "Blogswall", 9658231478L, "requiredemail@bob.net", "User", "givverish"));
        employeeRepo.save(new Employee("Tom", "Othy", 7852365485L, "security@altcom.com", "User", "givverish"));
        employeeRepo.save(new Employee("Eric", "PlainUser", 2856974312L, "controller@vcs.net", "User", "givverish"));

        clientRepo.save(new Client("2022-06-15", "Brennan", "Thompson", "thompson.brennan@gmail.com", 5413584464L));
        clientRepo.save(new Client("2021-08-20", "Target", "Walmart", "ethompson@gmail.com", 2365417569L));
        clientRepo.save(new Client("2021-08-19", "Tom", "Page", "chelsea.page@rhd.org", 8745551236L));
        clientRepo.save(new Client("2021-07-21", "Dayvon", "Colston", "thompson.brennan@gmail.com", 3458879654L));
        clientRepo.save(new Client("2022-06-15", "Tracie", "Thompson", "tracie.thompson@rhd.org", 3789254691L));
        clientRepo.save(new Client("2022-06-15", "Audri", "Belle", "abelle@parts.net", 7965412547L));
        clientRepo.save(new Client("2022-06-15", "Tyrone", "Greenwood", "thompson.brennan@gmail.com", 7996523147L));

        appointmentRepo.save(new Appointment("thompson.brennan@gmail.com", "2022-06-15", "Edge-up", 3L, 12354L));
        appointmentRepo.save(new Appointment("ethompson@gmail.com", "2021-08-20", "High-top Fade", 4L, 25468L));
        appointmentRepo.save(new Appointment("chelsea.page@rhd.org", "2021-08-19", "Bejing", 5L, 59864L));
        appointmentRepo.save(new Appointment("colston.dayvon@verizon.net", "2021-07-21", "Locs", 6L, 54287L));
        appointmentRepo.save(new Appointment("tracie.thompson@rhd.org", "2022-06-15", "Bejing", 7L, 56321L));
        appointmentRepo.save(new Appointment("abelle@parts.net", "2022-06-15", "Wig Placement", 6L, 74125L));
        appointmentRepo.save(new Appointment("brennan.thompson@@gmail.com", "2022-26-15", "Women's Cut", 4L, 56982L));

        eventRepo.save(new Event("Braids", 4L,60D, 3D));
        eventRepo.save(new Event("Corn-Rows", 7L, 60D, 3D));
        eventRepo.save(new Event("Extensions",5L, 150D, 3D));
        eventRepo.save(new Event("Bejing", 5L, 60D, 2D));
        eventRepo.save(new Event("Wig Placement", 6L, 200D, 1D));
        eventRepo.save(new Event("High-top Fade", 4L, 20D, 0.5D));
        eventRepo.save(new Event("Locs", 5L, 150D, 8D));
        eventRepo.save(new Event("Women's Cut", 4L, 150D, 4D));
        eventRepo.save(new Event("Hair Dye",4L, 60D, 2D));
        eventRepo.save(new Event("Staight-cut", 7L, 20D, 0.5D));
        eventRepo.save(new Event("Mohawk", 5L, 120D, 1D));
        eventRepo.save(new Event("Edge-up", 6L, 20D, .25D));

    }
}
