package ua.com.faculty.bl;

import lombok.Getter;
import lombok.Setter;
import ua.com.faculty.entity.Faculty;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {
    List<ItemCart> cart;


    private double totalValue;
    private int sumItem;


    public Cart() {
        cart = new ArrayList<>();

        sumItem = 0;
    }

    public synchronized void addNewItemToCart (Faculty faculty) {

        boolean logic = true;

        for (ItemCart el : cart) {
            if (faculty.getId() == el.getFaculty().getId()) {
                logic = false;
            }
        }

        if (logic == true) {
            cart.add(new ItemCart(faculty));
        }
    }

    public synchronized void deleteItem (Faculty faculty) {
        for (ItemCart el : cart) {
            if (el.getFaculty().getId() == faculty.getId()) {
                cart.remove(el);
                break;
            }
        }
    }
}
