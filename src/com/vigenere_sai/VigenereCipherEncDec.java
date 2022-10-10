package com.vigenere_sai;


public class VigenereCipherEncDec {
	//Matching alphabets to Numbers by default, no need of map.
	private char [] alphabetArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	public static void main(String[] args) {
		VigenereCipherEncDec vg = new VigenereCipherEncDec();
		vg.encryptText("WHENWORDSFAILSMUSICSPEAKS", "CIPHER");
	}

	
	
// We can use Hashmap to store corresponding alphabets to the numbers using this approach
// but in this case it is not needed.
	
//	public void alphabetsMatch() {
//		int counter = 1;
//		for(Character letter : alphabetArray) {
//		    alphabetToNumber.put(letter, counter);
//		    counter++;
//		}
//	}
	
	

	
	public void encryptText(String plainText, String key) {
		
	
		// Storing Plain text, key in arrays. 
		char[] plainTextArray = plainText.toCharArray();
		char[] keyArray = key.toCharArray();
		int [] plainTextToNumArray = new int[plainText.length()];
		int [] keyToNumArray = new int[key.length()];
		
		// Converting matching alphabets to numbers for both plain text and the key.
		for(int i = 0;i<plainTextArray.length;i++) { 
			for(int j=0;j<alphabetArray.length;j++) {
				
				if(plainTextArray[i] == alphabetArray[j]) {
					plainTextToNumArray[i] = j;
				}	
			}	
			}
		
		for(int i = 0;i<keyToNumArray.length;i++) {
			for(int j=0;j<alphabetArray.length;j++) {
				
				if(keyArray[i] == alphabetArray[j]) {
					keyToNumArray[i] = j;
				}	
			}	
			}
		
		// Encrypting the plain text using the given function.
		int[] encryptedArray = new int[plainText.length()];
		for(int i=0, j=0;i<plainText.length() && j<keyToNumArray.length;i++){
			if(j == 5)
			{
				j= 0;	
			}
			encryptedArray[i] = (plainTextToNumArray[i] + keyToNumArray[j]) % 26;
			j++;
		}
		
		// Converting the Numeric Cipher to Alphabets.
		char [] encryptedString = new char [plainText.length()];
		for(int i = 0;i<encryptedArray.length;i++) {
			for(int j=0;j<alphabetArray.length;j++) {
				if(encryptedArray[i] == j) {
					encryptedString[i] = alphabetArray[j];	
				}
			}	
			}
		
		//Printing the Encrypted Cipher
		for(int i=0;i<encryptedString.length;i++) {
			System.out.println(encryptedString[i]);
		}
		}
	}