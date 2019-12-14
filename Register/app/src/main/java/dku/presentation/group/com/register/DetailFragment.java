package dku.presentation.group.com.register;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    TextView userName;
    TextView userMail;
    TextView userPhone ;
    ImageView userImage;

    private  Context context;

    private  List<User> list ;



    public DetailFragment() {
        // Required empty public constructor

    }

    public void display(int id){
        View view = getView();

        if(view != null){

            userName = view.findViewById(R.id.user_name_detail);
            userMail = view.findViewById(R.id.user_mail_detail);
            userPhone = view.findViewById(R.id.user_phone_detail);

            userImage = view.findViewById(R.id.user_image_detail);


            userName.setText(list.get(id).getName());
            userMail.setText(list.get(id).geteMail());
            userPhone.setText(list.get(id).getPhone());

            userImage.setImageResource(getResources().getIdentifier( list.get(id).getImageResource(),"drawable",view.getContext().getPackageName()));

        }
        else {
            Log.d("ggg", "display:detailfragmentgirmedi ");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        list = User.userList;


        Log.d("ggg", "onCreateView: girdi");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        //buraya gir display zimbirtisini
    }
}
