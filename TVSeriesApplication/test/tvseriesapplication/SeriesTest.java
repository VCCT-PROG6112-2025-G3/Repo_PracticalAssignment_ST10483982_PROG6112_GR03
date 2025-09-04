/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* UNIT TESTS FOR SERIES CLASS                                                                                                           */
/* --------------------------------------------------------------------------------------------------------------------------------------*/
 
package tvseriesapplication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeriesTest {
    
    private Series series;
    
    public SeriesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        series = new Series();
        
        series.addSeriesForTest(new SeriesModel("A123", "Modern Family", 13, 200));
        series.addSeriesForTest(new SeriesModel("B456", "Stranger Things", 16, 60));
        series.addSeriesForTest(new SeriesModel("C789", "Mickey Mouse", 6, 45));
    }
    
    @After
    public void tearDown() {
    }
/*
 * --------------------------------------------------------------------------------------------------------------------------------------
 * MANDATORY UNIT TESTS
 * --------------------------------------------------------------------------------------------------------------------------------------
 * 1. testSearchSeries()   
 * 2. testSearchSeries_SeriesNotFound() 
 * 3. testUpdateSeries()  
 * 4. testDeleteSeries() 
 * 5. testDeleteSeries_SeriesNotFound() 
 * 6. testSeriesAgeRestriction_AgeValid() 
 * 7. TestSeriesAgeRestriction_SeriesAgeInValid() 
 * --------------------------------------------------------------------------------------------------------------------------------------
 */
    
    // TEST 1
    @Test
    public void testSearchSeries() {
        SeriesModel result = series.searchByID("C789");
        assertNotNull(result);
        assertEquals("C789", result.getSeriesId());
        assertEquals("Mickey Mouse", result.getSeriesName());
        assertEquals(6, result.getSeriesAge());
        assertEquals(45, result.getSeriesNumberOfEpisodes());
    }
    
    // TEST 2
    @Test
    public void testSearchSeries_SeriesNotFound(){
        assertNull(series.searchByID("Z246"));
    }
    
    // TEST 3 
    @Test
    public void testUpdateSeries() {
        // Using unit test helper method in Series class
        boolean updatedSeries = series.updateSeriesForTest("B456", "Stranger Thingzz (Updated Name)", 17, 70);
        assertTrue(updatedSeries);

        SeriesModel result = series.searchByID("B456");
        assertNotNull(result);
        assertEquals("Stranger Thingzz (Updated Name)", result.getSeriesName());
        assertEquals(17, result.getSeriesAge());
        assertEquals(70, result.getSeriesNumberOfEpisodes());
    }

    // TEST 4
    @Test
    public void testDeleteSeries() {
        // Using unit test helper method in Series class
        boolean deletedSeries = series.deleteSeriesForTest("A123");
        assertTrue(deletedSeries);
        assertNull(series.searchByID("A123"));
    }
    
    // TEST 5
    @Test
    public void testDeleteSeries_SeriesNotFound(){
        // Using an ID that cannot be found/doesn't exist "Z246"
        boolean deletedSeries = series.deleteSeriesForTest("Z246");             // Using unit test helper method in Series class
        assertFalse(deletedSeries);
        assertNotNull(series.searchByID("B456"));
    }
    
    // TEST 6
    @Test
    public void testSeriesAgeRestriction_AgeValid(){
        // Testing several values (ages) that lie within the allowed range (2-18): 2, 7, 10 and 18
        assertEquals(2, series.checkAgeRestriction("2"));
        assertEquals(7, series.checkAgeRestriction("7"));
        assertEquals(10, series.checkAgeRestriction("10"));
        assertEquals(18, series.checkAgeRestriction("18"));
    }
    
    // TEST 7
    @Test
    public void testSeriesAgeRestriction_AgeInValid(){
        // Testing several values (ages) that are in the incorrect format or are not within the allowed age restriction range (2-18)
        // The follwoing are not within the allowed age restriction range (2-18)
        assertEquals(-1, series.checkAgeRestriction("1"));                      
        assertEquals(-1, series.checkAgeRestriction("19"));                     
        // The following are not in the correct format 
        assertEquals(-1, series.checkAgeRestriction("abc"));                    // not a number                 
        assertEquals(-1, series.checkAgeRestriction(""));                       // emptry
        assertEquals(-1, series.checkAgeRestriction("   "));                    // whitespace
    }

    
/*
 * --------------------------------------------------------------------------------------------------------------------------------------
 * AUTO-GENERATED TEST STUBS (NETBEANS PROTOTYPES)
 * --------------------------------------------------------------------------------------------------------------------------------------
 * 1. testCaptureSeries()    
 * 2. testSeriesReport()
 * 3. testExitSeriesApplication()
 * 4. testCheckPositiveInt()
 * 5. testCheckAgeRestriction()
 * 6. testAddSeriesForTest()
 * 7. testUpdateSeriesForTest()
 * 8. testDeleteSeriesForTest()
 * 9. testSearchByID()
 * --------------------------------------------------------------------------------------------------------------------------------------
 */
    
    /**
     * Test of captureSeries method, of class Series.
     */
    @Test
    public void testCaptureSeries() {
        System.out.println("captureSeries");
        Series instance = new Series();
        instance.captureSeries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seriesReport method, of class Series.
     */
    @Test
    public void testSeriesReport() {
        System.out.println("seriesReport");
        Series instance = new Series();
        instance.seriesReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitSeriesApplication method, of class Series.
     */
    @Test
    public void testExitSeriesApplication() {
        System.out.println("exitSeriesApplication");
        Series instance = new Series();
        instance.exitSeriesApplication();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPositiveInt method, of class Series.
     */
    @Test
    public void testCheckPositiveInt() {
        System.out.println("checkPositiveInt");
        String userInput = "";
        Series instance = new Series();
        int expResult = 0;
        int result = instance.checkPositiveInt(userInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkAgeRestriction method, of class Series.
     */
    @Test
    public void testCheckAgeRestriction() {
        System.out.println("checkAgeRestriction");
        String userInput = "";
        Series instance = new Series();
        int expResult = 0;
        int result = instance.checkAgeRestriction(userInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSeriesForTest method, of class Series.
     */
    @Test
    public void testAddSeriesForTest() {
        System.out.println("addSeriesForTest");
        SeriesModel series = null;
        Series instance = new Series();
        instance.addSeriesForTest(series);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSeriesForTest method, of class Series.
     */
    @Test
    public void testUpdateSeriesForTest() {
        System.out.println("updateSeriesForTest");
        String id = "";
        String newName = "";
        int newAge = 0;
        int newEpisodes = 0;
        Series instance = new Series();
        boolean expResult = false;
        boolean result = instance.updateSeriesForTest(id, newName, newAge, newEpisodes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSeriesForTest method, of class Series.
     */
    @Test
    public void testDeleteSeriesForTest() {
        System.out.println("deleteSeriesForTest");
        String id = "";
        Series instance = new Series();
        boolean expResult = false;
        boolean result = instance.deleteSeriesForTest(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByID method, of class Series.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        String id = "";
        Series instance = new Series();
        SeriesModel expResult = null;
        SeriesModel result = instance.searchByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* FILE TITLE                                                                                                                            */
/* --------------------------------------------------------------------------------------------------------------------------------------*/
 