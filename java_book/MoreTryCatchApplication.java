package com.company;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

public class MoreTryCatchApplication {
    public static void main(String[] args) {
        String input;
        char[] symbs;
        int size, index;

        input = showInputDialog(null,
                "Say size of array: ", //Text on the field Input
                "Char type", //name of the window
                QUESTION_MESSAGE);

        try{
            size = parseInt(input);
            symbs = new char[size];
            String txt = "|";
            for (int k = 0; k < size; k++) {
                symbs[k] = (char) ('A' +k); //A|B|C|D|E
                txt += symbs[k] + "|";
            }

            showMessageDialog(null, txt, "Chars from array", INFORMATION_MESSAGE);

            input=showInputDialog(null, "Input index of array: ", "Index of array", QUESTION_MESSAGE);

            index = parseInt(input);
            txt = "Index - " + index + "\nSymbol  - " + symbs[index];
            showMessageDialog(null, txt, "Symbol", INFORMATION_MESSAGE);
        }catch (NumberFormatException e){
            showMessageDialog(null, "Unfortunately here error...", "error", WARNING_MESSAGE);
        }
        catch (NegativeArraySizeException e){
            showMessageDialog(null, "Uncorectly size of array", "error while create array", ERROR_MESSAGE);
        }
        catch (ArrayIndexOutOfBoundsException e){
            showMessageDialog(null, "Are you sure? That item not exist!", "error while select item", QUESTION_MESSAGE);
        }
    }
}
