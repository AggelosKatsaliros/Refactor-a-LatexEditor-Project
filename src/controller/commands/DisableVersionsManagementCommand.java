package controller.commands;

import model.VersionsManager;

public class DisableVersionsManagementCommand extends GenerateCommands {
	
	public DisableVersionsManagementCommand(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.disable();
	}

}
