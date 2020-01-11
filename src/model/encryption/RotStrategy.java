package model.encryption;

import java.util.HashMap;

public class RotStrategy implements EncryptionStrategy {
	
	HashMap<Character,Character> dictionary = new HashMap<Character,Character>();
	
	private char [] letters = new char [] {'a','b','c','d','e','f','g','h','i','j','k',
											   'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
											   'A','B','C','D','E','F','G','H','I','J','K',
											   'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	public String getEncryptedText(String text) {
		
		char[] characters = new char[text.length()]; 
		
		String newText;
		
		for(int i=0; i<26; i++) {
			if((i+13)>25) {
				dictionary.put(letters[i],letters[i-13]);
			}else{
				dictionary.put(letters[i],letters[i+13]);
			}
			if(((i+26)+13)>51){
				dictionary.put(letters[i+26],letters[i+26-13]);
			}else{
				dictionary.put(letters[i+26],letters[i+26+13]);
			}
		}
		
        for (int i=0; i<text.length(); i++) { 
        	characters[i] = text.charAt(i);
        	if(dictionary.get(characters[i])!=null) {
        		characters[i] = dictionary.get(characters[i]);
        	}
        } 
        
        newText = new String(characters);
        
        
		
		return newText+"\nR";
	}
}
