package collections;

import java.io.Serializable;

/**
 * One item of product catalog.
 */
public class Item implements /*Comparable<Item>,*/ Serializable {
	private static final long serialVersionUID = 1L;

	private String code;

	private String description;

	private float price;

	public Item(String code) {
		this(code, "", 0.0f);
	}

	public Item(String code, String description, float price) {
		this.code = code;
		this.description = description;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	public int compareTo(Item o) {
		return code.compareTo(o.code);
	}

	@Override
	public String toString() {
		return code + " " + price + " " + description;
	}

	@Override
	public boolean equals(Object obj) {
		return code.equals(((Item) obj).code);
	}

	@Override
	// Nech o1 a o2 su objekty.
	// Ak plati, ze o1.equals(o2) potom musi platit
	// o1.hashCode() == o2.hashCode()
	public int hashCode() {
		//Zle zvoleny hash code
		return (int)price;

		//Dobre zvoleny hashCode
		//return code.hashCode();

		//Degenerovany hash code
		//return 1;
	}
}
