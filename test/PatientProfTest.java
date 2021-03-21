import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientProfTest {

    private PatientProf testProfile;
    MedCond testMedCondInfo;
    @BeforeEach
    public void setUp(){

        testMedCondInfo = new MedCond("John Smith", "5555555555", "None", "None");
        testProfile = new PatientProf("PA1", "John", "Smith",
                "UConn", "5555555555", 100, "Private", "Adult", testMedCondInfo);
    }

    @Test
    void testConstructor(){
        MedCond medCondInfo = null;
        PatientProf profile = null;

        try {
            profile = new PatientProf("123", "Sam", "Schiffer",
                    "UConn", "5551234567", 500, "Private", "Adult", medCondInfo);
            fail();
        }catch (RuntimeException e){
            assertNull(profile);
        }

        profile = new PatientProf("PA1", "Sam", "Schiffer",
                "UConn", "5551234567", 500, "Private", "Adult", medCondInfo);
        assertNotNull(profile);

    }

    @Test
    void getadminID() {
        assertEquals(testProfile.getadminID(), "PA1");
    }

    @Test
    void getFirstName() {
        assertEquals(testProfile.getFirstName(), "John");
    }

    @Test
    void getLastName() {
        assertEquals(testProfile.getLastName(), "Smith");
    }

    @Test
    void getAddress() {
        assertEquals(testProfile.getAddress(), "UConn");
    }

    @Test
    void getPhone() {
        assertEquals(testProfile.getPhone(), "5555555555");
    }

    @Test
    void getCoPay() {
        assertEquals(testProfile.getCoPay(), 100);
    }

    @Test
    void getInsuType() {
        assertEquals(testProfile.getInsuType(), "Private");
    }

    @Test
    void getPatientType() {
        assertEquals(testProfile.getPatientType(), "Adult");
    }

    @Test
    void getMedCondInfo() {
        assertEquals(testMedCondInfo, testProfile.getMedCondInfo());
    }

    @Test
    void updateFirstName() {
        // Try a first name that has special characters
        try{
            testProfile.updateFirstName("Sam$!*S");
            fail();
        }catch (RuntimeException e){
            assertEquals(testProfile.getFirstName(), "John");
        }

        // Try a first name that has a space in it
        testProfile.updateFirstName("Carrie Anne");
        assertEquals(testProfile.getFirstName(), "Carrie Anne");

        //Try a first name that has upper and lower case
        testProfile.updateFirstName("saMuel");
        assertEquals(testProfile.getFirstName(), "saMuel");
    }

    @Test
    void updateLastName() {
        // Try a last name with special characters
        try{
            testProfile.updateLastName("Schiffer!");
            fail();
        }catch (RuntimeException e){
            assertEquals(testProfile.getFirstName(), "John");
        }

        // Try a last name with an apostrophe
        testProfile.updateLastName("O'Malley");
        assertEquals(testProfile.getLastName(), "O'Malley");

    }

    @Test
    void updateAddress() {
        // Try updating the address
        testProfile.updateAddress("96 Huskyville Road");
        assertEquals(testProfile.getAddress(), "96 Huskyville Road");
    }

    @Test
    void updatePhone() {
        // Try a phone number with slahes
        try {
            testProfile.updatePhone("555-555-0000");
            fail();
        } catch (RuntimeException e){
            assertEquals(testProfile.getPhone(), "5555555555");
        }

        //Try using letters
        try {
            testProfile.updatePhone("eight zero zero eight");
            fail();
        } catch (RuntimeException e){
            assertEquals(testProfile.getPhone(), "5555555555");
        }

        // Try another 10 digit number
        testProfile.updatePhone("8885557777");
        assertEquals(testProfile.getPhone(), "8885557777");

    }

    @Test
    void updateCoPay() {
        // Try updating the copay
        testProfile.updateCoPay(300000);
        assertEquals(testProfile.getCoPay(), 300000);
    }

    @Test
    void updateInsuType() {
        // Try using an invalid type
        try{
            testProfile.updateInsuType("Public");
            fail();
        }catch (RuntimeException e){
            assertEquals(testProfile.getInsuType(), "Private");
        }

        //Try updating to Government
        testProfile.updateInsuType("Government");
        assertEquals(testProfile.getInsuType(), "Government");

        //Try updating to Private
        testProfile.updateInsuType("Private");
        assertEquals(testProfile.getInsuType(), "Private");
    }

    @Test
    void updatePatientType() {
        //Try using an invalid type
        try{
            testProfile.updatePatientType("Child");
            fail();
        } catch (Exception e){
            assertEquals(testProfile.getPatientType(), "Adult");
        }

        //Try updating to "Pediatric"
        testProfile.updatePatientType("Pediatric");
        assertEquals(testProfile.getPatientType(), "Pediatric");

        //Try updating to "Adult"
        testProfile.updatePatientType("Adult");
        assertEquals(testProfile.getPatientType(), "Adult");

        //Try updating to "Senior"
        testProfile.updatePatientType("Senior");
        assertEquals(testProfile.getPatientType(), "Senior");

    }

    @Test
    void updateMedCondInfo() {
        MedCond newInfo = new MedCond("John", "5555555555", "None", "None");
        testProfile.updateMedCondInfo(newInfo);
        assertEquals(newInfo, testProfile.getMedCondInfo());
    }
}