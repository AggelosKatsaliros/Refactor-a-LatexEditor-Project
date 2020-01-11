package controller.commands;

import java.util.HashMap;

import model.VersionsManager;

public class AddLatexCommand extends GenerateCommands {
	private EditCommand editCommand ;
	
	private HashMap<String,String> subCommands = new HashMap<String,String>();
	private String [] subCommandsNames = new String [] {"chapter","section","subsection","subsubsection",
														"enumerate","itemize","table","figure"};
	private String [] subCommandsText = new String [] {"\n\\chapter{...}"+"\n","\n\\section{...}"+"\n",
											"\n\\subsection{...}"+"\n","\n\\subsubsection{...}"+"\n",
											
											"\\begin{enumerate}\n"+"\\item ...\n"+"\\item ...\n"+"\\end{enumerate}\n",
											
											"\\begin{itemize}\n"+"\\item ...\n"+ "\\item ...\n"+"\\end{itemize}\n",
											
											"\\begin{table}\n"+"\\caption{....}\\label{...}\n"+"\\begin{tabular}{|c|c|c|}\n"+"\\hline\n"+
													"... &...&...\\\\\n"+"... &...&...\\\\\n"+"... &...&...\\\\\n"+"\\hline\n"+
													"\\end{tabular}\n"+"\\end{table}\n",
													
											"\\begin{figure}\n"+"\\includegraphics[width=...,height=...]{...}\n"+
													"\\caption{....}\\label{...}\n"+
													"\\end{figure}\n"};
	
	
	public AddLatexCommand(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
		editCommand= new EditCommand(versionsManager);
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		editCommand.saveContents();
	}
	
	public String editContents(String type,String before, String after) {
		
		String contents;
		
		for(int i=0; i<subCommandsNames.length; i++) {
			subCommands.put(subCommandsNames[i],subCommandsText[i]);
		}
		
		contents = before + subCommands.get(type) + after;
		
		return contents;
	}
	
	

}
