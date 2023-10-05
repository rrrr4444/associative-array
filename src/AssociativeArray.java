package structures;

import static java.lang.reflect.Array.newInstance;

import structures.KeyNotFoundException;

/**
 * A basic implementation of Associative Arrays with keys of type K
 * and values of type V. Associative Arrays store key/value pairs
 * and permit you to look up values by key.
 *
 * @author Your Name Here
 * @author Samuel A. Rebelsky
 */
public class AssociativeArray<K, V> {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The default capacity of the initial array.
   */
  static final int DEFAULT_CAPACITY = 16;

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The size of the associative array (the number of key/value pairs).
   */
  int size;

  /**
   * The array of key/value pairs.
   */
  KVPair<K, V> pairs[];

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty associative array.
   */
  @SuppressWarnings({"unchecked"})
  public AssociativeArray() {
    // Creating new arrays is sometimes a PITN.
    this.pairs = (KVPair<K, V>[]) newInstance((new KVPair<K, V>()).getClass(),
            DEFAULT_CAPACITY);
    this.size = 0;
  } // AssociativeArray()

  /**
   * Create an associative array with given pairs.
   */
  public AssociativeArray(KVPair<K, V> pairs) {
    this.pairs = pairs;
    this.size = pairs.length;
  } // AssociativeArray(KVPair<K, V> pairs[])

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Create a copy of this AssociativeArray.
   */
  public AssociativeArray<K, V> clone() {
    return new AssociativeArray<K, V>(this.pairs);
  } // clone()

  /**
   * Convert the array to a string.
   */
  public String toString() {
    String arr = "{";
    for (int i = 0; i < this.size; i++) {
      arr += " " + this.pairs[i].key + ": " + this.pairs[i].value;
      if (i != (this.size - 1)) {
        arr += ","
      } // if
    } // for
    return arr + "}";
  } // toString()

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * Set the value associated with key to value. Future calls to
   * get(key) will return value.
   */
  public void set(K key, V value) {
    // STUB
  } // set(K,V)

  /**
   * Get the value associated with key.
   *
   * @throws KeyNotFoundException when the key does not appear in the associative
   *                              array.
   */
  public V get(K key) throws KeyNotFoundException {
    for (int i = 0; i < this.size; i++) {
      if (this.pairs[i].key == key) {
        return this.pairs[i].value;
      } // if
      throw new KeyNotFoundException();
    } // for
  } // get(K)

  /**
   * Determine if key appears in the associative array.
   */
  public boolean hasKey(K key) {
    for (int i = 0; i < this.size; i++) {
      if (this.pairs[i].key == key) {
        return true;
      } // if
      return false;
  } // hasKey(K)

  /**
   * Remove the key/value pair associated with a key. Future calls
   * to get(key) will throw an exception. If the key does not appear
   * in the associative array, does nothing.
   */
  public void remove(K key) {
    // STUB
  } // remove(K)

  /**
   * Determine how many values are in the associative array.
   */
  public int size() {
    return this.size;
  } // size()

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Expand the underlying array.
   */
  public void expand() {
    this.pairs = java.util.Arrays.copyOf(this.pairs, this.pairs.length * 2);
  } // expand()

  /**
   * Find the index of the first entry in `pairs` that contains key.
   * If no such entry is found, throws an exception.
   */
  public int find(K key) throws KeyNotFoundException {
    throw new KeyNotFoundException();   // STUB
  } // find(K)

} // class AssociativeArray
