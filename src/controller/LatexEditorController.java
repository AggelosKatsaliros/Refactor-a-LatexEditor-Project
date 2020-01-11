package controller;

import java.util.HashMap;

import controller.commands.AddLatexCommand;
import controller.commands.Command;
import controller.commands.CommandFactory;
import model.VersionsManager;
import model.strategies.VolatileVersionsStrategy;

public class LatexEditorController{
	
	private VersionsManager versionsManager;
	private VolatileVersionsStrategy volatileVersionsStrategy = new VolatileVersionsStrategy();
	private String filename;
	private String text;
	private String type;
	private String strategy;
	
	private AddLatexCommand addLatexCommand;
	
	private HashMap<String, Command> commands;
    private String [] commandNames = new String[] {"addLatex","changeVersionsStrategy","create","disableVersionsManagement","edit",
                                                  "enableVersionsManagement","load","rollbackToPreviousVersion","save","encryption","loadEncryption"}; 
    public LatexEditorController() {
    	versionsManager = new VersionsManager(volatileVersionsStrategy);
    	setStrategy("volatile");
        CommandFactory commandFactory = new CommandFactory(versionsManager);
        commands = new HashMap<String, Command>(); 
        for(int i =0; i<commandNames.length; i++) {
            commands.put(commandNames[i],commandFactory.createCommand(commandNames[i]));
        }
    }
	
	public void enact(String command) {
		commands.get(command).execute();
	}
	
	public VersionsManager getVersionsManager() {
		return versionsManager;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
		versionsManager.updateFileName(filename);
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
		versionsManager.setText(text);
	}
	
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
		versionsManager.setStrategyName(strategy);
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
		versionsManager.setType(type);
	}
	
	public String getContents(String type, String before, String after) {
		addLatexCommand = new AddLatexCommand(versionsManager);
		return addLatexCommand.editContents(type, before, after);
	}
	
	public void setEncryptionType(String type) {
		versionsManager.setEncryptionType(type);
	}
	
}
