package donuts;

public class Product {
	private String productCode;
	private String productName;
	private int cost;
	private int price;
	private String productDetail;
	private int productStock;
	private String imgUrl;
	
	public Product(String productCode, String productName, int cost, int price, String productDetail, int productStock,
			String imgUrl) {
		this.productCode = productCode;
		this.productName = productName;
		this.cost = cost;
		this.price = price;
		this.productDetail = productDetail;
		this.productStock = productStock;
		this.imgUrl = imgUrl;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
	}

	public int getCost() {
		return cost;
	}

	public int getPrice() {
		return price;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public int getProductStock() {
		return productStock;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", cost=" + cost + ", price="
				+ price + ", productDetail=" + productDetail + ", productStock=" + productStock + ", imgUrl=" + imgUrl
				+ "]";
	}
	
	
}
