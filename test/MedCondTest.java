import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedCondTest {
    MedCond medCondInfo;

    @BeforeEach
    void setUp(){
        medCondInfo = new MedCond("Carrie Anne","8005558000", "None", "None");
    }

    @Test
    void testConstructor(){
        medCondInfo = new MedCond("Carrie Anne","8005558000", "None", "None");
        assertEquals("Carrie Anne", medCondInfo.getMdContact());
        assertEquals("8005558000", medCondInfo.getMdPhone());
        assertEquals("None", medCondInfo.getAlgType());
        assertEquals("None", medCondInfo.getIllType());
    }

    @Test
    void updateMdContact() {
        try{
            medCondInfo.updateMdContact("Illegal!");
            fail();
        }catch (RuntimeException e){
            assertEquals("Carrie Anne", medCondInfo.getMdContact());
        }

        medCondInfo.updateMdContact("John Smith");
        assertEquals("John Smith", medCondInfo.getMdContact());
    }

    @Test
    void updateMdPhone() {
        try{
            medCondInfo.updateMdPhone("555-555-5555");
            fail();
        }catch (RuntimeException e){
            assertEquals("8005558000", medCondInfo.getMdPhone());
        }

        medCondInfo.updateMdPhone("5555555555");
        assertEquals("5555555555", medCondInfo.getMdPhone());
    }

    @Test
    void updateAlgType() {
        try{
            medCondInfo.updateAlgType("Peanut");
            fail();
        }catch (RuntimeException e){
            assertEquals("None", medCondInfo.getAlgType());
        }

        medCondInfo.updateAlgType("Food");
        assertEquals("Food", medCondInfo.getAlgType());

        medCondInfo.updateAlgType("Medication");
        assertEquals("Medication", medCondInfo.getAlgType());

        medCondInfo.updateAlgType("Other");
        assertEquals("Other", medCondInfo.getAlgType());

        medCondInfo.updateAlgType("None");
        assertEquals("None", medCondInfo.getAlgType());
    }

    @Test
    void updateIllType() {
        try{
            medCondInfo.updateIllType("Flu");
            fail();
        }catch (RuntimeException e){
            assertEquals("None", medCondInfo.getIllType());
        }

        medCondInfo.updateIllType("CHD");
        assertEquals("CHD", medCondInfo.getIllType());

        medCondInfo.updateIllType("Diabetes");
        assertEquals("Diabetes", medCondInfo.getIllType());

        medCondInfo.updateIllType("Asthma");
        assertEquals("Asthma", medCondInfo.getIllType());

        medCondInfo.updateIllType("Other");
        assertEquals("Other", medCondInfo.getIllType());

        medCondInfo.updateIllType("None");
        assertEquals("None", medCondInfo.getIllType());
    }
}