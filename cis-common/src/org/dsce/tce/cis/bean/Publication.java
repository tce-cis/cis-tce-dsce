package org.dsce.tce.cis.bean;

public class Publication {

	private String title;
	private String primaryAuthor;
	private String coAuthors;
	private String journal;

	public Publication() {
	}

	public Publication(String title, String journal, String primaryAuthor, String coAuthors) {
		this.title = title;
		this.journal = journal;
		this.primaryAuthor = primaryAuthor;
		this.coAuthors = coAuthors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrimaryAuthor() {
		return primaryAuthor;
	}

	public void setPrimaryAuthor(String primaryAuthor) {
		this.primaryAuthor = primaryAuthor;
	}

	public String getCoAuthors() {
		return coAuthors;
	}

	public void setCoAuthors(String coAuthors) {
		this.coAuthors = coAuthors;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

}
