package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;


class ChangeVersionsStrategyCommandTest {
	private LatexEditorController latexEditorController = new LatexEditorController();
	private ChangeVersionsStrategyCommand changeCommand = new ChangeVersionsStrategyCommand(latexEditorController.getVersionsManager());
	
	@Test
	void testVolatile() {
		VersionsStrategy strategy = new StableVersionsStrategy();
		
		latexEditorController.setType("articleTemplate");
		latexEditorController.setStrategy("stable");
		latexEditorController.getVersionsManager().setStrategy(strategy);
		changeCommand.execute();
		
		String test = "test ok";
		if(latexEditorController.getVersionsManager().getStrategy() instanceof VolatileVersionsStrategy)
			test = "not ok";
		
		assertEquals("test ok", test);
	}
	
	@Test
	void testStable() {
		VersionsStrategy strategy = new VolatileVersionsStrategy();
		
		latexEditorController.setType("articleTemplate");
		latexEditorController.setStrategy("volatile");
		latexEditorController.getVersionsManager().setStrategy(strategy);
		changeCommand.execute();
		
		String test = "test ok";
		if(latexEditorController.getVersionsManager().getStrategy() instanceof StableVersionsStrategy)
			test = "not ok";
		
		assertEquals("test ok", test);
	}
		
}
