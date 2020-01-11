package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;


class RollbackToPreviousVersionCommandTest {
	private DocumentManager documentManager = new DocumentManager();
	private LatexEditorController latexEditorController = new LatexEditorController();
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController.getVersionsManager());
	private EditCommand editCommand = new EditCommand(latexEditorController.getVersionsManager());
	private EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(latexEditorController.getVersionsManager());
	private RollbackToPreviousVersionCommand rollback = new RollbackToPreviousVersionCommand(latexEditorController.getVersionsManager());
	
	
	@Test
	void testStable() {
		VersionsStrategy strategy = new StableVersionsStrategy();
		latexEditorController.getVersionsManager().setStrategy(strategy);
		
		latexEditorController.setType("articleTemplate");
		//latexEditorView.setVersionsManager(versionsManager);
		createCommand.execute();
		
		String actualContents = latexEditorController.getVersionsManager().getCurrentDocument().getContents();
		
		latexEditorController.setStrategy("stable");
		enableCommand.execute();
		
		latexEditorController.setText("test edit contents\n");
		editCommand.execute();
		
		rollback.execute();
		String contents = latexEditorController.getVersionsManager().getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
}
