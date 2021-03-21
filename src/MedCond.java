import java.io.Serializable;
import java.util.regex.Pattern;

public class MedCond implements Serializable {
    private static final long serialVersionUID = 1L;

    private String mdContact;
    private String mdPhone;
    private String algType;
    private String illType;

    public MedCond(String mdContact, String mdPhone, String algType, String illType) {

        updateMdContact(mdContact);
        updateMdPhone(mdPhone);
        updateAlgType(algType);
        updateIllType(illType);

    }

    public String getMdContact() {
        return mdContact;
    }

    public String getMdPhone() {
        return mdPhone;
    }

    public String getAlgType() { return algType; }

    public String getIllType() { return illType; }


    public void updateMdContact(String mdContact) {
        if (Pattern.matches("[a-zA-Z\\p{Blank}]+", mdContact)){
            this.mdContact = mdContact;
        }else{
            throw new RuntimeException("Names can only contain letters or spaces");
        }
    }

    public void updateMdPhone(String mdPhone) {
        if (Pattern.matches("\\d{10}", mdPhone)){
            this.mdPhone = mdPhone;
        }else{
            throw new RuntimeException("Phone numbers should be 10 digits no characters");
        }
    }

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
