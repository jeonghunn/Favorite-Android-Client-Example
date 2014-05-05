//This is source code of favorite. Copyrightⓒ. Tarks. All Rights Reserved.
package com.tarks.favorite.example;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.tarks.favorite.example.R;
import com.tarks.favorite.example.global.Global;
import com.tarks.favorite.example.page.ProfileActivity;
import com.tarks.favorite.example.page.privacy_category;

public class main extends SherlockActivity {

	// ListView
	ListView listView;
// List
	ArrayList<List> m_orders = new ArrayList<List>();
	// Define ListAdapter
	ListAdapter m_adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

       
 //Set Your Page(Community) list
        //17,18,19,20 are page number
        setList(getString(R.string.community) + "1", "Demo", 17);
        setList(getString(R.string.community) + "2", "Demo",  18);
        setList(getString(R.string.community) + "3", "Demo", 19);
        setList(getString(R.string.community) + "4", "Demo",  20);
    
       
        setListAdapter();
    }
    
    
    
    public void setList(String title, String des, int Tag){
    	List p1 = new List( title, des,  Tag);
		m_orders.add(p1);
		
    }
    
	public void setListAdapter() {
		listView = (ListView) findViewById(R.id.listView1);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				

				ListAdapter ca = (ListAdapter) arg0
						.getAdapter();
				List ls = (List) ca.getItem(arg2);
				

				 Intent intent = new Intent(main.this, ProfileActivity.class);
				 intent.putExtra("member_srl", String.valueOf(ls.getTag()));
					startActivity(intent);

			}
		});
		
		// listView.setOnScrollListener(this);
		m_adapter = new ListAdapter(this, R.layout.list2, m_orders);

		listView.setAdapter(m_adapter);

		
	}
    
	private class ListAdapter extends ArrayAdapter<List> {

		private ArrayList<List> items;

		public ListAdapter(Context context, int textViewResourceId,
				ArrayList<List> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			final List p = items.get(position);
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.list2, null);
				
			
			}
			
	
			if (p != null) {
				
			//	LinearLayout layout = (LinearLayout) v.findViewById(R.id.layoutback);
				TextView tt = (TextView) v.findViewById(R.id.title);
				TextView bt = (TextView) v.findViewById(R.id.description);
				ImageView image = (ImageView) v.findViewById(R.id.img);

			
				if (tt != null) {
					tt.setText(p.getTitle());
				}
				if (bt != null) {
					bt.setText(Global.getValue(p.getDes()));
				}
			
			}
			return v;
		}
	}

	class List {

		private String Title;
		private String Description;
		private int Tag;

		public List(String _Title, String _Description,
				int _Tag) {
			
			this.Title = _Title;
			this.Description = _Description;
			this.Tag = _Tag;
	}

	

		public String getTitle() {
			return Title;
		}

		public String getDes() {
			return Description;
		}

		
		public int getTag() {
			return Tag;
		}

		
	

	}

 	    
 	   }
    

