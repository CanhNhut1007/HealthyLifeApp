package com.example.sdkfacebook.tab_my_record;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.sdkfacebook.R;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "CustomExpandableListAdapter";
    private Context context;
    private List<String> expandableListHeader;
    private HashMap<String, List<Info_class>> expandableListDetail;

    public CustomExpandableListAdapter(Context context, List<String> expandableListTitle,
                                       HashMap<String, List<Info_class>> expandableListDetail){
        this.context = context;
        this.expandableListHeader = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListHeader.get(listPosition)).get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
//        final String expandedListTest = (String) getChild(listPosition, expandedListPosition);
//        if (convertView == null){
//            LayoutInflater layoutInflater = (LayoutInflater) this.context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = layoutInflater.inflate(R.layout.list_item, null);
//        }
//        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
//        expandedListTextView.setText(expandedListTest);
//        return convertView;
        if(convertView==null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
        }
        TextView expandedListTVTitle = (TextView) convertView.findViewById(R.id.expandedListItemTitle);
        TextView expandedListTVContent = (TextView) convertView.findViewById(R.id.expandedListItemContent);
        expandedListTVTitle.setText(((Info_class) getChild(listPosition, expandedListPosition)).getTitle());
        expandedListTVContent.setText(((Info_class) getChild(listPosition, expandedListPosition)).getContent());
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListHeader.get(listPosition)).size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListHeader.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListHeader.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//        String listTitle = (String) getGroup(listPosition);
//        if(convertView==null){
//            LayoutInflater layoutInflater = (LayoutInflater) this.context.
//                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = layoutInflater.inflate(R.layout.list_group, null);
//        }
//        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listTitle);
//        listTitleTextView.setTypeface(null, Typeface.BOLD);
//        listTitleTextView.setText(listTitle);
//        return convertView;
        if(convertView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_group, parent, false);
        }
        TextView listHeaderTV = (TextView) convertView.findViewById(R.id.listHeader);
        listHeaderTV.setText(expandableListHeader.get(listPosition));
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expendedListPosition) {
        return true;
    }
}

