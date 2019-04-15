import java.util.*;
import java.lang.*;
import java.io.*;

class HashTable {
	private int currentCapacity;
	private int maxCapacity;
	private int collisions;
	private int maxIterations;
	private float loadFactor;
	private String[] keys;
	private String[] values;

	public HashTable(int capacity) {
		currentCapacity = 0;
		maxCapacity = capacity;
		loadFactor = 0.5;
		collisions = 0;
		maxIterations = 15;
		keys = new String[capacity];
		values = new String[capacity];
	}
	
	private int hash(String key) {
		return key.hashCode() % maxCapacity;
    }
	
	private int getCollisions() {
		return collisions;
	}
	
	public boolean isFull() {
		float load = (float)currentCapacity/maxCapacity;
		if (load >= loadFactor) {
			return true;
		}
		return false;
	}
	
	private int getNextPrime(int n) {
		for (int i = n; i < 2 * n; i++) {
			if (isPrime(i)) {
				return i;
			}
		}
		return 1;
    }
	
	public boolean isPrime(int n){
		for(int i = 2; i < Math.sqrt(n); i++){
			if (n % i == 0) {
				return false;
			}				
		}		
		return true;		
	}
	
	public void resizeHashTable(int capacity) {
		String oldKeys[] = new String[keys.length];
		oldKeys = Arrays.copyOf(keys, keys.length);
		String oldValues[] = new String[values.length];
		oldValues = Arrays.copyOf(values, values.length);
		keys = new String[capacity];
		values = new String[capacity];
		
		currentCapacity = 0;
		for (int i = 0; i < oldKeys.length; i++) {
			if (oldKeys[i] != null) {
				insertUtil(oldKeys[i], values[i]);
			}
		}
	}
	
	public void insertUtil(String key, String value) {
		if (this.isFull()) {
			maxCapacity = 2 * maxCapacity;
			maxCapacity = getNextPrime(maxCapacity);
			resizeHashTable(maxCapacity);
		}
		insert(key, value)
	}
	
	public void insert(String key, String value) {
		int pos = hash(key), index = 0;

		while (1) {
			pos = (pos + index*index) % maxCapacity;
			if (keys[pos] == null) {
				keys[pos] = key;
				values[pos] = value;
				currentCapacity++;
				return;
			}
			index++;
			collisions++;
		}
	}
	
	public String get(String key) {
		int pos = hash(key);
		
		for (int i = 0; i < maxIterations; i++) {
			pos = (pos + i*i) % maxCapacity;
			if (keys[pos] != null) {
				return values[pos];
			}
		}
		
		return null;
	}
	
	public void printHashTable() {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null) {
				System.out.println(keys[i] + " => " + values[i]);
			}
		}
	}
	
	public static void main() {
		
	}
}