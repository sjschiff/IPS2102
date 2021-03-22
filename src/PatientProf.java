import java.io.Serializable;
import java.util.regex.Pattern;

// Class representing a Patient Profile
public class PatientProf implements Serializable {
    private static final long serialVersionUID = 1L;    // Used for serialization of class to store into a file

    private String adminID;                             // Admin ID of admin who created the profile
    private String firstName;                           // Patient's first name
    private String lastName;                            // Patient's last name
    private String address;                             // Patient's address
    private String phone;                               // Patient's phone number
    private float coPay;                                // Patient's copay amount
    private String insuType;                            // Patient's type of insurance
    private String patientType;                         // Patient's type
    private MedCond medCondInfo;                        // MedCond object that holds Medical Condition information

    // Constructor method, takes in values for each attribute except serialVersionUID
    // Calls the corresponding update methods which ensures each value is valid
    public PatientProf(String adminID, String firstName, String lastName, String address, String phone, float coPay, String insuType, String patientType, MedCond medCondInfo) {

        // Use pattern matching to ensure that the adminID follows the correct format
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

    // Getter that returns the adminID
    public String getadminID() {
        return adminID;
    }

    // Getter that returns the first name
    public String getFirstName() {
        return firstName;
    }

    // Getter that returns the last name
    public String getLastName() {
        return lastName;
    }

    // Getter that returns the address
    public String getAddress() {
        return address;
    }

    // Getter that returns the phone number
    public String getPhone() {
        return phone;
    }

    // Getter that returns the copay
    public float getCoPay() {
        return coPay;
    }

    // Getter that returns the type of insurance
    public String getInsuType() {
        return insuType;
    }

    // Getter that returns the type of patient
    public String getPatientType() {
        return patientType;
    }

    // Getter that returns the MedCond object
    public MedCond getMedCondInfo() {
        return medCondInfo;
    }

    // Checks that the new firstName is only letters or spaces and then sets the firstName to that name
    // Throws a RuntimeException if the new first name has any other characters
    public void updateFirstName(String firstName) {
        if (Pattern.matches("[a-zA-Z\\p{Blank}]+", firstName)){
            this.firstName = firstName;
        }else{
            throw new RuntimeException("First names can only contain letters or spaces");
        }

    }

    // Checks that the new lastName is only letters or spaces and then sets the lastName to that name
    // Throws a RuntimeException if the new last name has any other characters
    public void updateLastName(String lastName) {
        if (Pattern.matches("[a-zA-Z'\\p{Blank}]+", lastName)){
            this.lastName = lastName;
        }else{
            throw new RuntimeException("Invalid last name");
        }
    }

    // Updates the address attribute
    public void updateAddress(String address) {
        this.address = address;
    }

    // Checks that the input is only 10 digits and includes no special characters
    // Throws a RuntimeException if input does not follow phone number template
    public void updatePhone(String phone) {
        if (Pattern.matches("\\d{10}", phone)){
            this.phone = phone;
        }else{
            throw new RuntimeException("Phone numbers should be 10 digits no characters");
        }

    }

    // Takes a float input and updates the copay for the patient
    public void updateCoPay(float coPay) {
        this.coPay = coPay;
    }

    // Updates the insurance type of the patient
    // The insurance type must be either 'Private' or 'Governemnt'
    // Throws a RuntimeException if the input is not 'Private' or 'Government'
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

    // Update the Type of the Patient
    // The patient type must be 'Pediatric', 'Adult', or 'Senior'
    // Throws a RuntimeException is the input is not one of the allowed selections
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

    // Updates the MedCond object for this PatientProf
    public void updateMedCondInfo(MedCond medCondInfo){
        this.medCondInfo = medCondInfo;
    }

}
