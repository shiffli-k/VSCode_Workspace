// Given a start and end number, count the number of fizz and buzz appearances in the range (inclusive).

// Numbers divisible by 3 count as a fizz.
// Numbers divisible by 5 count as a buzz.
// Numbers divisible by both 3 and 5 count as both a fizz and a buzz.
// Return an object or dictionary with the counts in the format: { fizz, buzz }.

public class FizzBuzz_Count {
    public static void main(String[] args) {
        fizz_buzz_count(1, 11);
        fizz_buzz_count(14, 41);
        fizz_buzz_count(24, 100);
        fizz_buzz_count(-635, -14);
        fizz_buzz_count(-5432, 6789);
    }

    private static FizzBuzz fizz_buzz_count(int strtVal, int endVal) {
        FizzBuzz fbz = new FizzBuzz();

        for (int eachVal = strtVal; eachVal <= endVal; eachVal++) {   
            boolean isFizz = eachVal % 3 == 0;
            boolean isBuzz = eachVal % 5 == 0;
        
            if (isFizz) fbz.incFizz();
            if (isBuzz) fbz.incBuzz();
        }

        System.out.println("Output: " + fbz);
        System.out.println("Output Record: " + new FizzBuzzRec(fbz.getFizz(), fbz.getBuzz()));
        return fbz;
    }
}

/**
 * Java 17 way
 */
record FizzBuzzRec(int fizz, int buzz) {
    FizzBuzzRec{
        if(fizz < 0 || buzz < 0)
            throw new IllegalArgumentException("Count of Fizz and Buzz should be atleast 0 ");
    }
}

/**
 * Good ol Java POJO
 */
class FizzBuzz{
    private int fizz = 0;
    private int buzz = 0;
    
    public int getFizz() {
        return fizz;
    }
    public void setFizz(int fizz) {
        this.fizz = fizz;
    }
    public int getBuzz() {
        return buzz;
    }
    public void setBuzz(int buzz) {
        this.buzz = buzz;
    }

    /**
     * Increments Fizz by 1
     */
    public void incFizz(){
        ++this.fizz;
    }
    /**
     * Increments Buzz by 1
     */
    public void incBuzz(){
        ++this.buzz;
    }
    
    @Override
    public String toString() {
        return "FizzBuzz [fizz=" + fizz + ", buzz=" + buzz + "]";
    }
    
}