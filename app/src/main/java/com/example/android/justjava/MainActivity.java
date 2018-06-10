package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity
{
    int number = 0;
    int quantity = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
        EditText nameText = (EditText) findViewById(R.id.name_input);
        String nameTextt = nameText.getText().toString();

        CheckBox cream = (CheckBox) findViewById(R.id.cream);
        boolean hasCream = cream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChocolate = chocolate.isChecked();

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String quantitu = quantityTextView.getText().toString();

        int price = calculatePrice();
        String priceMessage = "Name "+nameTextt;
        priceMessage = priceMessage + "\nAdd Whipped Cream? " + hasCream;
        priceMessage = priceMessage + "\nAdd Chocolate? " + hasChocolate;
        priceMessage = priceMessage + "\nQuantity " + quantitu;
        priceMessage = priceMessage + "\nTotal is Ksh. "+ price;
        priceMessage = priceMessage + "\nThank you";
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        return  quantity * 5;
    }
    public void increment(View view)
    {
        number += 1;
        display(number);
    }

    public void decrement(View view)
    {
        number -= 1;
        display(number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.order_summury_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summury_text_view);
        priceTextView.setText(message);
    }
    /*
    private String createOrderSummary(String name, int price, boolean addWhipped, boolean addChoco){
        return "";
    }*/

}
