package com.example.sdkfacebook.tab_my_record;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sdkfacebook.R;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "CustomExpandableListAdapter";
    private Context context;
    EditText expandedListTVContent;

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
        if(convertView==null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
        }
        TextView expandedListTVTitle = (TextView) convertView.findViewById(R.id.expandedListItemTitle);
         expandedListTVContent = (EditText) convertView.findViewById(R.id.expandedListItemContent);
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
    public View getGroupView(final int listPosition, final boolean isExpanded, View convertView, final ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_group, parent, false);
        }
        final TextView listHeaderTV = (TextView) convertView.findViewById(R.id.listHeader);
        listHeaderTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // frag.expandandcollapse(isExpanded,groupPosition);
                if (isExpanded) ((ExpandableListView) parent).collapseGroup(listPosition);
                else ((ExpandableListView) parent).expandGroup(listPosition, true);
            }
        });
        final Button btnChange=convertView.findViewById(R.id.btn_Change);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandedListTVContent.setEnabled(true);
                Toast.makeText(context,listHeaderTV.getText().toString(),Toast.LENGTH_LONG).show();

            }
        });
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

