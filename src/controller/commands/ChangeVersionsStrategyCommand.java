package controller.commands;

import model.VersionsManager;

public class ChangeVersionsStrategyCommand extends GenerateCommands {
	
	public ChangeVersionsStrategyCommand(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.changeStrategy();
	}

}
