/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* BOOK UNIT TEST (BookTest.java)                                                                                                         /
/* --------------------------------------------------------------------------------------------------------------------------------------*/
package referenceapplication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TEST 1 ------------------------------------------------------------------
    @Test
    public void testFormatReferenceWithEdition() {
        Book bookInput = new Book(
                new String[]{"Smith, J.", "Anderson, A."},
                1990,
                "Java for Beginners",
                "Cape Town",
                "Green Publishing Group",
                "2nd ed."
        );

        String ref = bookInput.formatReference();

        assertTrue(ref.contains("Smith, J. and Anderson, A."));
        assertTrue(ref.contains(" 1990. "));
        assertTrue(ref.contains("Java for Beginners"));
        assertTrue(ref.contains(" 2nd ed."));
        assertTrue(ref.contains(" Cape Town: Green Publishing Group"));
    }
    
    // TEST 2 ------------------------------------------------------------------
    @Test
    public void testFormatReferenceNoEdition() {
        Book bookInput = new Book(new String[]{"Sanders, Z."}, 2022, "Dictionary", "London", "Publisher 1", "");
        String ref = bookInput.formatReference();
        assertFalse(ref.toLowerCase().contains("ed."));    
    }
    
    // TEST 3 ------------------------------------------------------------------
    @Test
    public void testFormatReferenceFirstEdition(){
        Book bookInput = new Book(new String[]{"Sanders, Z."}, 2022, "Dictionary", "London", "Publisher 1", "1st ed.");
        String ref = bookInput.formatReference();
        assertFalse(ref.contains("1st ed."));
    }

/*
 * --------------------------------------------------------------------------------------------------------------------------------------
 * AUTO-GENERATED TEST STUBS (NETBEANS PROTOTYPES)
 * --------------------------------------------------------------------------------------------------------------------------------------
 */    
    /**
     * Test of formatReference method, of class Book.
     */
    @Test
    public void testFormatReference() {
        System.out.println("formatReference");
        Book instance = null;
        String expResult = "";
        String result = instance.formatReference();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

// ---------------------------------------------------------------------------------------------------------------------------------------- //
// END OF FILE                                                                                                                              //
// ---------------------------------------------------------------------------------------------------------------------------------------- //
