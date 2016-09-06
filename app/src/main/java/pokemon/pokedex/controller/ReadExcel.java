package pokemon.pokedex.controller;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pokemon.pokedex.model.Pokedex;
import pokemon.pokedex.model.Pokemon;
import pokemon.pokedex.utils.StringUtils;

/**
 * Created by DuongLH1 on 8/11/2016.
 */
public class ReadExcel {

    Context mContext;

    public ReadExcel(Context context) {
        mContext = context;
    }

    public  Pokemon getPokemonFromExcel(int position) {
        Pokemon pokemon = new Pokemon();
        try {
            InputStream dbInputStream = mContext.getAssets().open("pokedex_5.xls",Context.MODE_WORLD_READABLE);
            Workbook workbook = Workbook.getWorkbook(dbInputStream);
            Sheet sheet = workbook.getSheet(0);
            Cell[] pokemonDetails = sheet.getRow(position);
            pokemon.setNumber(pokemonDetails[0].getContents());
            pokemon.setName(pokemonDetails[1].getContents());
            pokemon.setClassification(pokemonDetails[2].getContents());
            pokemon.setTypes(StringUtils.getArrayFromSting(pokemonDetails[3].getContents()));
            pokemon.setWeaknesses(StringUtils.getArrayFromSting(pokemonDetails[4].getContents()));
            pokemon.setCaptureRate(Integer.parseInt(pokemonDetails[5].getContents()));
            pokemon.setFleeRate(Integer.parseInt(pokemonDetails[6].getContents()));
            pokemon.setMaxCp(Integer.parseInt(pokemonDetails[7].getContents()));
            pokemon.setMaxHp(Integer.parseInt(pokemonDetails[8].getContents()));
            pokemon.setCandyToEnvole(Integer.parseInt(pokemonDetails[9].getContents()));
            pokemon.setBaseAttack(Integer.parseInt(pokemonDetails[10].getContents()));
            pokemon.setBaseDefense(Integer.parseInt(pokemonDetails[11].getContents()));
            pokemon.setBaseStamina(Integer.parseInt(pokemonDetails[12].getContents()));
            pokemon.setAvgHeight(pokemonDetails[14].getContents());
            pokemon.setAvgWeight(pokemonDetails[13].getContents());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return pokemon;
    }

    public Pokedex getPokedexFromExcel() {
        Pokedex pokedex = new Pokedex();
        try {
            InputStream dbInputStream = mContext.getAssets().open("pokedex_5.xls",Context.MODE_WORLD_READABLE);
            Workbook workbook = Workbook.getWorkbook(dbInputStream);
            Sheet sheet = workbook.getSheet(0);
            int row = sheet.getRows();
            for (int i=1; i<(row); i++) {
                Pokemon pokemon = new Pokemon();
                Cell[] pokemonDetails = sheet.getRow(i);
                if (pokemonDetails[0].getContents().equals("")) break;
                pokemon.setNumber(pokemonDetails[0].getContents());
                pokemon.setName(pokemonDetails[1].getContents());
                pokemon.setClassification(pokemonDetails[2].getContents());
                pokemon.setTypes(StringUtils.getArrayFromSting(pokemonDetails[3].getContents()));
                pokemon.setWeaknesses(StringUtils.getArrayFromSting(pokemonDetails[4].getContents()));
                pokemon.setCaptureRate(Integer.parseInt(pokemonDetails[5].getContents()));
                pokemon.setFleeRate(Integer.parseInt(pokemonDetails[6].getContents()));
                pokemon.setMaxCp(Integer.parseInt(pokemonDetails[7].getContents()));
                pokemon.setMaxHp(Integer.parseInt(pokemonDetails[8].getContents()));
                pokemon.setCandyToEnvole(Integer.parseInt(pokemonDetails[9].getContents()));
                pokemon.setBaseAttack(Integer.parseInt(pokemonDetails[10].getContents()));
                pokemon.setBaseDefense(Integer.parseInt(pokemonDetails[11].getContents()));
                pokemon.setBaseStamina(Integer.parseInt(pokemonDetails[12].getContents()));
                pokemon.setAvgHeight(pokemonDetails[14].getContents());
                pokemon.setAvgWeight(pokemonDetails[13].getContents());
                pokedex.addPokemonToPokedex(pokemon);
            }

        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pokedex;
    }
}
