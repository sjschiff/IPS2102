import java.io.Serializable;
import java.util.regex.Pattern;

// Class representing the Medical Conditions of a patient
public class MedCond implements Serializable {
    private static final long serialVersionUID = 1L;    // Used for serialization of class to store into a file

    private String mdContact;                           // Medical Contact for the patient
    private String mdPhone;                             // Medical Contact's phone number
    private String algType;                             // Allergy type of the patient
    private String illType;                             // Known Illnesses of the patient

    // Constructor for MedCond
    // Takes in values for each attribute except serialVersionUID
    // Calls the corresponding update methods that ensure the input is valid
    public MedCond(String mdContact, String mdPhone, String algType, String illType) {
        updateMdContact(mdContact);
        updateMdPhone(mdPhone);
        updateAlgType(algType);
        updateIllType(illType);
    }

    // Getter that returns the mdContact
    public String getMdContact() {
        return mdContact;
    }

    // Getter that returns the mdPhone
    public String getMdPhone() {
        return mdPhone;
    }

    // Getter that returns the algType
    public String getAlgType() { return algType; }

    // Getter that returns the illType
    public String getIllType() { return illType; }

    // Updates the mdContact
    // Ensures that the name only consists of letters and spaces
    // Throws a RuntimeException if contact name has illegal characters
    public void updateMdContact(String mdContact) {
        if (Pattern.matches("[a-zA-Z'\\p{Blank}]+", mdContact)){
            this.mdContact = mdContact;
        }else{
            throw new RuntimeException("Names can only contain letters or spaces");
        }
    }

    // Updates the mdPhone
    // Ensures that the phone number is only 10 digits with no symbols
    // Throws a Runtime Exception if the phone number does not follow this format
    public void updateMdPhone(String mdPhone) {
        if (Pattern.matches("\\d{10}", mdPhone)){
            this.mdPhone = mdPhone;
        }else{
            throw new RuntimeException("Phone numbers should be 10 digits no characters");
        }
    }

    // Updates the algType
    // Ensures that the allergy type is one of 'None', 'Food', 'Medication', or 'Other'
    // Throws a RuntimeException if the input is not a valid choice
    public void updateAlgType(String algType) {
        switch(algType){
            case "None":
                this.algType = "None";
                break;
            case "Food":
                this.algType = "Food";
                break;
            case "Medication":
                this.algType = "Medication";
                break;
            case "Other":
                this.algType = "Other";
                break;
            default:
                throw new RuntimeException("Allergy type must be 'None', 'Food', 'Medication' or 'Other'");
        }
    }

    // Updates the illType
    // Ensures that the illness type is one of 'None', 'CHD', 'Diabetes', 'Asthma' or 'Other'
    // Throws a RuntimeException if the the input is not a valid choice
    public void updateIllType(String illType) {
        switch(illType){
            case "None":
                this.illType = "None";
                break;
            case "CHD":
                this.illType = "CHD";
                break;
            case "Diabetes":
                this.illType = "Diabetes";
                break;
            case "Asthma":
                this.illType = "Asthma";
                break;
            case "Other":
                this.illType = "Other";
                break;
            default:
                throw new RuntimeException("Illness type must be 'None', 'CHD', 'Diabetes', 'Asthma' or 'Other'");
        }
    }

}
