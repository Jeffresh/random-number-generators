import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface RandomEngine {
    BigInteger generateRandom(BigInteger seed);
    BigInteger generateCombinedRandom(BigInteger, seed1, seed2, seed3);
}

class EngineGenerator {

    Map <String, RandomEngine> engines ;

    public EngineGenerator(){
        engines = new HashMap<String, RandomEngine>();
    }

    public void createEngines(){

        RandomEngine generator261a = (a) -> a.multiply(BigInteger.valueOf(5))
        .mod(BigInteger.valueOf(2).pow(5));
        this.engines.put("generator261a", generator261a);

        RandomEngine generator261b = (a) -> a.multiply(BigInteger.valueOf(7))
        .mod(BigInteger.valueOf(2).pow(5));
        this.engines.put("generator261b", generator261b);

        RandomEngine generator262 = (a) -> a.multiply(BigInteger.valueOf(3))
        .mod(BigInteger.valueOf(31));
        this.engines.put("generator262", generator262);

        RandomEngine generator263 = (a) -> a.multiply(BigInteger.valueOf(7).pow(5))
        .mod(BigInteger.valueOf(2147483647));
        this.engines.put("generator263", generator263);

        RandomEngine generatorFishmanAndMoore1 = (a) -> a.multiply(BigInteger.valueOf(48271)).mod(2147483647);
        this.engines.put("generatorFishmanAndMore1", generatorFishmanAndMoore1);

        RandomEngine generatorFishmanAndMoore2 = (a) -> a.multiply(BigInteger.valueOf(69621)).mod(2147483647);
        this.engines.put("generatorFishmanAndMore2", generatorFishmanAndMoore2);

        RandomEngine generatorRandu = (a) -> a.multiply(BigInteger.valueOf(65539)).mod(2147483647);
        this.engines.put("generadorRandu", generadorRandu);
    }

    public static void main(String[] args) throws Exception {

        EngineGenerator handler = new EngineGenerator();
        handler.createEngines();
        int seed = 1;
        RandomGenerator r = new RandomGenerator(seed);
        r.getRandomSequence(handler.engines.get("generator261b"), seed, 5);

        for(BigInteger n: r.random_sequence){
            System.out.println(n);
        }
        r.reset();
        r.getIthRandomNumber(handler.engines.get("generator262"), seed, 33);


        System.out.println(r.random_ith_generated);
   
    }
    
}
