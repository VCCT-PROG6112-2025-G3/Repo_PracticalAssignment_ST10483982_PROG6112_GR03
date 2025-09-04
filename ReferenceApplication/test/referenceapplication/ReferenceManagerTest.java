/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* REFERENCE MANAGER UNIT TEST (ReferenceManager.java)                                                                                    /
/* --------------------------------------------------------------------------------------------------------------------------------------*/

package referenceapplication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReferenceManagerTest {
    
    public ReferenceManagerTest() {
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
    public void testAddOneNewReference() {
        ReferenceManager manager = new ReferenceManager();
        Book book = new Book(new String[]{"Smith, J."}, 1990, "Java for Beginners", "Cape Town", "Green Publishing Group", "3rd ed.");

        boolean isAdded = manager.addNewReference(book);

        assertTrue(isAdded);
        assertEquals(1, manager.getRefCount());
        assertEquals(49, manager.getRemainingSlots());
        assertEquals(1, manager.getAllReferences().length);
    }
    
    // TEST 2 ------------------------------------------------------------------
    @Test
    public void addNewReferenceNullInput() {
        ReferenceManager manager = new ReferenceManager();
        boolean isAdded = manager.addNewReference(null);
        assertFalse(isAdded);
        assertEquals(0, manager.getRefCount());
    }
    
    // TEST 3 ------------------------------------------------------------------
    @Test
    public void sortByAuthorThenYear() {
        ReferenceManager manager = new ReferenceManager();

        manager.addNewReference(new Book(new String[]{"Sanders, Z."}, 2022, "Dictionary", "London", "Publisher 1", "5th ed."));
        manager.addNewReference(new Book(new String[]{"West, A."}, 2021, "Novel", "Johannesburg", "Publisher 2", "7th ed."));
        manager.addNewReference(new Book(new String[]{"Anderson, A."}, 2019, "Textbook", "New York", "Publisher 3", "2 ed."));

        manager.sortByAuthorThenYear();
        Reference[] list = manager.getAllReferences();

        // Expected result: Anderson(2019), Sanders(2022), West(2021)
        assertEquals("Anderson, A.", list[0].getAuthors()[0]);
        assertEquals(2019, list[0].getPublicationYear());

        assertEquals("Sanders, Z.", list[1].getAuthors()[0]);
        assertEquals(2022, list[1].getPublicationYear());

        assertEquals("West, A.", list[2].getAuthors()[0]);
        assertEquals(2021, list[2].getPublicationYear());
    }

/*
 * --------------------------------------------------------------------------------------------------------------------------------------
 * AUTO-GENERATED TEST STUBS (NETBEANS PROTOTYPES)
 * --------------------------------------------------------------------------------------------------------------------------------------
 */
   
    /**
     * Test of addNewReference method, of class ReferenceManager.
     */
    @Test
    public void testAddNewReference() {
        System.out.println("addNewReference");
        Reference ref = null;
        ReferenceManager instance = new ReferenceManager();
        boolean expResult = false;
        boolean result = instance.addNewReference(ref);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByAuthorThenYear method, of class ReferenceManager.
     */
    @Test
    public void testSortByAuthorThenYear() {
        System.out.println("sortByAuthorThenYear");
        ReferenceManager instance = new ReferenceManager();
        instance.sortByAuthorThenYear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllReferences method, of class ReferenceManager.
     */
    @Test
    public void testGetAllReferences() {
        System.out.println("getAllReferences");
        ReferenceManager instance = new ReferenceManager();
        Reference[] expResult = null;
        Reference[] result = instance.getAllReferences();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of arrayIsFull method, of class ReferenceManager.
     */
    @Test
    public void testArrayIsFull() {
        System.out.println("arrayIsFull");
        ReferenceManager instance = new ReferenceManager();
        boolean expResult = false;
        boolean result = instance.arrayIsFull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRefCount method, of class ReferenceManager.
     */
    @Test
    public void testGetRefCount() {
        System.out.println("getRefCount");
        ReferenceManager instance = new ReferenceManager();
        int expResult = 0;
        int result = instance.getRefCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRemainingSlots method, of class ReferenceManager.
     */
    @Test
    public void testGetRemainingSlots() {
        System.out.println("getRemainingSlots");
        ReferenceManager instance = new ReferenceManager();
        int expResult = 0;
        int result = instance.getRemainingSlots();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

// ---------------------------------------------------------------------------------------------------------------------------------------- //
// END OF FILE                                                                                                                              //
// ---------------------------------------------------------------------------------------------------------------------------------------- //

