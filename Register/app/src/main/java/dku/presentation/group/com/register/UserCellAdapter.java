package dku.presentation.group.com.register;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class UserCellAdapter extends ArrayAdapter {

    private final LayoutInflater inflater;
    private final Context context;
    private UserCellAdapter.ViewHolder holder;
    private final List<User> list ;


        public  UserCellAdapter(Context context , List<User> userList){
        super(context,0,userList);

        this.context = context;
        this.list = userList;
        inflater = LayoutInflater.from(context);



    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public User getItem(int position) {
        return list.get(position);
    }

//    @Override
//    public long getItemId(int position) {
//        return list.get(position).hashCode();
//    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        holder = null ;

        if(row == null){
            row=inflater.inflate(R.layout.user_detail_cell,parent,false);
            holder= new ViewHolder(row);

            holder.lblName = row.findViewById(R.id.user_name);
            holder.lblInfo = row.findViewById(R.id.user_detail);
            holder.userImage = row.findViewById(R.id.user_image);

            row.setTag(holder);

        }

        else {
            holder = (UserCellAdapter.ViewHolder) row.getTag();

        }

        User user = list.get(position);

        if(user != null){

            Log.d("ggg", "getView: "+user.getName());
            holder.lblName.setText(user.getName());
            holder.lblInfo.setText(user.geteMail() + "\n" + user.getPhone());
            holder.userImage.setImageResource( context.getResources().getIdentifier( ""+user.getImageResource(),"drawable",context.getPackageName()));

        }

        return row;
    }

    private  static class ViewHolder{
        View base;
        TextView lblName;
        TextView lblInfo;
        ImageView userImage;

        public ViewHolder(View base){
            this.base = base;
        }
    }

}
