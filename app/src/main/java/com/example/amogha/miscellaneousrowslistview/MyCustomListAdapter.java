package com.example.amogha.miscellaneousrowslistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by AMOGH A on 18-Dec-15.
 */
public class MyCustomListAdapter extends BaseAdapter {

    Context mContext;
    String[] mListItems;
    //Different row types. In this example we use 3
    private static final int ROW_TYPE_1 = 0;
    private static final int ROW_TYPE_2 = 1;
    private static final int ROW_TYPE_3 = 2;
    int mRowType;

    MyCustomListAdapter(Context context, String[] items) {
        mContext = context;
        mListItems = items;
    }

    @Override
    public int getCount() {
        return mListItems.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            switch (type) {
                case ROW_TYPE_1:
                    convertView = inflater.inflate(R.layout.row_type_1,
                            parent, false);
                    TextView type1Text = (TextView) convertView.findViewById(R.id.type_1_text);
                    type1Text.setText(mListItems[position]);
                    break;
                case ROW_TYPE_2:
                    convertView = inflater.inflate(R.layout.row_type_2,
                            parent, false);
                    TextView type2Text = (TextView) convertView.findViewById(R.id.type_2_text);
                    type2Text.setText(mListItems[position]);
                    break;
                case ROW_TYPE_3:
                    convertView = inflater.inflate(R.layout.row_type_3,
                            parent, false);
                    TextView type3Text = (TextView) convertView.findViewById(R.id.type_3_text);
                    type3Text.setText(mListItems[position]);
                    break;
            }
        }
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 3;//The number of different types of row that you want
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                mRowType = ROW_TYPE_1;
                break;
            case 1:
                mRowType = ROW_TYPE_2;
                break;
            case 2:
                mRowType = ROW_TYPE_3;
                break;
        }
        return mRowType;
    }
}
