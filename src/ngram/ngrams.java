package ngram;

import java.util.Arrays;

public class ngrams {
	
	/**
	 * word to process in the nGrams Algorithm
	 */
	static String word = "to be or not to be";

	public static void main(String[] args) {

		System.out.println(Arrays.toString(calculateNgrams(word, 2)));
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

}
