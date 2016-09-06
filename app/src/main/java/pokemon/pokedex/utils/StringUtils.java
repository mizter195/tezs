package pokemon.pokedex.utils;

import java.util.ArrayList;

/**
 * Created by Papa on 28/08/2016.
 */
public class StringUtils {

    public static ArrayList<String> getArrayFromSting(String contents) {
        ArrayList<String> stringsArray = new ArrayList<>();
        String[] strings = contents.split("\\W+");
        for ( String string : strings) {
            stringsArray.add(string);
        }
        return stringsArray;
    }

    public static String getStringFromArrayStrings(ArrayList<String> strings) {
        String string = strings.get(0);
        for (int i=1; i<strings.size(); i++) {
            string = string + " " + strings.get(i);
        }
        return string;
    }
}
