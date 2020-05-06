package entities;

public class Category {
	private int id;
	private String name,
		description;
	boolean isActive;
	private int order;
	public Category() {}
	
	public Category(int id, String name, String description,int order,boolean isActive) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.isActive=isActive;
		this.order=order;
		
	}
	
	public boolean isActive()
	{
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive=isActive;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
