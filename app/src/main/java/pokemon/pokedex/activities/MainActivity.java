package pokemon.pokedex.activities;

import android.os.Bundle;
import pokemon.pokedex.R;
import pokemon.pokedex.fragments.ListPokemonFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        fragmentManager.beginTransaction().add(R.id.container,new ListPokemonFragment()).addToBackStack(null).commit();
    }

    private void initialize() {
    }


}
