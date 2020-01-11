package controller.commands;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager;
public class LoadEncryptCommandTest {
	private DocumentManager documentManager = new DocumentManager();
	private LatexEditorController latexEditorController = new LatexEditorController();
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController.getVersionsManager());
	private LoadEncryptCommand loadEncryptCommand = new LoadEncryptCommand(latexEditorController.getVersionsManager());
	
	@Test
	void test() {
		latexEditorController.setType("articleTemplate");
		createCommand.execute();
		
		latexEditorController.setFilename("test.tex");
		latexEditorController.getVersionsManager().setEncryption("rotStrategy");
		loadEncryptCommand.execute();
		
		String contents = "\\documentclass[11pt,twocolumn,a4paper]{article}\n\n"+

				"\\begin{document}\n"+
				"\\title{Article: How to Structure a LaTeX Document}\n"+
				"\\author{Author1 \\and Author2 \\and ...}\n"+
				"\\date{\\today}\n\n"+

				"\\maketitle\n\n"+

				"\\section{Section Title 1}\n\n"+

				"\\section{Section Title 2}\n\n"+

				"\\section{Section Title.....}\n\n"+

				"\\section{Conclusion}\n\n"+

				"\\section*{References}\n\n"+

				"\\end{document}\n";
		String actualContents = latexEditorController.getVersionsManager().getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
}
