package lab_6_core;

public class Check {
    int inputLength;

    public Check(int inputLength) {
        this.inputLength = inputLength;
    }

    public boolean checkLength(String[] input) {
        if (input.length != inputLength) {
            System.out.println("Wrong number of arguments! Retry!");
            return true;
        }
        return false;
    }

}