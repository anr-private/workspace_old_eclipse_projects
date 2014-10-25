package com.maranr.anr_list_selectable.pojo;

/**
 * A POJO that contains some properties to show in the list
 * 
 */

public class MyItem implements Comparable<MyItem> {


	private long id;
	private String caption;

	public MyItem(long id, String caption) {
		super();
		this.id = id;
		this.caption = caption;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * Comparable interface implementation
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MyItem other) {
		return (int) (id - other.getId());
	}
}

// ### end ###
