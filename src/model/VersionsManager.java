package model;


import model.encryption.EncryptionStrategy;
import model.encryption.EncryptionStrategyFactory;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

public class VersionsManager {
	private boolean enabled;
	private VersionsStrategy strategy;
	private Document doc;
	private String filename;
	private String text;
	private String type;
	private String encrypted_text;
	private String strategy_name;
	
	private String encryptionType;
	
	private String confirm = "hi";
	
	public VersionsManager(VersionsStrategy versionsStrategy) {
		this.strategy = versionsStrategy;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void enable() {
		enabled = true;
	}

	public void disable() {
		enabled = false;
	}
	
	public VersionsStrategy getStrategy() {
		// TODO Auto-generated method stub
		return strategy;
	}
	
	public Document getCurrentDocument() {
		return doc;
	}
	
	public void setStrategy(VersionsStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void setCurrentVersion(Document document) {
		this.doc=document;
		//latexEditorView.setCurrentDocument(document);
	}
	
	public void  putVersion(Document document) {
		// TODO Auto-generated method stub
		strategy.putVersion(document);
	}
	
	public void setStrategyName(String strategy) {
		this.strategy_name = strategy;
	}
	
	public void enableStrategy() {
		// TODO Auto-generated method stub
		String strategyType = strategy_name;
		
		if(strategyType.equals("volatile") && strategy instanceof VolatileVersionsStrategy) {
			enable();
		}
		else if(strategyType.equals("stable") && strategy instanceof VolatileVersionsStrategy) {
			//allagh apo to ena sto allo
			VersionsStrategy newStrategy = new StableVersionsStrategy();
			newStrategy.setEntireHistory(strategy.getEntireHistory());
			strategy = newStrategy;
			enable();
		}
		else if(strategyType.equals("volatile") && strategy instanceof StableVersionsStrategy) {
			VersionsStrategy newStrategy = new VolatileVersionsStrategy();
			newStrategy.setEntireHistory(strategy.getEntireHistory());
			strategy = newStrategy;
			enable();
		}
		else if(strategyType.equals("stable") && strategy instanceof StableVersionsStrategy) {
			enable();
		}
	}

	public void changeStrategy() {
		// TODO Auto-generated method stub
		String strategyType = strategy_name;
		if(strategyType.equals("stable") && strategy instanceof VolatileVersionsStrategy) {
			VersionsStrategy newStrategy = new StableVersionsStrategy();
			newStrategy.setEntireHistory(strategy.getEntireHistory());
			strategy = newStrategy;
			enable();
		}
		else if(strategyType.equals("volatile") && strategy instanceof StableVersionsStrategy) {
			VersionsStrategy newStrategy = new VolatileVersionsStrategy();
			newStrategy.setEntireHistory(strategy.getEntireHistory());
			strategy = newStrategy;
			enable();
		}
	}

	public void rollback() {
		// TODO Auto-generated method stub
		Document temp = strategy.getVersion();
		temp = strategy.getVersion();
		if(temp != null) {
			doc = strategy.getVersion();
			strategy.removeVersion();
		}else {
			setConfirm(null);
		}
		
	}
	
	public String setEncryption(String encryptionType) {
		EncryptionStrategyFactory factory = new EncryptionStrategyFactory();
		EncryptionStrategy strategy;
		String encryptedText;
		if(encryptionType == "atBashStrategy"){
			strategy = factory.createStrategy("atBashStrategy");
			encryptedText = strategy.getEncryptedText(doc.getContents());
			encrypted_text = encryptedText;
			return encryptedText;
		}else {
			strategy = factory.createStrategy("rotStrategy");
			encryptedText = strategy.getEncryptedText(doc.getContents());
			encrypted_text=encryptedText;
			return encryptedText;
		}
		
	}
	
	public String loadEncryption(String encryptionType) {
		EncryptionStrategyFactory factory = new EncryptionStrategyFactory();
		EncryptionStrategy strategy;
		String encryptedText;
		if(encryptionType == "atBashStrategy"){
			strategy = factory.createStrategy("atBashStrategy");
			encryptedText = strategy.getEncryptedText(doc.getContents());
			return encryptedText;
		}else {
			strategy = factory.createStrategy("rotStrategy");
			encryptedText = strategy.getEncryptedText(doc.getContents());
			return encryptedText;
		}
	}
	
	public void updateFileName(String filename) {
		this.filename = filename;
	}
	
	public String getFileName() {
		return filename;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}
	
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	
	public void setType(String type) {
		this.type = type ;
		
	}
	
	public void setEncryptionType(String type) {
		this.encryptionType = type;
	}
	
	public String getEncryptionType() {
		return encryptionType;
	}
	
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	public String getConfirm() {
		return confirm;
	}
	public String getEncryptedText() {
		return encrypted_text;
	}
}
