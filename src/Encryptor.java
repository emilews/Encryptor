import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.util.Arrays;

public class Encryptor {
    String key;
    String text;
    public Encryptor(String key, String text) {
        this.key = key;
        this.text = text;
    }



    /**
     * This is a simple shift encryptor for text
     * <p>
     * Note: It was done this way to not do everything
     * at the same time.
     * </p>
     * @return It works with the inherent variables, so no return.
     *
     * @since 1.0.0
     * @author Emilio Wong
     */
    public void Encrypt(){
        char[] key = this.key.toCharArray();
        char[] rawString = this.text.toCharArray();
        for (int i = 0; i <= key.length-1; i++){
            char[] newAlphabet = createNewAlphabetFromKey(key[i]);
            String encryptedString = "";
            StringBuilder sb = new StringBuilder(encryptedString);

        }
    }

    /**
     * It creates a new alphabet based on a key
     * <p>
     * Note: For every char of the key, it creates a new shifted alphabet
     * by looking for indexes in the Constants array and translating to
     * a new index in a new char[]
     * </p>
     * @return Return a new char[] with a new alphabet
     *
     * @since 1.0.0
     * @author Emilio Wong
     */

    private char[] createNewAlphabetFromKey(char c) {
        //Creates a new char[] that has the exactly same length of
        //the original alphabet char[]
        char[] newAlphabet = new char[Constants.alphabet.length];
        //Initializing the variable where c is in the Constants alphabet
        int tmp = 0;
        //A loop to find c in the Constants alphabet
        for (int i = 0; i <= newAlphabet.length-1; i++){
            //If we find c, the index i will be our tmp
            if(c == Constants.alphabet[i]){
                tmp = i;
                break;
            }
        }
        //Initializing a new variable to iterate in
        //the Constants alphabet
        int cont = 0;
        //A loop to make the shift, starting in the index tmp of
        //the new char[] and index zero in the Constants
        //alphabet
        for (int i = tmp; i <= Constants.alphabet.length-1; i++) {
            newAlphabet[i] = Constants.alphabet[cont];
            cont++;
            //If i reaches the limit of the new char[], then
            //we use j starting from zero to tmp-1 because tmp
            //has already been used  as index
            if(i == Constants.alphabet.length-1){
                for(int j = 0; j <= tmp-1; j++ ){
                    newAlphabet[j] = Constants.alphabet[cont];
                    cont++;
                }
            }
        }
        return newAlphabet;
    }
}
