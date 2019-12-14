package dku.presentation.group.com.register;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class VerificationActivity extends AppCompatActivity {

    String incomingName="";
    String incomingEmail="";
    String incomingPhone="";

    GridView gridView;
    Button refreshButton;

    CheckBox checkBox;
    Button verifyButton;



    List<ImagesOfGrid> images = ImagesOfGrid.getImages();



    String[] profilePhotos = {"icon01_01","icon01_02","icon01_03","icon01_04","icon01_05","icon01_06","icon01_07","icon01_08","icon01_09","icon01_10","icon01_11","icon01_12","icon01_13","icon01_14","icon01_15","icon01_16","icon01_17","icon01_18","icon01_19","icon01_20","icon01_21","icon01_22","icon01_23","icon01_24","icon01_25","icon01_26","icon01_27","icon01_28","icon01_29","icon01_30"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);


       incomingName =  getIntent().getExtras().getString("name");
       incomingEmail =  getIntent().getExtras().getString("email");
       incomingPhone = getIntent().getExtras().getString("phone");



        Log.d("ggg", "onCreate: "+incomingName);

       gridView = findViewById(R.id.gridView);
       refreshButton = findViewById(R.id.refresh_button);
       checkBox=findViewById(R.id.checkBox);
       verifyButton=findViewById(R.id.verification_button);





        //To shuffle list items in it
        Collections.shuffle(images);
        final GridImageAdapter gridImageAdapter = new GridImageAdapter(this,images);
        gridView.setAdapter(gridImageAdapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

               ImagesOfGrid image = images.get(position);

               if(image.isChecked()){
                   image.setChecked(false);


                   gridView.invalidateViews();
                   gridView.setAdapter(gridImageAdapter);


               }

               else {
                   image.setChecked(true);

                   gridView.invalidateViews();
                   gridView.setAdapter(gridImageAdapter);

               }


            }
        });



        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //To shuffle list items in it
                for(int i = 0 ; i<images.size() ; i++){
                    images.get(i).setChecked(false);
                }

                Collections.shuffle(images);
                gridView.invalidateViews();
                gridView.setAdapter(gridImageAdapter);
            }
        });


        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(checkBox.isChecked() == false){
                    final AlertDialog.Builder alertNeg = new AlertDialog.Builder(VerificationActivity.this);
                    alertNeg.setMessage("Not Verified");
                    alertNeg.setCancelable(true);
                    alertNeg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Intent intent = new Intent(VerificationActivity.this , MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);



                        }
                    });

                    AlertDialog alert = alertNeg.create();
                    alert.show();



                }

                else if(checkBox.isChecked() == true  ){
                    boolean result =false ;

                    for(int a = 0 ; a<images.size() ; a++){
                        if(images.get(a).getTag() == 0 || images.get(a).getTag() == 1 || images.get(a).getTag() == 2 || images.get(a).getTag() == 3){
                            if(images.get(a).isChecked() == false){
                                result = false ;

                                final AlertDialog.Builder alertNeg = new AlertDialog.Builder(VerificationActivity.this);
                                alertNeg.setMessage("Not Verified");
                                alertNeg.setCancelable(true);
                                alertNeg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                        Intent intent = new Intent(VerificationActivity.this , MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);



                                    }
                                });

                                AlertDialog alert = alertNeg.create();
                                alert.show();


                                break;
                            }
                            else{
                                result=true;
                            }
                        }
                    }


                        if(result == true){
                            Random rand = new Random();


                            int n = rand.nextInt(30);

                            User user = new User(incomingName,incomingEmail,incomingPhone);
                            user.setImageResource(profilePhotos[n]);

                            User.userList.add(user);

                            final AlertDialog.Builder alertNeg = new AlertDialog.Builder(VerificationActivity.this);
                            alertNeg.setMessage("Verified");
                            alertNeg.setCancelable(true);
                            alertNeg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    Intent intent = new Intent(VerificationActivity.this , MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);



                                }
                            });

                            AlertDialog alert = alertNeg.create();
                            alert.show();

                        }


                }


            }



        });





    }
}
