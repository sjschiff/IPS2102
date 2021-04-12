package backend;

import java.io.*;
import java.util.ArrayList;

// Class representing the database of Patient Profile information
public class PatientProfDB {
    private int numPatient;                             // Number of patients in the database
    private int currentPatientIndex;                    // Index of current patient when searching
                                                        //      through patients tied to an adminID
    private String filename;                            // The filename of the file used to write and load from
    private ArrayList<PatientProf> patientList;         // The ArrayList of all Patient Profiles in the database

    // Constructor method
    // Takes in the filename to be used
    // Instantiates the attributes of the database
    public PatientProfDB(String filename){
        this.numPatient = 0;
        this.currentPatientIndex = 0;
        this.filename = filename;
        this.patientList = new ArrayList<PatientProf>();
    }

    // Inserts a new profile into the database and increases the number of patients in the database
    public void insertNewProfile(PatientProf patient){
        this.patientList.add(patient);
        this.numPatient++;
    }

    // Takes in an adminID and the lastName of a patient
    // Removes the patient from the database if they are in the database
    // Returns true if the remove was successful and false if it was unsuccessful
    public boolean deleteProfile(String adminID, String lastName){
        for (PatientProf patient : patientList){
            if (patient.getadminID().equals(adminID)){
                if (patient.getLastName().equals(lastName)){
                    this.patientList.remove(patient);
                    this.numPatient--;
                    return true;
                }
            }
        }
        return false;
    }

    // Takes in an adminID and the lastName of a patient
    // Returns the Backend.PatientProf from the database if it can be found
    // Returns null if the Backend.PatientProf is not in the database
    public PatientProf findProfile(String adminID, String lastName){
        for (PatientProf patient : patientList){
            if (patient.getadminID().equals(adminID)){
                if (patient.getLastName().equals(lastName)){
                    return patient;
                }
            }
        }
        return null;
    }

    // Takes an adminID of an administrator
    // Finds the Backend.PatientProf with the lowest index that has that adminID and sets the currentPatientIndex to that index
    // Returns the Backend.PatientProf that was found or null if there are no Backend.PatientProf's with that adminID
    public PatientProf findFirstProfile(String adminID){
        for (int i = 0; i<patientList.size(); i++){
            if(patientList.get(i).getadminID().equals(adminID)){
                currentPatientIndex = i;
                return patientList.get(i);
            }
        }
        return null;
    }

    // Using the currentPatientIndex, finds which adminID is currently being searched
    // and returns the next Backend.PatientProf in the database with the same adminId
    // Also sets the currentPatientIndex to the index of the found Backend.PatientProf
    public PatientProf findNextProfile(){
        String currentAdminId = patientList.get(currentPatientIndex).getadminID();
        for (int i = currentPatientIndex + 1; i<patientList.size(); i++){
            if(patientList.get(i).getadminID().equals(currentAdminId)){
                currentPatientIndex = i;
                return patientList.get(i);
            }
        }
        return null;
    }

    // Writes all the Backend.PatientProf in the database to the file at filename
    // Throws Exceptions if the file can not be found or there is an IO error
    public void writeAllPatientProf(String filename){

        try{
            FileOutputStream f = new FileOutputStream(new File(filename));
            ObjectOutputStream o = new ObjectOutputStream(f);

            for (PatientProf patient: patientList){
                o.writeObject(patient);
            }

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Reads all the PatientProfs that were stored in the file at filename into the database
    // Throws an Exception if the file can not be found, there is an IO error, or there is an error
    // receiving an object from the saved data
    public void initializeDatabase(String filename){
        try {
            FileInputStream fi = new FileInputStream(new File(filename));
            ObjectInputStream oi = new ObjectInputStream(fi);

            while(fi.available() != 0){
                PatientProf nextPatient = (PatientProf) oi.readObject();
                patientList.add(nextPatient);
                numPatient++;
            }

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not find file");
        } catch (IOException e) {
            throw new RuntimeException("IO Exception when trying to open file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error when reading from file");
        }

    }

}
