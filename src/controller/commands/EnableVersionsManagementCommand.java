package controller.commands;

import model.VersionsManager;

public class EnableVersionsManagementCommand extends GenerateCommands {
	
	public EnableVersionsManagementCommand(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.enableStrategy();
	}

}
