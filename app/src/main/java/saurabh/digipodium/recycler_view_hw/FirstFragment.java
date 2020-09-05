package saurabh.digipodium.recycler_view_hw;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

import saurabh.digipodium.recycler_view_hw.models.SuperHero;

public class FirstFragment extends Fragment {
    List<SuperHero> superHeroes;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        superHeroes = new ArrayList<>();
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));
        superHeroes.add(new SuperHero("Maria","What's up ?","https://blog.spoongraphics.co.uk/wp-content/uploads/2017/avatar/38.jpg"));



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });

        RecyclerView superheroList = view.findViewById(R.id.superheroList);
        superheroList.setLayoutManager(new LinearLayoutManager(getActivity()));
        SuperHeroAdapter adapter = new SuperHeroAdapter(getActivity(),R.layout.card_super_hero, superHeroes);
        superheroList.setAdapter(adapter);
    }

    class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.Holder>{

        private final Context c;
        private final int layout;
        private final List<SuperHero> heroes;
        private final LayoutInflater inflator;

        public SuperHeroAdapter(Context c, int layout, List<SuperHero> heroes) {
            this.c = c;
            this.layout = layout;
            this.heroes = heroes;
            inflator = LayoutInflater.from(c);
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View v= inflator.inflate(layout, parent,false);

            return new Holder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            SuperHero hero = heroes.get(position);
            holder.textName.setText(hero.textName);
            holder.textMsg.setText(hero.textMsg);
            Glide.with(c).load(hero.imageProfile).into(holder.imageProfile);
            holder.card.setTag(hero);

        }

        @Override
        public int getItemCount() {
            return superHeroes.size();
        }

        class Holder extends RecyclerView.ViewHolder{
            MaterialCardView card;
            TextView textName;
            TextView textMsg;
            ImageView imageProfile;


            public Holder(@NonNull View v) {
                super(v);
                card = v.findViewById(R.id.card);
                textName= v.findViewById(R.id.textName);
                textMsg=v.findViewById(R.id.textMsg);
                imageProfile= v.findViewById(R.id.imageProfile);

            }
        }
    }

}