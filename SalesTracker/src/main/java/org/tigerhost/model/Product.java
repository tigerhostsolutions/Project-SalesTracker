package org.tigerhost.model;

public record Product(int product_number, String product_name,
					  String product_description, String product_category,
					  double product_price) {
	@Override
	public int product_number() {
		return product_number;
	}

	@Override
	public String product_name() {
		return product_name;
	}

	@Override
	public String product_description() {
		return product_description;
	}

	@Override
	public String product_category() {
		return product_category;
	}

	@Override
	public double product_price() {
		return product_price;
	}
}//end record Product