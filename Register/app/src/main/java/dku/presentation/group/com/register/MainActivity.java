package dku.presentation.group.com.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Listener{

    Button addUserButton;

    private boolean mIsDualPane = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addUserButton = findViewById(R.id.add_user_button);


        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AddUserActivity.class);
                startActivity(i);

                }

        });


        View detailView = findViewById(R.id.detail_fragment);
        mIsDualPane = (detailView != null && detailView.getVisibility() == View.VISIBLE);

    }


    @Override
    public void onItemClick(int id) {

        if(mIsDualPane==true){
            DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
            detailFragment.display(id);
        }

        else {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        }
    }
}

