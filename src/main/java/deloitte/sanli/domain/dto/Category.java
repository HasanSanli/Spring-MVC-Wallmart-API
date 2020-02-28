package deloitte.sanli.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


/**
 * @author hasan.sanli
 *
 * Feb 27, 2020
 */
@Data
public class Category {
	
	private String id;
	private String name;
	private String path;
	private Category[] children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Category[] getChildren() {
		return children;
	}
	public void setChildren(Category[] children) {
		this.children = children;
	}

}
