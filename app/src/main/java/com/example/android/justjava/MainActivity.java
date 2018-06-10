package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity
{
    int quantity = 97;

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

        int price = calculatePrice(hasCream,hasChocolate);

        String priceMessage = "Name "+nameTextt;
        priceMessage = priceMessage + "\nAdd Whipped Cream? " + hasCream;
        priceMessage = priceMessage + "\nAdd Chocolate? " + hasChocolate;
        priceMessage = priceMessage + "\nQuantity " + quantitu;
        priceMessage = priceMessage + "\nTotal is Ksh. "+ price;
        priceMessage = priceMessage + "\nThank you";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Intent");
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice(boolean cream, boolean choco) {
        int basePrice = 5;

        if (cream){
            basePrice = basePrice + 1;
        }

        if (choco){
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }
    public void increment(View view)
    {
        if (quantity < 100){
            quantity += 1;
            display(quantity);
        }
        else{
            Toast.makeText(this,"Cannot order more than 100 cups",Toast.LENGTH_SHORT).show();
            display(quantity);


        }

    }

    public void decrement(View view)
    {
        if(quantity > 1){
            quantity -= 1;
            display(quantity);
        }
        else {
            Toast.makeText(this,"Cannot order less than 1 cup",Toast.LENGTH_SHORT).show();
            display(quantity);
            display(quantity);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
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
