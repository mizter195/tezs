package pokemon.pokedex.callbacks;

import java.util.ArrayList;

import pokemon.pokedex.model.Pokemon;

/**
 * Created by Papa on 28/08/2016.
 */
public interface OnItemClickListener {
    void onItemClickListener(int position, ArrayList<Pokemon> searchResults);
}
