import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


interface RandomEngine {
    BigInteger generateRandom(BigInteger seed);
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
        .mod(BigInteger.valueOf(2).pow(31).subtract(BigInteger.valueOf(1)));
        this.engines.put("generator263", generator263);

    }

    public static void main(String[] args) throws Exception {

        EngineGenerator handler = new EngineGenerator();
        handler.createEngines();
        int seed = 1;
        RandomGenerator r = new RandomGenerator(seed);
        r.generateSequence(handler.engines.get("generator263"), seed, 33);


   
    }


}
