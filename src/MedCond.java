import java.util.regex.Pattern;

public class MedCond {
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
        this.algType = algType;
    }

    public void updateIllType(String illType) {
        this.illType = illType;
    }

}
