package com.example.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText productNameEditText, productQuantityEditText, productIdEditText, productBuyingPriceEditText, productSellingPriceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productNameEditText = findViewById(R.id.product_name_edittext);
        productQuantityEditText = findViewById(R.id.product_quantity_edittext);
        productIdEditText = findViewById(R.id.product_id_edittext);
        productBuyingPriceEditText = findViewById(R.id.product_buying_price_edittext);
        productSellingPriceEditText = findViewById(R.id.product_selling_price_edittext);

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = productNameEditText.getText().toString().trim();
                Integer productQuantity = Integer.parseInt(productQuantityEditText.getText().toString().trim());
                String productId = productIdEditText.getText().toString().trim();
                Float productBuyingPrice = Float.parseFloat(productBuyingPriceEditText.getText().toString().trim());
                Float productSellingPrice = Float.parseFloat(productSellingPriceEditText.getText().toString().trim());

                DbHelper dbHelper = new DbHelper(MainActivity.this);
                boolean result = dbHelper.insertProduct(productName, productQuantity, productId, productBuyingPrice, productSellingPrice);

                if (result) {
                    Toast.makeText(MainActivity.this, "Product created successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to create product", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

