package controller.commands;

import model.DocumentManager;
import model.VersionsManager;

public abstract class GenerateCommands implements Command{

	protected VersionsManager versionsManager;
	protected DocumentManager documentManager;

	@Override
	public void execute() {
		
	}

}