package TestPackage;

import org.testng.annotations.Test;

public class GroupsExample {

	@Test(groups = {"smoke"})
	public void loginTest() {
		System.out.println("Smoke test- Login");
	}
	
	@Test(groups = {"regression"})
	public void testAddToCart() {
		System.out.println("Regression test- Add to Cart");
	}
	
	@Test(groups = {"smoke", "regression"})
	public void testCheckout() {
		System.out.println("Smoke + Regression check count");
	}
}
