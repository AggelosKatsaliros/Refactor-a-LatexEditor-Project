package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager; 
public class SaveEncryptCommandTest {
	private DocumentManager documentManager = new DocumentManager();
	private LatexEditorController latexEditorController = new LatexEditorController();
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController.getVersionsManager());
	private SaveEncryptCommand saveEncryptCommand = new SaveEncryptCommand(latexEditorController.getVersionsManager());
	
	
	@Test
	void test() throws IOException {
		latexEditorController.setType("articleTemplate");
		createCommand.execute();
		
		latexEditorController.setFilename("test.tex");
		latexEditorController.getVersionsManager().setEncryption("atBashStrategy");
		saveEncryptCommand.execute();
		
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream("test.tex"));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualContents = latexEditorController.getVersionsManager().getEncryptedText();
		
		assertEquals(fileContents, actualContents);
	}
	
	@Test
	void test2() {
		latexEditorController.setType("articleTemplate");
		createCommand.execute();
		
		latexEditorController.setFilename("test.tex");
		latexEditorController.getVersionsManager().setEncryption("rotStrategy");
		saveEncryptCommand.execute();
		
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream("test.tex"));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualContents = latexEditorController.getVersionsManager().getEncryptedText();
		
		assertEquals(fileContents, actualContents);
	}
}
