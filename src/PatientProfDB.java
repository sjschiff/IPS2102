import java.util.ArrayList;

public class PatientProfDB {
    private int numPatient;
    private int currentPatientIndex;
    private String filename;
    private ArrayList<PatientProf> patientList;

    public PatientProfDB(String filename){

    }

    public void insertNewProfile(PatientProf patient){

    }

    public boolean deleteProfile(String adminID, String lastName){
        return false;
    }

    public PatientProf findProfile(String adminID, String lastName){
        return null;
    }

    public PatientProf findFirstProfile(){
        return null;
    }

    public PatientProf findNextProfile(){
        return null;
    }

    public void writeAllPatientProf(String filename){

    }

    public void initializeDatabase(String filename){

    }

}
