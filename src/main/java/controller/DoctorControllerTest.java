package controller;

import static org.junit.Assert.*;

import model.Consultation;
import model.Patient;
import repository.Repository;
import exceptions.PatientException;
import exceptions.ConsultationException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DoctorControllerTest {

    @Test
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
/*
    @org.junit.Test
    public void getPatientsWithDisease() {
        List<String> t1 = new ArrayList<>();
        t1.add("juj");
        List<String> t2 = new ArrayList<>();
        t2.add("crema");
        List<String> t3 = new ArrayList<>();
        t3.add("sirop");
        String patients = "FilePatients.txt";
        String consultations = "FileConsultations.txt";
        Repository r = new Repository(patients,consultations);
        DoctorController c = new DoctorController(r);
        try {
            c.addConsultation("20","2222222222222","acnee",t2,"08.08.2008");
        }
        catch (ConsultationException e) {
            System.out.println(e.getMessage());
        }
        try {
            Long result = (long)c.getPatientsWithDisease("tuse").size()+1;
            c.addConsultation("22","2222222222222","tuse",t1,"09.02.2015");
            System.out.println(result);
            Long l = (long)c.getPatientsWithDisease("tuse").size();
            assertEquals(result,l);

        } catch (PatientException e) {
            System.out.println(e.getMessage());
        } catch (ConsultationException e) {
            System.out.println(e.getMessage());
        }

    }
*/
    @org.junit.Test
    public void integrationFunc1() {
        addPatient();
    }

    @org.junit.Test
    public void integrationFunc2() {
        addPatient();
        addConsultation();
    }

    @org.junit.Test
    public void integrationFunc3() {
        addPatient();
        addConsultation();
//        getPatientsWithDisease();
    }




}