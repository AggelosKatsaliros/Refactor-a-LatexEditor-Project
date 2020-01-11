package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.VersionsManager;

public class LoadEncryptCommand extends GenerateCommands {
	
	public LoadEncryptCommand(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream(versionsManager.getFileName()));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		char[] characters = new char[fileContents.length()];
		
		for (int i=0; i<fileContents.length()-2; i++) { 
        	characters[i] = fileContents.charAt(i);	
        } 
		
		String fileContentsNew = new String(characters);
		
		String decrypted = "";
		versionsManager.setText(fileContentsNew);
		versionsManager.getCurrentDocument().setContents(fileContentsNew);
		
		if(fileContents.charAt(fileContents.length()-2) == 'A') {
			decrypted = versionsManager.loadEncryption("atBashStrategy");
		}else if(fileContents.charAt(fileContents.length()-2) == 'R') {
			decrypted = versionsManager.loadEncryption("rotStrategy");
		}
		
		char[] characters_2 = new char[decrypted.length()];
		
		for (int i=0; i<decrypted.length()-1; i++) { 
        	characters_2[i] = decrypted.charAt(i);	
        } 
		
		String decryptedNew = new String(characters_2);
		
		versionsManager.setText(decryptedNew);
		versionsManager.getCurrentDocument().setContents(decryptedNew);
		
	}

}
