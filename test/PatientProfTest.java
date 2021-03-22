import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Test class for PatientProf
class PatientProfTest {

    private PatientProf testProfile;        // PatientProf to be used in each test
    MedCond testMedCondInfo;                // MedCond to be used in each test

    // setUp method to initialize the testProfile and testMedCondInfo before each test
    @BeforeEach
    public void setUp(){

        testMedCondInfo = new MedCond("John Smith", "5555555555", "None", "None");
        testProfile = new PatientProf("PA1", "John", "Smith",
                "UConn", "5555555555", 100, "Private", "Adult", testMedCondInfo);
    }

    // Tests the constructor
    @Test
    void testConstructor(){
        PatientProf profile = null;

        // Ensure that the adminID check in the constructor only excepts the format PA<#>
        // This instantiation should throw a RuntimeException
        try {
            profile = new PatientProf("123", "Sam", "Schiffer",
                    "UConn", "5551234567", 500, "Private", "Adult", testMedCondInfo);
            fail();
        }catch (RuntimeException e){
            assertNull(profile);
        }

        // This instantiation should succeed
        profile = new PatientProf("PA1", "Sam", "Schiffer",
                "UConn", "5551234567", 500, "Private", "Adult", testMedCondInfo);
        assertNotNull(profile);

    }

    // Tests getadminID gets the correct value
    @Test
    void getadminID() {
        assertEquals(testProfile.getadminID(), "PA1");
    }

    // Tests getFirstName gets the correct value
    @Test
    void getFirstName() {
        assertEquals(testProfile.getFirstName(), "John");
    }

    // Tests getLastName gets the correct value
    @Test
    void getLastName() {
        assertEquals(testProfile.getLastName(), "Smith");
    }

    // Tests getAddress gets the correct value
    @Test
    void getAddress() {
        assertEquals(testProfile.getAddress(), "UConn");
    }

    // Tests getPhone gets the correct value
    @Test
    void getPhone() {
        assertEquals(testProfile.getPhone(), "5555555555");
    }

    // Tests getCoPay gets the correct value
    @Test
    void getCoPay() {
        assertEquals(testProfile.getCoPay(), 100);
    }

    // Tests getInsuType gets the correct value
    @Test
    void getInsuType() {
        assertEquals(testProfile.getInsuType(), "Private");
    }

    // Tests getPatientType gets the correct value
    @Test
    void getPatientType() {
        assertEquals(testProfile.getPatientType(), "Adult");
    }

    // Tests getMedCondInfo gets the correct value
    @Test
    void getMedCondInfo() {
        assertEquals(testMedCondInfo, testProfile.getMedCondInfo());
    }

    // Tests updateFirstName to ensure the checks work
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

    // Test updateLastName to ensure the checks work
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

    // Tests that updateAddress works
    @Test
    void updateAddress() {
        // Try updating the address
        testProfile.updateAddress("96 Huskyville Road");
        assertEquals(testProfile.getAddress(), "96 Huskyville Road");
    }

    // Test updatePhone to ensure the checks work
    @Test
    void updatePhone() {
        // Try a phone number with slashes
        try {
            testProfile.updatePhone("555-555-0000");
            fail();
        } catch (RuntimeException e){
            assertEquals(testProfile.getPhone(), "5555555555");
        }

        // Try using letters
        try {
            testProfile.updatePhone("eight zero zero eight");
            fail();
        } catch (RuntimeException e){
            assertEquals(testProfile.getPhone(), "5555555555");
        }

        // Try a 9 digit phone number
        try {
            testProfile.updatePhone("555888555");
            fail();
        } catch (RuntimeException e){
            assertEquals(testProfile.getPhone(), "5555555555");
        }

        // Try another 10 digit number
        testProfile.updatePhone("8885557777");
        assertEquals(testProfile.getPhone(), "8885557777");

    }

    // Test that updateCoPay works
    @Test
    void updateCoPay() {
        // Try updating the copay
        testProfile.updateCoPay(300000);
        assertEquals(testProfile.getCoPay(), 300000);
    }

    // Test updateInsuType to ensure the checks work
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

    // Test updatePatientType to ensure the checks work
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

    // Test that updateMedCondInfo works
    @Test
    void updateMedCondInfo() {
        MedCond newInfo = new MedCond("John", "5555555555", "None", "None");
        testProfile.updateMedCondInfo(newInfo);
        assertEquals(newInfo, testProfile.getMedCondInfo());
    }
}