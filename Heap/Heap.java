//package col106.assignment3.Heap;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Vector;

public class Heap<T extends Comparable, E extends Comparable> implements HeapInterface <T, E> {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/

/*	public static void main() {
		HeapDriverCode HDC = new HeapDriverCode();
		System.setOut(HDC.fileout());
	}*/
	
	/*
	 * end code
	 */

	public E[] valueArray = (E[])new Comparable[100];
	public T[] keyArray = (T[])new Comparable[100];
	public int numElements = 0;
/*	public int maxSize = 100;*/

	// public Heap(){
	// 	valueArray = (E[])new Object[maxSize];
	// 	keyArray = (T[])new Object[maxSize]; 
	// }

	public static void main(String[] args) {
		Heap<Integer,Integer> obj = new Heap();
		obj.insert(1 , 100);
		obj.insert(2, 10);
		obj.insert(3, 30);
		obj.insert(4, 50);
		obj.insert(5, 150);
		obj.insert(6, 1);
		obj.insert(7, 3);
		obj.printHeap();
		System.out.println("Line Change");
		obj.delete(1);
		obj.printHeap();
		System.out.println("Line Change");
		obj.insert(8, 500);
		obj.printHeap();
		System.out.println("Line Change");
		obj.extractMax();
		obj.printHeap();
		System.out.println("Line Change");
		obj.increaseKey(7,70);
		obj.printHeap();
	}

	// write your code here	
	public void insert(T key, E value) {
		//write your code here
		numElements = numElements + 1;
		int k = numElements-1;
		valueArray[k] = value;
		keyArray[k] = key;
		while(true){
			if(valueArray[k].compareTo(valueArray[(k-1)/2]) > 0){
				E tempVal = valueArray[k];
				valueArray[k] = valueArray[(k-1)/2];
				valueArray[(k-1)/2] = tempVal;

				T tempKey = keyArray[k];
				keyArray[k] = keyArray[(k-1)/2];
				keyArray[(k-1)/2] = tempKey;
			}
			else{
				break;
			}
			k = (k-1)/2;
		}	
	}

	public E extractMax() {
		//write your code here
		E max = valueArray[0];
		delete(keyArray[0]);
		return max;
	}

	public void delete(T key) {
		//write your code here
		int i = 0;
		numElements--;
		while(keyArray[i].compareTo(key) != 0){
			i++;
		}

		valueArray[i] = valueArray[numElements];
		keyArray[i] = keyArray[numElements];

		while(true){

			if(valueArray[2*i+1] == null && valueArray[2*i+2] == null){
				break;
			}

			else if(valueArray[i].compareTo(valueArray[2*i + 1]) < 0 && valueArray[i].compareTo(valueArray[2*i + 2]) < 0){
				if(valueArray[2*i + 2].compareTo(valueArray[2*i + 1]) < 0){
					E tempVal = valueArray[2*i + 1];
					valueArray[2*i + 1] = valueArray[i];
					valueArray[i] = tempVal;

					T tempKey = keyArray[2*i + 1];
					keyArray[2*i + 1] = keyArray[i];
					keyArray[i] = tempKey;
					i = 2*i + 1;
				}
				else{
					E tempVal = valueArray[2*i + 2];
					valueArray[2*i + 2] = valueArray[i];
					valueArray[i] = tempVal;

					T tempKey = keyArray[2*i + 2];
					keyArray[2*i + 2] = keyArray[i];
					keyArray[i] = tempKey;
					i = 2*i + 2;
				}	
			}

			else if(valueArray[i].compareTo(valueArray[2*i + 1]) < 0 ){
				E tempVal = valueArray[2*i + 1];
				valueArray[2*i + 1] = valueArray[i];
				valueArray[i] = tempVal;

				T tempKey = keyArray[2*i + 1];
				keyArray[2*i + 1] = keyArray[i];
				keyArray[i] = tempKey;
				i = 2*i + 1;
			}

			else if( valueArray[2*i+2] != null && valueArray[i].compareTo(valueArray[2*i + 2]) < 0){
				E tempVal = valueArray[2*i + 2];
				valueArray[2*i + 2] = valueArray[i];
				valueArray[i] = tempVal;

				T tempKey = keyArray[2*i + 2];
				keyArray[2*i + 2] = keyArray[i];
				keyArray[i] = tempKey;
				i = 2*i + 2;
			}
			else{
				break;
			}

		}

	}


	public void increaseKey(T key, E value) {
		//write your code here
		int i = 0;
		while(keyArray[i] != key){
			i++;
		}
		valueArray[i] = value;

		while(true){
			if(valueArray[i].compareTo(valueArray[(i-1)/2]) > 0){
				E tempVal = valueArray[(i-1)/2];
				valueArray[(i-1)/2] = valueArray[i];
				valueArray[i] = tempVal;

				T tempKey = keyArray[(i-1)/2];
				keyArray[(i-1)/2] = keyArray[i];
				keyArray[i] = tempKey;
				i = (i-1)/2;	
			}
			else{

				if(valueArray[2*i+1] == null && valueArray[2*i+2] == null){
					break;
				}

				else if(valueArray[i].compareTo(valueArray[2*i + 1]) < 0 && valueArray[i].compareTo(valueArray[2*i + 2]) < 0){
					if(valueArray[2*i + 2].compareTo(valueArray[2*i + 1]) < 0){
						E tempVal = valueArray[2*i + 1];
						valueArray[2*i + 1] = valueArray[i];
						valueArray[i] = tempVal;

						T tempKey = keyArray[2*i + 1];
						keyArray[2*i + 1] = keyArray[i];
						keyArray[i] = tempKey;
						i = 2*i + 1;
					}
					else{
						E tempVal = valueArray[2*i + 2];
						valueArray[2*i + 2] = valueArray[i];
						valueArray[i] = tempVal;

						T tempKey = keyArray[2*i + 2];
						keyArray[2*i + 2] = keyArray[i];
						keyArray[i] = tempKey;
						i = 2*i + 2;
					}	
				}

				else if(valueArray[i].compareTo(valueArray[2*i + 1]) < 0 ){
					E tempVal = valueArray[2*i + 1];
					valueArray[2*i + 1] = valueArray[i];
					valueArray[i] = tempVal;

					T tempKey = keyArray[2*i + 1];
					keyArray[2*i + 1] = keyArray[i];
					keyArray[i] = tempKey;
					i = 2*i + 1;
				}

				else if( valueArray[2*i+2] != null && valueArray[i].compareTo(valueArray[2*i + 2]) < 0){
					E tempVal = valueArray[2*i + 2];
					valueArray[2*i + 2] = valueArray[i];
					valueArray[i] = tempVal;

					T tempKey = keyArray[2*i + 2];
					keyArray[2*i + 2] = keyArray[i];
					keyArray[i] = tempKey;
					i = 2*i + 2;
				}

				else{
					break;
				}
			}
		}	
	}


	public void printHeap() {
		int i = 0;
		while(i < numElements){
			System.out.println(keyArray[i] + " " + valueArray[i]);
			i++;
		}
		//write your code here
	}	
}
