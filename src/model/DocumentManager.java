package model;

import java.io.File;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DocumentManager {
	
	private HashMap<String, Document> templates;
	private String [] templatesName = new String[] {"reportTemplate","bookTemplate","articleTemplate","letterTemplate","emptyTemplate"};
	Document document ;
	
	public DocumentManager() {
		templates = new HashMap<String, Document>();
		for(int i =0; i<templatesName.length; i++) {
			document = new Document();
			document.setContents(getContents(templatesName[i]));
            templates.put(templatesName[i],document);
        }
	}
	
	public Document createDocument(String type) {
		return templates.get(type).clone();
	}
	
	public Document createTemplate(String TemplateType) {
		Document document = new Document();
		if(TemplateType != "emptyTemplate"){
			document.setContents(getContents(TemplateType));
		}
		return document;
	}
	
	public String getContents(String type) {
		
		File file = new File(type +".txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        String text="";
        while(input.hasNextLine()) {
            text +=input.nextLine() +"\n";
        }
        
        input.close();
        
        return text;
	}
}
