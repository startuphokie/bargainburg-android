package com.bargainburg.android.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bargainburg.android.API.Model.Merchant;
import com.bargainburg.android.R;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: christhoma
 * Date: 10/4/13
 * Time: 8:03 PM
 */
public class ListAdapterCompanies extends BaseAdapter {

    ArrayList<Merchant> companies = new ArrayList<Merchant>();
    Context context;

    public ListAdapterCompanies(Context context, ArrayList<Merchant> companies) {
        this.companies = companies;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            view.setTag(holder);
            holder.text = (TextView) view.findViewById(R.id.list_item_text);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.text.setText(getItem(position).name);
        view.setSelected(true);
        return view;
    }

    public class ViewHolder {
        TextView text;
    }

    @Override
    public int getCount() {
        return companies.size();
    }

    @Override
    public Merchant getItem(int position) {
        return companies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
