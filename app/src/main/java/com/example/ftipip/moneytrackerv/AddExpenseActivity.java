package com.example.ftipip.moneytrackerv;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;

import com.example.ftipip.moneytrackerv.database.models.Expenses;

@EActivity(R.layout.activity_add_expense)
public class AddExpenseActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    EditText etPrice, etName;

    @ViewById
    Spinner spCategories;

    @StringRes(R.string.title_add_expence_activity)
    String title;

    private String[] data = {"Fun", "Social", "Food", "Clothes"};

    @OptionsItem(android.R.id.home)
    void back() {
        onBackPressed();
    }

    @AfterViews
    void ready() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(title);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategories.setAdapter(adapter);

        spCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Click(R.id.add_expense_button)
    public void addExpenseButton() {

        if(!inputValidation()) {
            return;
        } else {
            Expenses expenses = new Expenses();
            expenses.setPrice(etPrice.getText().toString());
            expenses.setName(etName.getText().toString());
            expenses.insert();

            Toast.makeText(this, " " + etPrice.getText().toString() + ", "
                    + etName.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean inputValidation() {

        boolean isValid = true;

        if (etPrice.getText().toString().trim().length() == 0) {
            isValid = false;
        } else if (!etPrice.getText().toString().matches("[0-9]+")) {
            isValid = false;
        }
        if(etName.getText().toString().trim().length() == 0) {
            isValid = false;
        }

        return isValid;
    }
}
