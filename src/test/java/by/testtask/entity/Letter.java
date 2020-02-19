package by.testtask.entity;

public  class Letter {
	User user = new User();
	private String messagesubject = "Test Letter";
	private String whom = user.getEmail();
	private String content = "Hello! This is TestLetter!";

	public Letter() {

	}

	public Letter(User user, String thema, String whom, String content) {
		super();
		this.user = user;
		this.messagesubject = thema;
		this.whom = whom;
		this.content = content;
	}

	
	public String getMessagesubject() {
		return messagesubject;
	}

	
	public void setMessagesubject(String thema) {
		this.messagesubject = thema;
	}

	
	public String getWhom() {
		return whom;
	}

	
	public void setWhom(String whom) {
		this.whom = whom;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((messagesubject == null) ? 0 : messagesubject.hashCode());
		result = prime * result + ((whom == null) ? 0 : whom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (messagesubject == null) {
			if (other.messagesubject != null)
				return false;
		} else if (!messagesubject.equals(other.messagesubject))
			return false;
		if (whom == null) {
			if (other.whom != null)
				return false;
		} else if (!whom.equals(other.whom))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Letter [thema=" + messagesubject + ", whom=" + whom + ", content=" + content + "]";
	}

}
