import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Tests the MedCond class
class MedCondTest {
    MedCond medCondInfo;        // MedCond used for testing

    // setUp function to initialize the MedCond used for testing
    @BeforeEach
    void setUp(){
        medCondInfo = new MedCond("Carrie Anne","8005558000", "None", "None");
    }

    // Tests the constructor
    // Ensures each attribute gets set correctly
    // Also tests the get methods for all attributes
    @Test
    void testConstructor(){
        medCondInfo = new MedCond("Carrie Anne","8005558000", "None", "None");
        assertEquals("Carrie Anne", medCondInfo.getMdContact());
        assertEquals("8005558000", medCondInfo.getMdPhone());
        assertEquals("None", medCondInfo.getAlgType());
        assertEquals("None", medCondInfo.getIllType());
    }

    // Tests updating the mdContact
    @Test
    void updateMdContact() {
        // Try using a symbol in the name
        try{
            medCondInfo.updateMdContact("Illegal!");
            fail();
        }catch (RuntimeException e){
            assertEquals("Carrie Anne", medCondInfo.getMdContact());
        }

        // Try updating with a space and an apostrophe
        medCondInfo.updateMdContact("John O'Malley");
        assertEquals("John O'Malley", medCondInfo.getMdContact());
    }

    // Tests updating the mdPhone
    @Test
    void updateMdPhone() {
        // Try a phone number with dashes
        try{
            medCondInfo.updateMdPhone("555-555-5555");
            fail();
        }catch (RuntimeException e){
            assertEquals("8005558000", medCondInfo.getMdPhone());
        }

        // Try a valid phone number
        medCondInfo.updateMdPhone("5555555555");
        assertEquals("5555555555", medCondInfo.getMdPhone());
    }

    // Tests updating the allergy type
    @Test
    void updateAlgType() {
        // Try an invalid type
        try{
            medCondInfo.updateAlgType("Peanut");
            fail();
        }catch (RuntimeException e){
            assertEquals("None", medCondInfo.getAlgType());
        }

        // Try updating to Food
        medCondInfo.updateAlgType("Food");
        assertEquals("Food", medCondInfo.getAlgType());

        // Try updating to Medication
        medCondInfo.updateAlgType("Medication");
        assertEquals("Medication", medCondInfo.getAlgType());

        // Try updating to Other
        medCondInfo.updateAlgType("Other");
        assertEquals("Other", medCondInfo.getAlgType());

        // Try updating to None
        medCondInfo.updateAlgType("None");
        assertEquals("None", medCondInfo.getAlgType());
    }

    // Tests updating the illness type
    @Test
    void updateIllType() {
        // Try updating to an invalid type
        try{
            medCondInfo.updateIllType("Flu");
            fail();
        }catch (RuntimeException e){
            assertEquals("None", medCondInfo.getIllType());
        }

        // Try updating to CHD
        medCondInfo.updateIllType("CHD");
        assertEquals("CHD", medCondInfo.getIllType());

        // Try updating to Diabetes
        medCondInfo.updateIllType("Diabetes");
        assertEquals("Diabetes", medCondInfo.getIllType());

        // Try updating to Asthma
        medCondInfo.updateIllType("Asthma");
        assertEquals("Asthma", medCondInfo.getIllType());

        // Try updating to Other
        medCondInfo.updateIllType("Other");
        assertEquals("Other", medCondInfo.getIllType());

        // Try updating to None
        medCondInfo.updateIllType("None");
        assertEquals("None", medCondInfo.getIllType());
    }
}