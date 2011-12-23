package com.jfwang213.PullUpdateListViewDemo;

import java.util.Arrays;
import java.util.LinkedList;

import com.jfwang213.PullUpdateListViewDemo.PullUpdateListView.OnRefreshListener;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class PullUpdateListViewDemo extends ListActivity implements OnRefreshListener{
    
	private PullUpdateListView mView;
	private String[] mStrings = { "Item 1", "Item 2", "Item 3", "Item 4",
			"Item 5", "Item 6", "Item 7", "Item 8",
			"Item 9", "Item 10", "Item 11", "Item 12",
			"Item 13", "Item 14", "Item 15", "Item 16"
	};
	
	private LinkedList<String> mListItems;
	private ArrayAdapter<String> mAdatper;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mView = (PullUpdateListView)getListView();
        
        mListItems = new LinkedList<String>();
        mListItems.addAll(Arrays.asList(mStrings));

        mAdatper = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mListItems);

        setListAdapter(mAdatper);
        mView.SetRefreshListener(this);
    }

	@Override
	public void OnRefresh() {
		// TODO Auto-generated method stub
		mListItems.add("New Item " + (mListItems.size() + 1));
	}
}