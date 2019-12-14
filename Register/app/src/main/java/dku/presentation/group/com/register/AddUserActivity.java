package dku.presentation.group.com.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {

    EditText userName;
    EditText userEmail;
    EditText userPhone;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        userName = findViewById(R.id.get_user_name);
        userEmail = findViewById(R.id.get_user_email);
        userPhone = findViewById(R.id.get_user_phone);
        saveButton = findViewById(R.id.save_button);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!userName.equals("") && !userEmail.equals("") && !userPhone.equals("")){
                    Intent intent = new Intent(AddUserActivity.this , VerificationActivity.class);

                    intent.putExtra("name" , userName.getText().toString());
                    intent.putExtra("email",userEmail.getText().toString());
                    intent.putExtra("phone",userPhone.getText().toString());
                    Log.d("ggg", "onClick: "+userName.getText());
                    //Clear from  stack
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   startActivity(intent);

                }

                else {
                    Toast.makeText(AddUserActivity.this , "you should fill all the fields",Toast.LENGTH_SHORT);
                }

            }
        });

    }


}
