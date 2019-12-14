package dku.presentation.group.com.register;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class GridImageAdapter extends BaseAdapter {

    Context context;
    List<ImagesOfGrid> images  ;
    ImageView imageView;




    public GridImageAdapter(Context context , List<ImagesOfGrid> images){
        this.context = context;
        this.images = images;
    }





    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int i) {

        return images.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        if(view == null){

            view = LayoutInflater.from(context).inflate(R.layout.grid_cell,null);
            imageView = view.findViewById(R.id.grid_image);

            if(images.get(position).isChecked() == false){

                imageView.setImageResource(images.get(position).getName());
            }

            else {

                imageView.setBackgroundResource(images.get(position).getName());
                imageView.setImageResource(R.drawable.checked);
            }







        }
        return view;
    }




    public void changeImage(int position, int image){
        if(position >= 0 && position < images.size()){

            this.imageView.setImageResource(0);
            Log.d("ggg", "changeImage: "+  images.get(position));
            images.get(position);
            notifyDataSetChanged();
        }
    }

}
