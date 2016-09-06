package pokemon.pokedex.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import pokemon.pokedex.Constants;
import pokemon.pokedex.R;
import pokemon.pokedex.activities.BaseActivity;
import pokemon.pokedex.adapter.PokemonAdapter;
import pokemon.pokedex.callbacks.OnItemClickListener;
import pokemon.pokedex.model.Pokedex;
import pokemon.pokedex.model.Pokemon;

/**
 * Created by Papa on 28/08/2016.
 */
public class BaseListFragment extends BaseFragment implements View.OnClickListener{
    private ListView lvPokemon;
    private ImageView ivLogo;
    private EditText etSearch;
    private ImageButton ibSearch;
    private PokemonAdapter pokemonAdapter;
    private Pokedex pokedex;
    private ArrayList<Pokemon> searchResults;
    private boolean isSearching = false;
    OnItemClickListener onItemClickListener;

    public BaseListFragment() {
        // Required empty public constructor
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int index, int i1, int i2) {
            searchResults.clear();
            for (int i=0; i<pokedex.getPokemonList().size();i++) {
                String search = s.toString().toLowerCase();
                String name = pokedex.getPokemonList().get(i).getName();
                String number = pokedex.getPokemonList().get(i).getNumber();
                String type;
                if (pokedex.getPokemonFromPokedex(i+1).getTypes().size()>1) {
                    type = pokedex.getPokemonList().get(i).getTypes().get(0) + pokedex.getPokemonList().get(i).getTypes().get(1);
                } else type = pokedex.getPokemonList().get(i).getTypes().get(0);
                if(name.toLowerCase().contains(search)||number.toLowerCase().contains(search)||type.toLowerCase().contains(search))
                {
                    searchResults.add(pokedex.getPokemonList().get(i));
                }
            }
            pokemonAdapter.notifyDataSetChanged();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        initialize(v);
        pokedex = readExcel.getPokedexFromExcel();
        searchResults = new ArrayList<>(pokedex.getPokemonList());
        pokemonAdapter = new PokemonAdapter(activity,R.layout.adapter_pokemon_layout,searchResults);
        lvPokemon.setAdapter(pokemonAdapter);
        lvPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onItemClickListener.onItemClickListener(i,searchResults);
            }
        });
        ibSearch.setOnClickListener(this);
        etSearch.addTextChangedListener(mTextWatcher);
        activity.setOnBackPressedListener(new BaseActivity.OnBackPressedListener() {
            @Override
            public void doBack() {
                if (isSearching) {
                    etSearch.setText("");
                    etSearch.setVisibility(View.GONE);
                    ivLogo.setVisibility(View.VISIBLE);
                    ibSearch.setVisibility(View.VISIBLE);
                    isSearching = false;
                } else activity.finish();
            }
        });
        return v;
    }

    private void initialize(View v) {
        lvPokemon = (ListView) v.findViewById(R.id.lv_pokemon);
        ivLogo = (ImageView) v.findViewById(R.id.iv_logo);
        etSearch = (EditText) v.findViewById(R.id.et_search);
        ibSearch = (ImageButton) v.findViewById(R.id.ib_search);
    }


    @Override
    public void onClick(View view) {
        if (!isSearching) {
            etSearch.setVisibility(View.VISIBLE);
            ivLogo.setVisibility(View.GONE);
            ibSearch.setVisibility(View.GONE);
            isSearching = true;
        }
    }
}
