package pokemon.pokedex.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pokemon.pokedex.R;
import pokemon.pokedex.model.Pokemon;

/**
 * Created by DuongLH1 on 8/12/2016.
 */
public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    List<Pokemon> pokemons = new ArrayList<>();
    Context context;

    public PokemonAdapter(Context context, int resource, List<Pokemon> objects) {
        super(context, resource, objects);
        pokemons = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.adapter_pokemon_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.ivAva = (ImageView) v.findViewById(R.id.iv_pokemon);
        viewHolder.tvName = (TextView) v.findViewById(R.id.tv_name);
        viewHolder.tvNumber = (TextView) v.findViewById(R.id.tv_number);
        viewHolder.tvTypes = (TextView) v.findViewById(R.id.tv_types);
        String number = pokemons.get(position).getNumber();
        int drawableResourceId = context.getResources().getIdentifier("poke_"+number, "drawable", context.getPackageName());
        viewHolder.ivAva.setImageResource(drawableResourceId);
        viewHolder.tvNumber.setText("# "+number);
        viewHolder.tvName.setText(pokemons.get(position).getName());
        if (pokemons.get(position).getTypes().size()>1) {
            viewHolder.tvTypes.setText(pokemons.get(position).getTypes().get(0) +" & "+pokemons.get(position).getTypes().get(1));
        } else viewHolder.tvTypes.setText(pokemons.get(position).getTypes().get(0));
        return v;
    }

    class ViewHolder{

        ImageView ivAva;
        TextView tvName;
        TextView tvNumber;
        TextView tvTypes;

    }
}
