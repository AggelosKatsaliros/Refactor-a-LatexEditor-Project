package controller.commands;

import model.VersionsManager;

public class SaveEncryptCommand extends GenerateCommands {

	public SaveEncryptCommand(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String encryptedText;
		String previousContents = versionsManager.getCurrentDocument().getContents();
	
		encryptedText = versionsManager.setEncryption(versionsManager.getEncryptionType());
		versionsManager.getCurrentDocument().setContents(encryptedText);
		versionsManager.getCurrentDocument().save(versionsManager.getFileName());
		
		versionsManager.getCurrentDocument().setContents(previousContents);
		
	} 

}
