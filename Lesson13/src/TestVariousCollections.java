import java.util.*;
public class TestVariousCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HashSet sss = new HashSet();
		sss.add("Mary");
		sss.add("Mary");
			
		ArrayList aaa = new ArrayList();
		
		aaa.add("Mary");
		aaa.add("Mary");
		
		
		Vector bbb = new Vector();
		
		
		HashMap hm=new HashMap();
		hm.put("customer", new Customer("John", "Smith")); 
		hm.put("order", new Order());

		
		Hashtable data = new Hashtable(2);
		
		Customer cust = new Customer("David", "Lee");
		Portfolio port = new Portfolio();
		Order ord = new Order();
		
		data.put("Customer", cust );
		data.put("Order",ord);
		data.put("Portfolio", port);
		
		int totalElement = data.size();
		Order myOrder = (Order) data.get("Order");
		
		boolean Key = data.containsKey("Costumer");
		boolean value = data.containsValue(myOrder);
	}

}
