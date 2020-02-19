import java.math.BigInteger;
import java.util.ArrayList;

public class RandomGenerator{

    BigInteger seed;
    BigInteger random_generated;
    ArrayList<BigInteger> random_sequence;

    interface RandomEngine{
        BigInteger generateRandom(BigInteger seed);
    }
    
    public RandomGenerator(int seed){
        this.seed = BigInteger.valueOf(seed);
        this.random_generated = BigInteger.valueOf(seed);
        this.random_sequence = new ArrayList<BigInteger>();
    }

    public void setSeed(int seed){
        this.seed = BigInteger.valueOf(seed);
    }

    public void generateSequence(RandomEngine re, int initial_seed, int sequence_length){

        this.setSeed(initial_seed);
        for(int i = 0; i < sequence_length ; i++){
            generateRandomNumber(re, this.random_generated);
            random_sequence.add(this.random_generated);
        }

    }

    public void generateRandomNumber(RandomEngine re, BigInteger seed){
            this.random_generated = re.generateRandom(seed);
    }

    public static void main(String[] args) {
        int seed = 1;
        RandomGenerator r = new RandomGenerator(seed);

        RandomEngine generator21ba = (a) -> a.multiply(BigInteger.valueOf(7)).
        mod(BigInteger.valueOf(2).pow(5));

        r.generateSequence(generator21ba, seed, 6);

        for(BigInteger val: r.random_sequence){
            System.out.println(val);
        }
        
    }


}