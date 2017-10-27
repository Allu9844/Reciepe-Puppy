package codeminds.recipepuppy.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import codeminds.recipepuppy.R;
import codeminds.recipepuppy.models.Results;


/**
 * Created by anil on 26/8/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private String formattedDate;
    private boolean isMember;
    public LinearLayout mRelativeLayout;

    public static PopupWindow mPopupWindow;

    LinearLayout layoutOfPopup;
    PopupWindow popupMessage;
    Button popupButton, insidePopupButton;
    TextView popupText;


    ArrayList<Results> scheduleData;

    public RecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public  void setSchedule(ArrayList<Results> scheduleDatas) {
        scheduleData = scheduleDatas;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.single_row_canteen_items, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {

        holder.mInte.setText(scheduleData.get(position).getIngredients());
        holder.mTitle.setText(scheduleData.get(position).getTitle());

        Picasso.with(context)
                .load(scheduleData.get(position).getThumbnail())
                .placeholder(R.drawable.logonew) //this is optional the image to display while the url image is downloading
                .error(R.drawable.logonew)         //this is also optional if some error has occurred in downloading the image this image would be displayed
                .into(holder.mimage);

    }


    @Override
    public int getItemCount() {
        return scheduleData.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle,mInte;
        public Button mBookingButton;
        public LinearLayout memberCardLinearLayout,userCardLinearLayout;
        public ImageView mimage;


        public RecyclerViewHolder(View itemView) {
            super(itemView);

            mInte=(TextView)itemView.findViewById(R.id.inte);
            mTitle = (TextView)itemView.findViewById(R.id.title);
            mimage = (ImageView)itemView.findViewById(R.id.img);


        }
    }


}