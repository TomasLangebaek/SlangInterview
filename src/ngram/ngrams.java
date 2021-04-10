package ngram;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Set;

public class ngrams {

	/**
	 * word to process in the nGrams Algorithm
	 */
	static String word = "to be or not to be";

	public static void main(String[] args) {

		System.out.println(Arrays.toString(calculateNgrams(word, 2)));
		System.out.println(mostFrequentNGram(word, 2));
	}

	/**
	 * @param pString String to convert to nGrams form: String
	 * @param pInt Integer N to calculate the N gram: int
	 * @return nGrams result as an Array of Strings: String[]
	 */
	public static String[] calculateNgrams(String pString, int pInt) {

		String[] split = pString.split("");

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
	 */
	public static String mostFrequentNGram(String pString, int pInt) {

		Hashtable<String, Integer> hashtable = new Hashtable<String,Integer>();  

		String[] split = pString.split("");

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
