package pokemon.pokedex.model;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by DuongLH1 on 8/12/2016.
 */
public class Pokedex {


    private ArrayList<Pokemon> pokemonList = new ArrayList<>();
    public Pokedex() {

    }

    public Pokedex(ArrayList<Pokemon> pokemons) {
        this.pokemonList = pokemons;
    }


    public void addPokemonToPokedex(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }

    public Pokemon getPokemonFromPokedex(int number) {
        return pokemonList.get(number - 1);
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
