package business.externalinterfaces;

import java.util.List;


public interface ShoppingCart {
    Address getShippingAddress();
    Address getBillingAddress();
    CreditCard getPaymentInfo();
    List<CartItem> getCartItems();
    void setCartItems(List<CartItem> cartItems);
    double getTotalPrice();
    boolean deleteCartItem(String name);
    boolean isEmpty();
	String getCartId();

    //setters for testing
    
}
