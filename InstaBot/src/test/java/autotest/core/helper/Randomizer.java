package autotest.core.helper;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Randomizer {
    private static final Logger logger = Logger.getLogger("logging");

    private static Random rand;

    public static int randInt() {
        try{
            rand = SecureRandom.getInstanceStrong();
        }catch (NoSuchAlgorithmException e){
            logger.log(Level.INFO, "getInstanceStrong method not found", e);
        }
        int upperBound = 55;
        int randomNumber = rand.nextInt(upperBound) + 1;
        return randomNumber;
    }//--возвращает случайную цифру в диапазоне от 1 до 56 включительно.
    public static String randChar() {
        try{
            rand = SecureRandom.getInstanceStrong();
        }catch (NoSuchAlgorithmException e){
            logger.log(Level.INFO, "getInstanceStrong method not found", e);
        }
        int upperBound = 25;
        int letterASCII = 97 + rand.nextInt(upperBound);
        char letter = (char)letterASCII;
        return Character.toString(letter);
    }//--возвращает случайную букву английского алфавита нижнего регистра.
}
