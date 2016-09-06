package pokemon.pokedex.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pokemon.pokedex.Constants;
import pokemon.pokedex.R;
import pokemon.pokedex.model.Pokemon;
import pokemon.pokedex.utils.StringUtils;

public class DetailsFragment extends BaseFragment {

    private Pokemon mPokemon;
    private int pokemonNumber;
    private TextView tvName,tvClass,tvTypes,tvWeakness,tvAvgWeight,tvAvgHeight;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        pokemonNumber = bundle.getInt(Constants.POKEMON_NUMBER);
        Log.d(Constants.POKEMON_NUMBER, String.valueOf(pokemonNumber));
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        initialize(v);
        mPokemon = readExcel.getPokemonFromExcel(pokemonNumber);
        tvName.setText(mPokemon.getName());
        tvClass.setText(mPokemon.getClassification());
        tvTypes.setText(StringUtils.getStringFromArrayStrings(mPokemon.getTypes()));
        tvWeakness.setText(StringUtils.getStringFromArrayStrings(mPokemon.getWeaknesses()));
        tvAvgHeight.setText(mPokemon.getAvgHeight());
        tvAvgWeight.setText(mPokemon.getAvgWeight());
        return v;
    }

    private void initialize(View v) {
        tvName = (TextView) v.findViewById(R.id.tv_name);
        tvAvgHeight = (TextView) v.findViewById(R.id.tv_avg_heigt);
        tvWeakness = (TextView) v.findViewById(R.id.tv_weakness);
        tvAvgWeight = (TextView) v.findViewById(R.id.tv_avg_weight);
        tvClass = (TextView) v.findViewById(R.id.tv_class);
        tvTypes = (TextView) v.findViewById(R.id.tv_types);
    }


}
