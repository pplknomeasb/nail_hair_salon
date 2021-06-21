package org.perscholas.services;

import lombok.extern.java.Log;
import org.perscholas.daos.IAppointmentRepo;
import org.perscholas.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Log
@Service
public class AppointmentService {

    private final IAppointmentRepo appointmentRepo;

    @Autowired
    public AppointmentService(IAppointmentRepo appointmentRepo) {this.appointmentRepo = appointmentRepo; }

    public List<Appointment> getAppointments() {return appointmentRepo.findAll();}

    public Appointment addNewAppointment(Appointment appointment){
        Optional<Appointment> appointmentOptional = appointmentRepo.findByaConfirmationNumber(appointment.getAStylistEmpNumber());
        if(appointmentOptional.isPresent()){
            throw new IllegalStateException(appointmentOptional + " is already assigned to the scheduler.");
        }
        return appointmentRepo.save(appointment);
    }


    public void updateAppointment(String aClientEmail, Date aDateTime, String aEventType, Long aStylistEmpNumber, Long aConfirmationNumber){

        boolean exists = appointmentRepo.existsById(aConfirmationNumber);
        if(exists){
            Appointment appointment= appointmentRepo.findByaConfirmationNumber(aConfirmationNumber).get();
            log.info("Client Details were updated.");
            appointment.setAClientEmail(aClientEmail);
            appointment.setADateTime(aDateTime);
            appointment.setAEventType(aEventType);
            appointment.setAStylistEmpNumber(aStylistEmpNumber);


        }


    }

    @Transactional
    public void removeAppointment(Long aConfirmationNumber){
        Optional<Appointment> appointmentOptional = appointmentRepo.findByaConfirmationNumber(aConfirmationNumber);
        boolean exists = appointmentRepo.existsById(aConfirmationNumber);
        if(exists){
            log.info("Client with Confirmation number " + aConfirmationNumber+ " has been removed");
            appointmentRepo.deleteById(aConfirmationNumber);
        }
    }




}
