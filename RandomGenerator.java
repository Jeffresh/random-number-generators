import java.math.BigInteger;
import java.util.ArrayList;

public class RandomGenerator{

    BigInteger seed;
    BigInteger random_generated;
    ArrayList<BigInteger> random_sequence;

    public RandomGenerator(int seed){
        this.seed = BigInteger.valueOf(seed);
        this.random_generated = BigInteger.valueOf(seed);
        this.random_sequence = new ArrayList<BigInteger>();
    }

    public RandomGenerator(){
        this.seed = BigInteger.valueOf(0);
        this.random_generated = BigInteger.valueOf(0);
        this.random_sequence = new ArrayList<BigInteger>();
    }

    public void setSeed(int seed){
        this.seed = BigInteger.valueOf(seed);
    }

    public void generateSequence(RandomEngine re, int initial_seed, int sequence_length){

        this.setSeed(initial_seed);
        for(int i = 0; i < sequence_length ; i++){
            random_sequence.add(this.random_generated);
            generateRandomNumber(re, this.random_generated);
        }

        for(BigInteger val: this.random_sequence){
            System.out.println(val);
        }

    }

    public void generateRandomNumber(RandomEngine re, BigInteger seed){
            this.random_generated = re.generateRandom(seed);
    }

}