import java.util.*;

/**
 * A generic hash table class with open hashing/closed addressing.
 * 
 * @author Shaun Ren
 *
 * @param <K> the type of the key value
 * @param <V> the type of the element
 */
public class HashTable<K, V> {
    	/**
    	 * A structure that associates key values with elements.
    	 *
    	 */
	private class Pair {
		K key;
		V v;
		public Pair(K k, V val) {key=k; v=val;}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object o) {
			return o!=null&&(o==this||(o.getClass()==getClass()&&((Pair)o).key.equals(key)));
		}
	}
	ArrayList<LinkedList<Pair>> table = new ArrayList<LinkedList<Pair>>();
	private static final int BUCKET_SIZE = 6;

	public HashTable() {
		// initialize BUCKET_SIZE buckets
		for (int i=0;i<BUCKET_SIZE;i++)
			table.add(new LinkedList<Pair>());
	}

	/**
	 * Gets the bucket index of the key.
	 * 
	 * @param key the key to be indexed
	 * @return the bucket index of the key
	 */
	private int getIndex(K key) {
		return Math.abs(key.hashCode())%BUCKET_SIZE;
	}

	/**
	 * Adds an element with key value into the table. Nothing is changed
	 * if an element with the key value already exists.
	 * 
	 * @param key the key value of the element to be added
	 * @param element the element to be added
	 */
	public void add(K key, V element) {
		if (!contains(key))
			table.get(getIndex(key)).add(new Pair(key,element));
	}

	/**
	 * Gets the element with the key value.
	 * 
	 * @param key the key value of the element
	 * @return The element with the specified key value, null if none exists
	 */
	public V get(K key) {
		for (Pair element : table.get(getIndex(key)))
			if (element.key.equals(key))
				return element.v;
		return null;
	}

	/**
	 * Replaces the element with the key value by a new element. Nothing is
	 * changed if the element with the specified key value does not exist.
	 * 
	 * @param key the key value of the element to be replaced
	 * @param newv the new element
	 */
	public void replace(K key, V newv) {
		for (Pair element : table.get(getIndex(key)))
			if (element.key == key) {
				element.v = newv;
				return;
			}
	}

	/**
	 * Checks if the table contains an element with the key value.
	 * 
	 * @param key the key value to be checked
	 * @return true if the table contains an element with the key value, false otherwise
	 */
	public boolean contains(K key) {
		return table.get(getIndex(key)).contains(new Pair(key,null));
	}

	/**
	 * Removes an element from the table. Nothing is changed if it does
	 * not exist.
	 * 
	 * @param key the key value of the element to be removed
	 */
	public void remove(K key) {
		table.get(getIndex(key)).remove(new Pair(key,null));
	}
}