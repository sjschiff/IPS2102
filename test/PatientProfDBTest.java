import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientProfDBTest {
    private PatientProfDB testdb;
    private static final MedCond medCondInfo = null;
    private static final PatientProf prof1 = new PatientProf("PA1", "John", "Smith",
            "UConn", "5555555555", 100, "Private", "Adult", medCondInfo);
    private static final PatientProf prof2 = new PatientProf("PA2", "John", "Smith",
            "UConn", "5555555555", 100, "Private", "Adult", medCondInfo);
    private static final PatientProf prof3 = new PatientProf("PA1", "John", "Apple",
            "UConn", "5555555555", 100, "Private", "Adult", medCondInfo);


    @BeforeEach
    void setUp(){
        testdb = new PatientProfDB("database1.txt");
    }

    @Test
    void insertNewProfile() {
        MedCond medCondInfo = null;
        testdb.insertNewProfile(prof1);
    }

    @Test
    void deleteProfile() {
        MedCond medCondInfo = null;

        // Try to delete a profile that is not there
        assertFalse(testdb.deleteProfile("PA1", "Smith"));

        // Add profiles
        testdb.insertNewProfile(prof1);
        testdb.insertNewProfile(prof2);
        testdb.insertNewProfile(prof3);

        // Remove profile while there is same last name but different adminID
        assertTrue(testdb.deleteProfile("PA2", "Smith"));

        // Remove profile while there is same adminID but different last name
        assertTrue(testdb.deleteProfile("PA1", "Apple"));

    }

    @Test
    void findProfile() {

        // Empty list should return nothing
        assertNull(testdb.findProfile("PA1", "Smith"));

        testdb.insertNewProfile(prof1);
        testdb.insertNewProfile(prof2);
        testdb.insertNewProfile(prof3);

        // Test finding a profile that is not there
        assertNull(testdb.findProfile("PA2", "Apple"));

        // Test finding a profile that is present
        assertEquals(testdb.findProfile("PA1", "Smith"), prof1);
    }

    @Test
    void findFirstProfile() {

        // Empty database should return nothing
        assertNull(testdb.findFirstProfile("PA1"));

        // Insert test profiles
        testdb.insertNewProfile(prof1);
        testdb.insertNewProfile(prof2);
        testdb.insertNewProfile(prof3);

        // Test finding first profile when admin has none
        assertNull(testdb.findFirstProfile("PA3"));

        // Test finding first profile when admin has multiple
        assertEquals(testdb.findFirstProfile("PA1"), prof1);

        // Test finding first profile when profile is not first in the list
        assertEquals(testdb.findFirstProfile("PA2"), prof2);

    }

    @Test
    void findNextProfile() {
        // Empty database should return nothing
        assertNull(testdb.findFirstProfile("PA1"));

        // Insert test profiles
        testdb.insertNewProfile(prof1);
        testdb.insertNewProfile(prof2);
        testdb.insertNewProfile(prof3);

        // Try with PA1
        assertEquals(testdb.findFirstProfile("PA1"), prof1);
        assertEquals(testdb.findNextProfile(), prof3);

        // Try with PA2
        assertEquals(testdb.findFirstProfile("PA2"), prof2);
        assertNull(testdb.findNextProfile());

    }

    @Test
    void writeAllPatientProf() {
        testdb.insertNewProfile(prof1);
        testdb.insertNewProfile(prof2);
        testdb.insertNewProfile(prof3);

        testdb.writeAllPatientProf("database.txt");
    }

    @Test
    void initializeDatabase() {
        // Initialize database from the file
        testdb.initializeDatabase("database.txt");

        // Try to find the profiles that should be in the database
        PatientProf foundProf1 = testdb.findProfile("PA1", "Smith");
        PatientProf foundProf2 = testdb.findProfile("PA2", "Smith");
        PatientProf foundProf3 = testdb.findProfile("PA1", "Apple");

        // Check that the data matches
        assertEquals(foundProf1.getadminID(), prof1.getadminID());
        assertEquals(foundProf1.getLastName(), prof1.getLastName());

        assertEquals(foundProf2.getadminID(), prof2.getadminID());
        assertEquals(foundProf2.getLastName(), prof2.getLastName());

        assertEquals(foundProf3.getadminID(), prof3.getadminID());
        assertEquals(foundProf3.getLastName(), prof3.getLastName());


    }
}