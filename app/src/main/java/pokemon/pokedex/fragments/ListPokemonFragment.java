package pokemon.pokedex.fragments;


import android.os.Bundle;
import java.util.ArrayList;
import pokemon.pokedex.Constants;
import pokemon.pokedex.R;
import pokemon.pokedex.callbacks.OnItemClickListener;
import pokemon.pokedex.model.Pokemon;


public class ListPokemonFragment extends BaseListFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(int position,ArrayList<Pokemon> searchResults) {
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.POKEMON_NUMBER, Integer.parseInt(searchResults.get(position).getNumber()));
                PokemonDetailsFragment fragment = new PokemonDetailsFragment();
                fragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.container,fragment).addToBackStack("DETAILS").commit();
            }
        });
    }
}
