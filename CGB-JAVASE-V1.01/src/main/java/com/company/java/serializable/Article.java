package com.company.java.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
public class Article implements Externalizable{
	private Integer id;//10
	private String title;
	private String content;
	private String createdTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(title);
		out.writeUTF(content);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		title=in.readUTF();
		content=in.readUTF();
	}
}