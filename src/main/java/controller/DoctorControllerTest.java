package main.java.controller;

import static org.junit.Assert.*;

import main.java.model.Consultation;
import main.java.model.Patient;
import main.java.repository.Repository;
import main.java.exceptions.PatientException;
import main.java.exceptions.ConsultationException;

import java.util.ArrayList;
import java.util.List;

public class DoctorControllerTest {

    @org.junit.Test
    public void addPatient() {
        Patient p1 = new Patient("","123","");
        Patient p2 = new Patient("1960408205572","Nick","bla");
        Patient p3 = new Patient("1160408205642","","");
        String patients = "FilePatients.txt";
        String consultations = "FileConsultations.txt";
        Repository r = new Repository(patients,consultations);
        DoctorController c = new DoctorController(r);
        try {
            List<Patient> pat = c.getPatientList();
            Long l = (long)c.getPatientList().size()+1;
            c.addPatient(p1);
            Long result = (long)c.getPatientList().size();
            assertEquals(result,l);
            c.addPatient(p2);
            l++;
            Long result2 = (long)c.getPatientList().size();
            assertEquals(result2,l);
            c.addPatient(p3);
            Long result3 = (long)c.getPatientList().size();
            assertEquals(result3,l);
        } catch(PatientException e) {
            System.out.println(e.getMessage());
        }

    }

    @org.junit.Test
    public void addConsultation() {
        List<String> t1 = new ArrayList<>();
        List<String> t2 = new ArrayList<>();
        t2.add("crema");
        List<String> t3 = new ArrayList<>();
        t3.add("sirop");
        String patients = "FilePatients.txt";
        String consultations = "FileConsultations.txt";
        Repository r = new Repository(patients,consultations);
        DoctorController c = new DoctorController(r);
        try {
            List<Consultation> cons = c.getConsultationList();
            Long l = (long)c.getConsultationList().size()+1;
            c.addConsultation("6","2222222222222","tuse",t1,"09.02.2015");
            Long result = (long)c.getConsultationList().size();
            assertEquals(result,l);
            c.addConsultation("","2222222222222","acnee",t2,"08.08.2008");
            Long result2 = (long)c.getConsultationList().size();
            assertEquals(result2,l);
            c.addConsultation("8","2222222222222","viroza",t3,"02.02.2002");
            Long l1 = result2 + 1;
            Long result3 = (long)c.getConsultationList().size();
            assertEquals(result3,l1);
        } catch (ConsultationException e) {
            System.out.println(e.getMessage());
        }
    }

    @org.junit.Test
    public void getPatientsWithDisease() {

    }
}