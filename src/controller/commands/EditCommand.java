package controller.commands;

import model.VersionsManager;

public class EditCommand extends GenerateCommands {
	
	public EditCommand(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		saveContents();
	}

	public void saveContents() {
		// TODO Auto-generated method stub

		if(versionsManager.isEnabled()) {
			versionsManager.putVersion(versionsManager.getCurrentDocument());
			versionsManager.getCurrentDocument().changeVersion();
		}
		versionsManager.getCurrentDocument().setContents(versionsManager.getText());
	}
	
}
