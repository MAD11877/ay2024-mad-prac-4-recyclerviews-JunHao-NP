package sg.edu.np.mad.madpractical4;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{

    private ListActivity activity;
    private ArrayList<User> list_objects;
    public UserAdapter(ArrayList<User>list_objects, ListActivity activity){
        this.list_objects = list_objects;
        this.activity = activity;
    }
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
    UserViewHolder holder = new UserViewHolder(view);
    return holder;
    }
    public  void  onBindViewHolder(UserViewHolder holder, int position){
        User list_items = list_objects.get(position);
        holder.name.setText(list_items.getName());
        holder.description.setText(list_items.getDescription());
        User user = list_objects.get(position);

        char[] chars = (list_items.name).toCharArray();
        if (chars[chars.length -1] != '7')
        {
            holder.bigImage.setVisibility(View.GONE);
        }
        else{
            holder.bigImage.setVisibility(View.VISIBLE);
        }
        holder.smallImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Profile");
                builder.setMessage(user.getName());
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Intent activityName = new Intent(view.getContext(), MainActivity.class);
                        activityName.putExtra("name", holder.name.getText());
                        activityName.putExtra("description", holder.description.getText());
                        activityName.putExtra("followed", user.followed);

                        activity.startActivity(activityName);

                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    public int getItemCount(){
        return list_objects.size();
    }
}
