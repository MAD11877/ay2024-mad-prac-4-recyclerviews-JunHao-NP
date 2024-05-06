package sg.edu.np.mad.madpractical4;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
public class UserViewHolder extends  RecyclerView.ViewHolder{
    ImageView smallImage;
    TextView name;

    TextView description;

    public UserViewHolder(View itemView){
        super(itemView);
        smallImage = itemView.findViewById(R.id.id1);
        name = itemView.findViewById(R.id.Name);
        description = itemView.findViewById(R.id.Description);
    }

}
