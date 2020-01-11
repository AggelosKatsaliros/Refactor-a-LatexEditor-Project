package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager;

class DisableVersionsManagementCommandTest {
	private DocumentManager documentManager = new DocumentManager();
	private LatexEditorController latexEditorController = new LatexEditorController();
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController.getVersionsManager());
	private EditCommand editCommand = new EditCommand(latexEditorController.getVersionsManager());
	private DisableVersionsManagementCommand disableCommand = new DisableVersionsManagementCommand(latexEditorController.getVersionsManager());

	@Test
	void testVolatile() {
		
		latexEditorController.setType("articleTemplate");
		createCommand.execute();
		latexEditorController.setStrategy("volatile");
		
		disableCommand.execute();
		latexEditorController.setText("test edit contents\n");
		editCommand.execute();
		
		assertEquals(latexEditorController.getVersionsManager().isEnabled(), false);
		assertEquals(latexEditorController.getVersionsManager().getStrategy().getEntireHistory().size(), 0);
	}
}
