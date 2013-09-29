package se.slide.sgu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import se.slide.sgu.db.DatabaseManager;
import se.slide.sgu.model.Content;

import java.util.List;

public class AdFreeContentFragment extends Fragment {
    
    ListView mListview;
    ImageButton mPlayButton;
    ContentAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.fragment_adfreecontent, null);
        
        mListview = (ListView) view.findViewById(android.R.id.list);
        mListview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Toast.makeText(view.getContext(), "Click!", Toast.LENGTH_SHORT).show();
            }
        });
        
        View footerView =  inflater.inflate(R.layout.footer, null, false);
        mListview.addFooterView(footerView);
        
        //LinearLayout playerLinearLayout = (LinearLayout) view.findViewById(R.id.player_linearlayout);
        //playerLinearLayout.setBackground(new ColorDrawable(Color.parseColor("#aa000000")));
        
        /*
        mPlayButton = (ImageButton) view.findViewById(R.id.playButton);
        mPlayButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Click!", Toast.LENGTH_SHORT).show();
            }
        });
        */
        
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        updateAdapter();
    }
    
    public void updateAdapter() {
        List<Content> listOfContent = DatabaseManager.getInstance().getAllContents();
        mAdapter = new ContentAdapter(getActivity(), R.layout.list_item_card, listOfContent);
        mListview.setAdapter(mAdapter);
    }
}
