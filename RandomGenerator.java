import java.math.BigInteger;
import java.util.ArrayList;

public class RandomGenerator{

    BigInteger seed;
    BigInteger random_ith_generated;
    ArrayList<BigInteger> random_sequence;

    public RandomGenerator(int seed){

        this.seed = BigInteger.valueOf(seed);
        this.random_ith_generated = BigInteger.valueOf(seed);
        this.random_sequence = new ArrayList<BigInteger>();
    }

    public RandomGenerator(){

        this.seed = BigInteger.valueOf(0);
        this.random_ith_generated = BigInteger.valueOf(0);
        this.random_sequence = new ArrayList<BigInteger>();
    }

    public void reset(){
        this.seed = BigInteger.valueOf(0);
        this.random_ith_generated = this.seed;
        this.random_sequence = new ArrayList<BigInteger>();
    }

    public void setSeed(int seed){ this.seed = BigInteger.valueOf(seed);}

    private void processingRandoms(RandomEngine re, int initial_seed, int sequence_length, boolean get_sequence){
        this.setSeed(initial_seed);
        for(int i = 0; i < sequence_length ; i++){
            generateRandomNumber(re, this.random_ith_generated);
            if(get_sequence)
                random_sequence.add(this.random_ith_generated);
        }
    }

    public ArrayList<BigInteger> getRandomSequence(RandomEngine re, int initial_seed, 
    int sequence_length){
        this.processingRandoms(re, initial_seed,sequence_length, true);
        return random_sequence;
    }

    public BigInteger getIthRandomNumber(RandomEngine re, int initial_seed, int ith_number){
        this.processingRandoms(re, initial_seed, ith_number, false);
        return this.random_ith_generated;
    }

    private BigInteger generateRandomNumber(RandomEngine re, BigInteger seed){
        this.random_ith_generated = re.generateRandom(seed);
        return this.random_ith_generated; 
    }
    
}