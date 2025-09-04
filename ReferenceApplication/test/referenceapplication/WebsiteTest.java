/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* WEBSITE UNIT TEST (WebsiteTest.java)                                                                                                   /
/* --------------------------------------------------------------------------------------------------------------------------------------*/
package referenceapplication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class WebsiteTest {
    
    public WebsiteTest() {
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
    public void testFormatReferenceInclDate() {
        Website websiteInput = new Website(
                new String[]{"Bruce, W."},
                2023,
                "Top 10 Songs 2023",
                "Music Direct",
                "https://www.website1.com",
                "3 September 2025"
        );

        String ref = websiteInput.formatReference();

        assertTrue(ref.contains("Bruce, W."));
        assertTrue(ref.contains(" 2023. "));
        assertTrue(ref.contains("Top 10 Songs 2023"));
        assertTrue(ref.contains("Music Direct"));
        assertTrue(ref.contains(" Available at: https://www.website1.com"));
        assertTrue(ref.contains("[Accessed 3 September 2025]"));
    }
    
    // TEST 2 ------------------------------------------------------------------
    @Test
    public void testFormatReferenceNoDate() {
        Website websiteInput = new Website(
                new String[]{"Bruce, W."},
                2023,
                "Top 10 Songs 2023",
                "Music Direct",
                "https://www.website1.com",
                ""
        );

        String ref = websiteInput.formatReference();

        assertFalse(ref.contains("Accessed"));
        assertTrue(ref.contains("Available at: https://www.website1.com"));
    }

    
/*
 * --------------------------------------------------------------------------------------------------------------------------------------
 * AUTO-GENERATED TEST STUBS (NETBEANS PROTOTYPES)
 * --------------------------------------------------------------------------------------------------------------------------------------
 */    
    /**
     * Test of formatReference method, of class Website.
     */
    @Test
    public void testFormatReference() {
        System.out.println("formatReference");
        Website instance = null;
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

