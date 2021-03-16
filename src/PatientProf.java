import java.io.Serializable;
import java.util.regex.Pattern;

public class PatientProf implements Serializable {
    private static final long serialVersionUID = 1L;

    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float coPay;
    private String insuType;
    private String patientType;
    private MedCond medCondInfo;

    public PatientProf(String adminID, String firstName, String lastName, String address, String phone, float coPay, String insuType, String patientType, MedCond medCondInfo) {

        if (Pattern.matches("PA\\d+", adminID)) {
            this.adminID = adminID;
        }else{
            throw new RuntimeException("Admin ID must follow format: PA<number>");
        }

        updateFirstName(firstName);
        updateLastName(lastName);
        updateAddress(address);
        updatePhone(phone);
        updateCoPay(coPay);
        updateInsuType(insuType);
        updatePatientType(patientType);
        updateMedCondInfo(medCondInfo);
    }

    public String getadminID() {
        return adminID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public float getCoPay() {
        return coPay;
    }

    public String getInsuType() {
        return insuType;
    }

    public String getPatientType() {
        return patientType;
    }

    public MedCond getMedCondInfo() {
        return medCondInfo;
    }

    public void updateFirstName(String firstName) {
        if (Pattern.matches("[a-zA-Z\\p{Blank}]+", firstName)){
            this.firstName = firstName;
        }else{
            throw new RuntimeException("First names can only contain letters or spaces");
        }

    }

    public void updateLastName(String lastName) {
        if (Pattern.matches("[a-zA-Z'\\p{Blank}]+", lastName)){
            this.lastName = lastName;
        }else{
            throw new RuntimeException("Invalid last name");
        }
    }

    public void updateAddress(String address) {
        this.address = address;
    }

    public void updatePhone(String phone) {
        if (Pattern.matches("\\d{10}", phone)){
            this.phone = phone;
        }else{
            throw new RuntimeException("Phone numbers should be 10 digits no characters");
        }

    }

    public void updateCoPay(float coPay) {
        this.coPay = coPay;
    }

    public void updateInsuType(String insuType) {
        switch(insuType){
            case "Private":
                this.insuType = "Private";
                break;
            case "Government":
                this.insuType = "Government";
                break;
            default:
                throw new RuntimeException("Insurance Type must be 'Private' or 'Government'");
        }
    }

    public void updatePatientType(String patientType) {
        switch(patientType){
            case "Pediatric":
                this.patientType = "Pediatric";
                break;
            case "Adult":
                this.patientType = "Adult";
                break;
            case "Senior":
                this.patientType = "Senior";
                break;
            default:
                throw new RuntimeException("Patient Type must be 'Pediatric' or 'Adult' or 'Senior'");
        }
    }

    public void updateMedCondInfo(MedCond medCondInfo) {
        this.medCondInfo = medCondInfo;
    }
}
