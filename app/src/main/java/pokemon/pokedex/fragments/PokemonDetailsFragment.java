package pokemon.pokedex.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pokemon.pokedex.Constants;
import pokemon.pokedex.R;
import pokemon.pokedex.model.Pokemon;


public class PokemonDetailsFragment extends BaseFragment implements View.OnClickListener {

    private Pokemon mPokemon;
    private ImageView ivDetails;
    private ImageButton ibBack,ibDown;
    private TextView tvPokemonName;
    private FrameLayout layoutBackground;
    private boolean isShow = false;
    private int pokemonNumber;

    public PokemonDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pokemonNumber = getArguments().getInt(Constants.POKEMON_NUMBER);
            mPokemon = readExcel.getPokemonFromExcel(pokemonNumber);
        }
    }

    private void setUpDetailFragment(Bundle bundle) {
        Fragment fragment = new DetailsFragment();
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().add(R.id.container_inside,fragment).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.pokemon_details_fragment, container, false);
        initialize(v);

        Bundle bundle = new Bundle();
        bundle.putInt(Constants.POKEMON_NUMBER,pokemonNumber);
        setUpDetailFragment(bundle);
        Picasso.with(activity).load(Constants.POKEMON_DETAILS_URL + String.valueOf(pokemonNumber) + ".jpg").into(ivDetails);
        tvPokemonName.setText(mPokemon.getName());
        ibBack.setOnClickListener(this);
        ibDown.setOnClickListener(this);
        return v;
    }

    private void initialize(View v) {
        ivDetails = (ImageView) v.findViewById(R.id.iv_pokemon_detail);
        tvPokemonName = (TextView) v.findViewById(R.id.tv_pokemon_name);
        ibBack = (ImageButton) v.findViewById(R.id.ib_back);
        ibDown = (ImageButton) v.findViewById(R.id.ib_down);
        layoutBackground = (FrameLayout) v.findViewById(R.id.background);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                fragmentManager.popBackStack("DETAILS", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;
            case R.id.ib_down:
                if(!isShow) {
                    layoutBackground.setVisibility(View.VISIBLE);
                    isShow = true;
                } else {
                    layoutBackground.setVisibility(View.GONE);
                    isShow = false;
                }
                break;
        }
    }
}
