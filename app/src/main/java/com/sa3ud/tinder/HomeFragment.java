package com.sa3ud.tinder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private static final String TAG = "MainActivity";
    private CardStackLayoutManager manager;
    private CardStackAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_home, container, false);


        CardStackView cardStackView = parentView.findViewById(R.id.card_stack_view);
        manager = new CardStackLayoutManager(getContext(), new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {
                Log.d(TAG, "onCardDragging: d=" + direction.name() + " ratio=" + ratio);
            }

            @Override
            public void onCardSwiped(Direction direction) {
                Log.d(TAG, "onCardSwiped: p=" + manager.getTopPosition() + " d=" + direction);

                if (direction == Direction.Right){
                    Toast.makeText(getContext(), "Direction Right", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Top){
                    Toast.makeText(getContext(), "Direction Top", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Left){
                    Toast.makeText(getContext(), "Direction Left", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Bottom){
                    Toast.makeText(getContext(), "Direction Bottom", Toast.LENGTH_SHORT).show();
                }

                // Paginating
                if (manager.getTopPosition() == adapter.getItemCount() - addList().size()){
                    paginate();
                }

            }

            @Override
            public void onCardRewound() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardCanceled() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardAppeared(View view, int position) {
                TextView tv = view.findViewById(R.id.item_name);
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());
            }

            @Override
            public void onCardDisappeared(View view, int position) {
                TextView tv = view.findViewById(R.id.item_name);
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());
            }
        });
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.FREEDOM);
        manager.setCanScrollHorizontal(true);
        manager.setSwipeableMethod(SwipeableMethod.Manual);
        manager.setOverlayInterpolator(new LinearInterpolator());
        adapter = new CardStackAdapter(addList());


        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);


        cardStackView.setItemAnimator(new DefaultItemAnimator());





        return parentView;
    }



    private void paginate() {
        List<ItemModel> old = adapter.getItems();
        List<ItemModel> baru = new ArrayList<>(addList());
        CardStackCallback callback = new CardStackCallback(old, baru);
        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);
        adapter.setItems(baru);
        hasil.dispatchUpdatesTo(adapter);
    }



    private List<ItemModel> addList() {
        List<ItemModel> items = new ArrayList<>();

        items.add(new ItemModel(R.drawable.sample1, "ساره", "24", "هيما"));
        items.add(new ItemModel(R.drawable.sample2, "عنود", "20", "صلاله"));
        items.add(new ItemModel(R.drawable.sample3, "خلود", "27", "صور"));
        items.add(new ItemModel(R.drawable.sample4, "مها", "19", "صحار"));
        items.add(new ItemModel(R.drawable.sample5, "كوثر", "29", "مسقط"));
        items.add(new ItemModel(R.drawable.sample3, "حور", "17", "شناص"));

        items.add(new ItemModel(R.drawable.sample1, "ساره", "24", "هيما"));
        items.add(new ItemModel(R.drawable.sample2, "عنود", "20", "صلاله"));
        items.add(new ItemModel(R.drawable.sample3, "خلود", "27", "صور"));
        items.add(new ItemModel(R.drawable.sample4, "مها", "19", "صحار"));
        items.add(new ItemModel(R.drawable.sample5, "كوثر", "29", "مسقط"));
        items.add(new ItemModel(R.drawable.sample3, "حور", "17", "شناص"));

        items.add(new ItemModel(R.drawable.sample1, "ساره", "24", "هيما"));
        items.add(new ItemModel(R.drawable.sample2, "عنود", "20", "صلاله"));
        items.add(new ItemModel(R.drawable.sample3, "خلود", "27", "صور"));
        items.add(new ItemModel(R.drawable.sample4, "مها", "19", "صحار"));
        items.add(new ItemModel(R.drawable.sample5, "كوثر", "29", "مسقط"));
        items.add(new ItemModel(R.drawable.sample3, "حور", "17", "شناص"));

        items.add(new ItemModel(R.drawable.sample1, "ساره", "24", "هيما"));
        items.add(new ItemModel(R.drawable.sample2, "عنود", "20", "صلاله"));
        items.add(new ItemModel(R.drawable.sample3, "خلود", "27", "صور"));
        items.add(new ItemModel(R.drawable.sample4, "مها", "19", "صحار"));
        items.add(new ItemModel(R.drawable.sample5, "كوثر", "29", "مسقط"));
        items.add(new ItemModel(R.drawable.sample3, "حور", "0", "شناص"));



        return items;
    }


}