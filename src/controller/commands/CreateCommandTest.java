package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager;

class CreateCommandTest {
	
	private DocumentManager documentManager = new DocumentManager();
	private LatexEditorController latexEditorController = new LatexEditorController();
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController.getVersionsManager());

	@Test
	void test1() {
		
		latexEditorController.setType("articleTemplate");
		createCommand.execute();
		
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

	@Test
	void test2() {
		
		latexEditorController.setType("letterTemplate");
		createCommand.execute();
		
		String contents = "\\documentclass{letter}\n"+
				"\\usepackage{hyperref}\n"+
				"\\signature{Sender's Name}\n"+
				"\\address{Sender's address...}\n"+
				"\\begin{document}\n\n"+

				"\\begin{letter}{Destination address....}\n"+
				"\\opening{Dear Sir or Madam:}\n\n"+

				"I am writing to you .......\n\n\n"+


				"\\closing{Yours Faithfully,}\n"+

				"\\ps\n\n"+

				"P.S. text .....\n\n"+

				"\\encl{Copyright permission form}\n\n"+

				"\\end{letter}\n"+
				"\\end{document}\n";
		String actualContents = latexEditorController.getVersionsManager().getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
	
	@Test
	void test3() {
		
		latexEditorController.setType("reportTemplate");
		createCommand.execute();
		
		String contents = "\\documentclass[11pt,a4paper]{report}\n\n"+

				"\\begin{document}\n"+
				"\\title{Report Template: How to Structure a LaTeX Document}\n"+
				"\\author{Author1 \\and Author2 \\and ...}\n"+
				"\\date{\\today}\n"+
				"\\maketitle\n\n"+

				"\\begin{abstract}\n"+
				"Your abstract goes here...\n"+
				"...\n"+
				"\\end{abstract}\n\n"+

				"\\chapter{Introduction}\n"+
				"\\section{Section Title 1}\n"+
				"\\section{Section Title 2}\n"+
				"\\section{Section Title.....}\n\n"+

				"\\chapter{....}\n\n"+

				"\\chapter{Conclusion}\n\n\n"+


				"\\chapter*{References}\n\n"+

				"\\end{document}\n";
		String actualContents = latexEditorController.getVersionsManager().getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
	@Test
	void test4() {
		
		latexEditorController.setType("bookTemplate");
		createCommand.execute();
		
		String contents = "\\documentclass[11pt,a4paper]{book}\n\n"+

				"\\begin{document}\n"+
				"\\title{Book: How to Structure a LaTeX Document}\n"+
				"\\author{Author1 \\and Author2 \\and ...}\n"+
				"\\date{\\today}\n\n"+

				"\\maketitle\n\n"+

				"\\frontmatter\n\n"+

				"\\chapter{Preface}\n"+
				"% ...\n\n"+

				"\\mainmatter\n"+
				"\\chapter{First chapter}\n"+
				"\\section{Section Title 1}\n"+
				"\\section{Section Title 2}\n\n"+

				"\\section{Section Title.....}\n\n"+

				"\\chapter{....}\n\n"+

				"\\chapter{Conclusion}\n\n"+

				"\\chapter*{References}\n\n\n"+


				"\\backmatter\n"+
				"\\chapter{Last note}\n\n"+

				"\\end{document}\n";
		String actualContents = latexEditorController.getVersionsManager().getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
	
	@Test
	void test5() {
	
		latexEditorController.setType("emptyTemplate");
		createCommand.execute();
		
		String contents = "";
		String actualContents = latexEditorController.getVersionsManager().getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
}
