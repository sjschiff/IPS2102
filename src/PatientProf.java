public class PatientProf {
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
        this.adminID = adminID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.coPay = coPay;
        this.insuType = insuType;
        this.patientType = patientType;
        this.medCondInfo = medCondInfo;
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
        this.firstName = firstName;
    }

    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updateAddress(String address) {
        this.address = address;
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void updateCoPay(float coPay) {
        this.coPay = coPay;
    }

    public void updateInsuType(String insuType) {
        this.insuType = insuType;
    }

    public void updatePatientType(String patientType) {
        this.patientType = patientType;
    }

    public void updateMedCondInfo(MedCond medCondInfo) {
        this.medCondInfo = medCondInfo;
    }
}
