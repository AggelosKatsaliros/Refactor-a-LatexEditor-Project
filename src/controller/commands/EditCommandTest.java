package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager;

class EditCommandTest {
	private DocumentManager documentManager = new DocumentManager();
	private LatexEditorController latexEditorController = new LatexEditorController();
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController.getVersionsManager());
	private EditCommand editCommand = new EditCommand(latexEditorController.getVersionsManager());

	@Test
	void test() {
		latexEditorController.setType("articleTemplate");
		createCommand.execute();
		
		latexEditorController.setText("test edit contents\n");
		editCommand.execute();
		String actualContents = latexEditorController.getVersionsManager().getCurrentDocument().getContents();
		
		assertEquals("test edit contents\n", actualContents);
	}

}
