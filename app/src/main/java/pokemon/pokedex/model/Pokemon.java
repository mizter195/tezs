package pokemon.pokedex.model;

import java.util.ArrayList;

/**
 * Created by DuongLH1 on 8/11/2016.
 */
public class Pokemon {

    private String name;
    private String number;
    private String classification;
    private ArrayList<String> types;
    private ArrayList<String> weaknesses;
    private int captureRate;
    private int fleeRate;
    private int maxCp;
    private int maxHp;
    private int candyToEnvole;
    private int baseAttack;
    private int baseDefense;
    private int baseStamina;
    private String avgHeight;
    private String avgWeight;

    public Pokemon(){

    }

    private Pokemon(PokemonBuilder builder) {
        this.name = builder.name;
        this.number = builder.number;
        this.avgHeight = builder.avgHeight;
        this.avgWeight = builder.avgWeight;
        this.classification = builder.classification;
        this.types = builder.types;
        this.weaknesses = builder.weaknesses;
        this.captureRate = builder.captureRate;
        this.fleeRate = builder.fleeRate;
        this.maxCp = builder.maxCp;
        this.maxHp = builder.maxHp;
        this.candyToEnvole = builder.candyToEnvole;
        this.baseAttack = builder.baseAttack;
        this.baseDefense = builder.baseDefense;
        this.baseStamina = builder.baseStamina;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public ArrayList<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(ArrayList<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public int getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    public int getFleeRate() {
        return fleeRate;
    }

    public void setFleeRate(int fleeRate) {
        this.fleeRate = fleeRate;
    }

    public int getMaxCp() {
        return maxCp;
    }

    public void setMaxCp(int maxCp) {
        this.maxCp = maxCp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCandyToEnvole() {
        return candyToEnvole;
    }

    public void setCandyToEnvole(int candyToEnvole) {
        this.candyToEnvole = candyToEnvole;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getBaseStamina() {
        return baseStamina;
    }

    public void setBaseStamina(int baseStamina) {
        this.baseStamina = baseStamina;
    }

    public String getAvgHeight() {
        return avgHeight;
    }

    public void setAvgHeight(String avgHeight) {
        this.avgHeight = avgHeight;
    }

    public String getAvgWeight() {
        return avgWeight;
    }

    public void setAvgWeight(String avgWeight) {
        this.avgWeight = avgWeight;
    }


    public class PokemonBuilder {
        private String name;
        private String number;
        private String classification;
        private ArrayList<String> types;
        private ArrayList<String> weaknesses;
        private int captureRate;
        private int fleeRate;
        private int maxCp;
        private int maxHp;
        private int candyToEnvole;
        private int baseAttack;
        private int baseDefense;
        private int baseStamina;
        private String avgHeight;
        private String avgWeight;

        public Pokemon builder() {
            Pokemon pokemon = new Pokemon(this);
            return pokemon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getClassification() {
            return classification;
        }

        public void setClassification(String classification) {
            this.classification = classification;
        }

        public ArrayList<String> getTypes() {
            return types;
        }

        public void setTypes(ArrayList<String> types) {
            this.types = types;
        }

        public ArrayList<String> getWeaknesses() {
            return weaknesses;
        }

        public void setWeaknesses(ArrayList<String> weaknesses) {
            this.weaknesses = weaknesses;
        }

        public int getCaptureRate() {
            return captureRate;
        }

        public void setCaptureRate(int captureRate) {
            this.captureRate = captureRate;
        }

        public int getFleeRate() {
            return fleeRate;
        }

        public void setFleeRate(int fleeRate) {
            this.fleeRate = fleeRate;
        }

        public int getMaxCp() {
            return maxCp;
        }

        public void setMaxCp(int maxCp) {
            this.maxCp = maxCp;
        }

        public int getMaxHp() {
            return maxHp;
        }

        public void setMaxHp(int maxHp) {
            this.maxHp = maxHp;
        }

        public int getCandyToEnvole() {
            return candyToEnvole;
        }

        public void setCandyToEnvole(int candyToEnvole) {
            this.candyToEnvole = candyToEnvole;
        }

        public int getBaseAttack() {
            return baseAttack;
        }

        public void setBaseAttack(int baseAttack) {
            this.baseAttack = baseAttack;
        }

        public int getBaseDefense() {
            return baseDefense;
        }

        public void setBaseDefense(int baseDefense) {
            this.baseDefense = baseDefense;
        }

        public int getBaseStamina() {
            return baseStamina;
        }

        public void setBaseStamina(int baseStamina) {
            this.baseStamina = baseStamina;
        }

        public String getAvgHeight() {
            return avgHeight;
        }

        public void setAvgHeight(String avgHeight) {
            this.avgHeight = avgHeight;
        }

        public String getAvgWeight() {
            return avgWeight;
        }

        public void setAvgWeight(String avgWeight) {
            this.avgWeight = avgWeight;
        }
    }

}
