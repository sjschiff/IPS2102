import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientProfTest {

    @Test
    void testConstructor(){
        MedCond medCondInfo = null;
        PatientProf profile = new PatientProf("PA1", "Sam", "Schiffer",
                "UConn", "5551234567", 500, "Private", "Adult", medCondInfo);
        assertNotNull(profile);
    }

    @Test
    void getadminID() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void getAddress() {
    }

    @Test
    void getPhone() {
    }

    @Test
    void getCoPay() {
    }

    @Test
    void getInsuType() {
    }

    @Test
    void getPatientType() {
    }

    @Test
    void getMedCondInfo() {
    }

    @Test
    void updateFirstName() {
    }

    @Test
    void updateLastName() {
    }

    @Test
    void updateAddress() {
    }

    @Test
    void updatePhone() {
    }

    @Test
    void updateCoPay() {
    }

    @Test
    void updateInsuType() {
    }

    @Test
    void updatePatientType() {
    }

    @Test
    void updateMedCondInfo() {
    }
}