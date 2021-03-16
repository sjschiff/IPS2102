import java.io.*;
import java.util.ArrayList;

public class PatientProfDB {
    private int numPatient;
    private int currentPatientIndex;
    private String filename;
    private ArrayList<PatientProf> patientList;

    public PatientProfDB(String filename){
        this.numPatient = 0;
        this.currentPatientIndex = 0;
        this.filename = filename;
        this.patientList = new ArrayList<PatientProf>();
    }

    public void insertNewProfile(PatientProf patient){
        this.patientList.add(patient);
        this.numPatient++;
    }

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

    public PatientProf findFirstProfile(String adminID){
        for (int i = 0; i<patientList.size(); i++){
            if(patientList.get(i).getadminID().equals(adminID)){
                currentPatientIndex = i;
                return patientList.get(i);
            }
        }
        return null;
    }

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

    public void initializeDatabase(String filename){
        try {
            FileInputStream fi = new FileInputStream(new File(filename));
            ObjectInputStream oi = new ObjectInputStream(fi);

            while(fi.available() != 0){
                PatientProf nextPatient = (PatientProf) oi.readObject();
                patientList.add(nextPatient);
            }

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
