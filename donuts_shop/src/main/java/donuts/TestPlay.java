package donuts;

import java.util.List;

import dao.ProductDao;

public class TestPlay {

	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		List<Product> pList = dao.retrieveProductInfoAll();
		
		for (Product p : pList) {
			System.out.println(p.toString());
		}
	}

}
