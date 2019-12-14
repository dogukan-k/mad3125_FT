package dku.presentation.group.com.register;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

import androidx.fragment.app.ListFragment;

interface Listener {
    void onItemClick(int id);
}

public class UserFragment extends ListFragment  {


    private Listener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        UserCellAdapter adapter = new UserCellAdapter(inflater.getContext(),User.userList);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context ;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //User user = User.userList.get(position);

      if(listener != null ) {
          listener.onItemClick(position);
        }









    }
}
