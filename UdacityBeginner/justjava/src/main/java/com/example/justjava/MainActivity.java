package com.example.justjava; /**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.dasha.udacitybeginner;
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.justjava.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    CheckBox cbWhippedCream;
    CheckBox cbChocolate;

    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbWhippedCream = (CheckBox) findViewById(R.id.cbWhippedCream);
        cbChocolate = (CheckBox) findViewById(R.id.cbChocolate);

        etName = (EditText) findViewById(R.id.etName);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       int price = calculatePrice();
       String message = createOrderSumary(price);
       //displayMessage(message);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.just_java_order_for) + " " + etName.getText().toString());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method calculate price of Coffee.
     */
    private int calculatePrice() {
        int basePrice = 5;
        if (cbWhippedCream.isChecked()) {
            basePrice = basePrice + 1;
        }
        if (cbChocolate.isChecked()) {
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }

    /**
     * This method creates Order Summary.
     */
    private String createOrderSumary(int price) {
        String resultMessage = getString(R.string.order_summary_name, etName.getText().toString()) +
                "\n" + getString(R.string.add_whipped_cream) + " " + cbWhippedCream.isChecked() +
                "\n" + getString(R.string.add_chocolate) + " " + cbChocolate.isChecked() +
                "\n" + getString(R.string.quantity1) + " " + quantity +
                "\n" + getString(R.string.total) + price +
                "\n" + getString(R.string.thank_you);

        return resultMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity < 100) {
            quantity++;
            displayQuantity(quantity);
        }
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity > 1) {
            quantity--;
            displayQuantity(quantity);
        }
    }
}
