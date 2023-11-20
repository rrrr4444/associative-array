import org.junit.jupiter.api.Test;
import structures.AssociativeArray;
import structures.KeyNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the AssociativeArray class.
 *
 * @author Reed Colloton
 */

public class AssociativeArrayTests {
  /**
   * A test for removing a pair when it's the last element.
   */
  @Test
  public void reedCollotonEdge01() throws Exception {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<>();
    arr.set(100, 4);
    assertEquals(4, arr.get(100));
    arr.remove(100);
    assertFalse(arr.hasKey(100));
    assertEquals(arr.size(), 0);
  } // reedCollotonEdge01()

  /**
   * Make sure it works on boolean keys.
   */
  @Test
  public void reedCollotonTest01() throws Exception {
    AssociativeArray<Boolean, String> arr = new AssociativeArray<>();
    arr.set(false, "43");
    arr.set(true, "27");
    assertEquals(2, arr.size());
    assertEquals("43", arr.get(false));
    assertEquals("27", arr.get(true));
    arr.set(false, "100");
    assertEquals("100", arr.get(false));
    arr.remove(false);
    arr.remove(true);
    assertEquals(0, arr.size());
  } // reedCollotonTest01()

  /**
   * Make sure it works on boolean values.
   */
  @Test
  public void reedCollotonTest02() throws Exception {
    AssociativeArray<String, Boolean> arr = new AssociativeArray<>();
    arr.set("43", false);
    arr.set("27", true);
    assertEquals(2, arr.size());
    assertFalse(arr.get("43"));
    assertTrue(arr.get("27"));
    arr.set("27", false);
    assertFalse(arr.get("27"));
    arr.remove("27");
    arr.remove("43");
    assertEquals(0, arr.size());
  } // reedCollotonTest02()

  /**
   * Test that it handles null keys properly.
   */
  @Test
  public void nullTests() {
    AssociativeArray<String, Boolean> arr = new AssociativeArray<>();
    arr.set("43", false);
    arr.set("27", true);
    assertThrowsExactly(KeyNotFoundException.class, () -> arr.get(null));
    arr.remove(null);
    arr.set(null, null);
    assertThrowsExactly(KeyNotFoundException.class, () -> arr.get(null));
    assertFalse(arr.hasKey(null));
    assertEquals(2, arr.size());
  } // reedCollotonTest02()

} // class AssociativeArrayTests