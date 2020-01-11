package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;;

class EnableVersionsManagementCommandTest {
	private DocumentManager documentManager = new DocumentManager();
	private LatexEditorController latexEditorController = new LatexEditorController();
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController.getVersionsManager());
	private EditCommand editCommand = new EditCommand(latexEditorController.getVersionsManager());
	private EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(latexEditorController.getVersionsManager());

	@Test
	void testVolatile() {
		
		
		latexEditorController.setType("articleTemplate");
		createCommand.execute();
		
		String actualContents = latexEditorController.getVersionsManager().getCurrentDocument().getContents();
		
		latexEditorController.setStrategy("volatile");
		enableCommand.execute();
		latexEditorController.setText("test edit contents\n");
		editCommand.execute();
		
		String contents = latexEditorController.getVersionsManager().getStrategy().getVersion().getContents();
		
		assertEquals(contents, actualContents);
	}
	@Test
	void testStable() {
		VersionsStrategy strategy = new StableVersionsStrategy();
		latexEditorController.getVersionsManager().setStrategy(strategy);
		
		latexEditorController.setType("articleTemplate");
		createCommand.execute();
		
		String actualContents = latexEditorController.getVersionsManager().getCurrentDocument().getContents();
		
		latexEditorController.setStrategy("stable");
		enableCommand.execute();
		latexEditorController.setText("test edit contents\n");
		editCommand.execute();
		
		String contents = strategy.getVersion().getContents();
		
		assertEquals(contents, actualContents);
	}
}
