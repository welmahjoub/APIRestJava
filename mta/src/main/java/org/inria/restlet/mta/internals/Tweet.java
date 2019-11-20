package org.inria.restlet.mta.internals;

import java.util.Date;

public class Tweet {

	private String contenu;
	private Date datePublication;
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}
	public Tweet(String contenu, Date datePublication) {
		super();
		this.contenu = contenu;
		this.datePublication = datePublication;
	}
	
	
	@Override
	public String toString() {
	
		return contenu + " " + datePublication;
	}
	
	
	
	
}
