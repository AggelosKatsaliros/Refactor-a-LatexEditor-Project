package model.encryption;

import java.util.HashMap;

public class EncryptionStrategyFactory {
	
private HashMap<String, EncryptionStrategy> strategies;
	
	public EncryptionStrategyFactory() {
		strategies = new HashMap<String, EncryptionStrategy>();
		strategies.put("atBashStrategy", new AtBashStrategy());
		strategies.put("rotStrategy", new RotStrategy());
	}
	public EncryptionStrategy createStrategy(String type) {
		return strategies.get(type);
	}

}
