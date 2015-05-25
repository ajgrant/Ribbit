package com.example.aj.ribbit;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.List;

/**
 * Created by aj on 5/25/15.
 */
public class MessageAdapter extends ArrayAdapter<ParseObject>{

    protected Context mContext;
    protected List<ParseObject> mMessages;

    public MessageAdapter(Context context, List<ParseObject> messages) {
        super(context, R.layout.message_item,messages);
        mContext = context;
        mMessages = messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.message_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.messageIcon);
            holder.nameLabel = (TextView) convertView.findViewById(R.id.senderLabel);
            //holder.timeStamp = (TextView) convertView.findViewById(R.id.timeSent);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        ParseObject message = mMessages.get(position);
        if (message.getString(ParseConstants.KEY_FILE_TYPE).equals(ParseConstants.TYPE_IMAGE)) {
            holder.iconImageView.setImageResource(R.drawable.ic_action_picture);
        }
        else{
            holder.iconImageView.setImageResource(R.drawable.ic_action_play_over_video);
        }

            holder.nameLabel.setText(message.getString(ParseConstants.KEY_SENDER_NAME));
            //holder.timeStamp.setText(message.getString(ParseConstants.KEY_CREATED_AT));

        return convertView;
    }

    private static class ViewHolder {
        ImageView iconImageView;
        TextView nameLabel;
        TextView timeStamp;
    }

    public void refill(List<ParseObject> messages){
        mMessages.clear();
        mMessages.addAll(messages);
        notifyDataSetChanged();
    }
}
