/* --------------------------------------------------------------------------------------------------------------------------------------*/
/* REFERENCE MANAGER CLASS (ReferenceManager.java)                                                                                        /
/* --------------------------------------------------------------------------------------------------------------------------------------*/

package referenceapplication;

public class ReferenceManager {
    // Setting the fixed maximum array size/capacity (50 references)
    private static final int MAX_REFERENCES = 50;
    
    // Declaring the array of references for storage (empty slotes are initially null)
    private final Reference[] references = new Reference[MAX_REFERENCES];
    
    // Number of references stored currently
    private int refCount = 0;
    
    // Methods checks if there is space (i.e maximum references not reached) and adds the reference to the next free slot
    public boolean addNewReference(Reference ref){
        // Returns false if capacity is full or null
        if (ref == null) return false;                                          // protecting agains null inputs                                        
        if (arrayIsFull()) return false;
        references[refCount++] = ref;
        return true;                                                            // Returns true if reference was added
    }
    
    // BUBBLE SORT (With early exit optimization using a swap flag)
    public void sortByAuthorThenYear(){
        for (int pass = 0; pass < refCount -1; pass++){
            boolean swapped = false;
            
            for (int position = 0; position < refCount - pass - 1; position++){
                // Calling helper method compareReferences(refA, refB)
                if (compareReferences(references[position], references[position + 1]) > 0){
                    Reference temp = references[position];
                    references[position] = references[position + 1];
                    references[position + 1] = temp;
                    swapped = true;
                }
            }
            // already sorted (i.e no swaps occured in the entire pass) therefore early exit
            if (!swapped) return;                                               
        }
    }
    
    // Method for returning a trimmed copy of the stored references
    public Reference[] getAllReferences(){
        // Creating a new array sized exaclty to refCount 
        Reference[] result = new Reference[refCount];
        for (int index = 0; index < refCount; index++){
            // Copying each used element
            result[index] = references[index];
        }
        return result;
    }
    
    // Method used to define the sort order (alphabetical then numberical)
    private int compareReferences(Reference refA, Reference refB){
        // Comparing the authors
        int authorComparison = refA.findSortingAuthorKey().compareTo(refB.findSortingAuthorKey());
        if (authorComparison != 0) return authorComparison;
        // Comparing the publication year
        return Integer.compare(refA.getPublicationYear(), refB.getPublicationYear());
    }
    
    // HELPER AND GETTER METHODS
    public boolean arrayIsFull(){
        return refCount >= references.length;
    }
    
    public int getRefCount(){
        return refCount;
    }
    
    public int getRemainingSlots(){
        return references.length - refCount;
    }
    
}

// ---------------------------------------------------------------------------------------------------------------------------------------- //
// END OF FILE                                                                                                                              //
// ---------------------------------------------------------------------------------------------------------------------------------------- //
