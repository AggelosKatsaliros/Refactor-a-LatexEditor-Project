package controller.commands;

import model.VersionsManager;

public class SaveCommand extends GenerateCommands {
	
	public SaveCommand(VersionsManager versionsManager) {
		// TODO Auto-generated constructor stub
		this.versionsManager = versionsManager;
	}
	
	public void execute() {
		saveToFile();
	}
	
	public void saveToFile() {
		(versionsManager.getCurrentDocument()).save(versionsManager.getFileName());
	}

}
