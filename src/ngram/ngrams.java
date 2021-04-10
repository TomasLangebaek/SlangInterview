package ngram;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Set;

public class ngrams {

	/**
	 * word to process in the nGrams Algorithm
	 */
	static String word = "Slang";

	public static void main(String[] args) {

		System.out.println(Arrays.toString(calculateNgrams(word, 2)));
		System.out.println(mostFrequentNGram(word, 2));
	}

	/**
	 * @param pString String to convert to nGrams form: String
	 * @param pInt Integer N to calculate the N gram: int
	 * @return nGrams result as an Array of Strings: String[]
	 * O Time complexity: T(n) = n^2, because there is a nested for for finding all strings
	 * O Space complexity: S(n) = n, because the return array has the exact length of the needed output
	 *  and the output is at most the size of the number of characters in the word (n).
	 */
	public static String[] calculateNgrams(String pString, int pInt) {

		String[] split = pString.split("");
		
		if(split.length==1 && split[0]=="") {
			String array[] = new String[] { "Invalid calcuation, the word is empty" };
			return array;
		}

		
		//Create response array with the exact lenght of the response needed
		String[] result = new String[split.length-pInt+1];

		//Loop all valid positions in the result array
		for(int i = 0; i<split.length-pInt+1; i++) {

			String piece = "";

			//push each peace of the split array inside the reponse array
			//append each consecutive character the number of times requiered
			for(int j = i; j<pInt+i; j++) {

				piece+=split[j];

				result[i]=piece;
			}

		}

		return result;

	}

	/**
	 * 
	 * @param pString String to convert to nGrams form: String
	 * @param pInt Integer N to calculate the N gram: int
	 * @return Most repeater nGrams word: String
	 * O Time complexity: T(n) = n^2, because there is a nested for for finding all strings
	 * O Space complexity: S(n) = n, because there is a hash table with access O(1), n times
	 * Notice that there are multiple word that can meet the requirement, the out is
	 * the first one it finds.
	 */
	public static String mostFrequentNGram(String pString, int pInt) {

		Hashtable<String, Integer> hashtable = new Hashtable<String,Integer>();  

		String[] split = pString.split("");
		
		if(split.length==1 && split[0]=="") {
			String warningMessage =  "Invalid calcuation, the word is empty";
			return warningMessage;
		}

		//Create response array with the exact lenght of the response needed
		String[] result = new String[split.length-pInt+1];
		

		//Loop all valid positions in the result array
		for(int i = 0; i<split.length-pInt+1; i++) {

			String piece = "";

			//push each peace of the split array inside the reponse array
			//append each consecutive character the number of times requiered
			for(int j = i; j<pInt+i; j++) {

				piece+=split[j];

				result[i]=piece;

			}

		}

		//Add 1 to each value if its reapeated in the array of Ngrams words
		for(int i = 0; i<result.length; i++) {

			hashtable.put(result[i], hashtable.containsKey(result[i]) ? (hashtable.get(result[i]) + 1) : 1);

		}

		Set<String> keys = hashtable.keySet();
		
		int max = 0;
		
		String biggestKey = "";
		
		//Find the biggest value while saving it's key by looping the hashtable
		for(String key : keys) {
			
			if(hashtable.get(key)>max) {
				max = hashtable.get(key);
				biggestKey = key;
			}

		}

		return biggestKey;

	}

}
