package com.coderising.dp.builder;

import java.util.ArrayList;
import java.util.List;

public class TagBuilder {
	
    private String tagName; 
    private String tagValue;
    private List<TagNode> children = new ArrayList<>(); 
    
	public TagBuilder(String rootTagName){
		this.tagName = rootTagName;
	}
	
	public TagBuilder addChild(String childTagName){
		this.children.add(new TagNode(childTagName));
		return this;
	}
	public TagBuilder addSibling(String siblingTagName){
	    this.children.get(children.size() - 1).findAttribute(siblingTagName);
		
		return this;
		
	}
	public TagBuilder setAttribute(String name, String value){
		this.children.get(children.size() - 1).setAttribute(name, value);
		return this;
	}
	public TagBuilder setText(String value){
		this.tagValue = value;
		return this;
	}
	public String toXML(){
		return build().toXML();
	}
	
	private TagNode build(){
	    TagNode t = new TagNode(tagName);
	    t.setValue(tagValue);
	    t.setChildren(children);
	    return t;
	}
}
