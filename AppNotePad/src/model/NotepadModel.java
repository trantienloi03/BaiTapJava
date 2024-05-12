package model;

public class NotepadModel {
	private String file;
	private String content;
	public NotepadModel() {
		this.file = "";
		this.content = "";
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
