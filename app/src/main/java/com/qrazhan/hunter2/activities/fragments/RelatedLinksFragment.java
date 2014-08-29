package com.qrazhan.hunter2.activities.fragments;



import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qrazhan.hunter2.R;
import com.qrazhan.hunter2.activities.HuntActivity;
import com.qrazhan.hunter2.classes.RelatedLink;
import com.qrazhan.hunter2.classes.RelatedLinkCard;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RelatedLinksFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class RelatedLinksFragment extends Fragment {

    @InjectView(R.id.links_card_list)
    CardListView cardListView;

    public static RelatedLinksFragment newInstance() {
        RelatedLinksFragment fragment = new RelatedLinksFragment();
        return fragment;
    }
    public RelatedLinksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_related_links, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(((HuntActivity) getActivity()).linksLoaded){
            addCards();
        }
    }

    public void addCards(){
        Log.w("RelatedLinks", "addCards called");
        HuntActivity activity = (HuntActivity) getActivity();
        ArrayList<Card> cards = new ArrayList<Card>();
        for(RelatedLink link : activity.relatedLinks){
            cards.add(new RelatedLinkCard(activity.getApplicationContext(), link));
        }
        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity().getApplicationContext(), cards);
        cardListView.setAdapter(mCardArrayAdapter);

    }


}
