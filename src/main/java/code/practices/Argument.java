package code.practices;

public class Argument {
    public static final int DEFAULT_UP_LIMIT = 100;
    private int upLimit = DEFAULT_UP_LIMIT;

    public Argument(String[] rawValues) {
        parse(rawValues);
    }

    private void parse(String[] rawValues) {
        if (rawValues.length == 0) {
            return;
        }
        upLimit = Integer.parseInt(rawValues[0]);
    }

    public int getUpLimit() {
        return upLimit;
    }
}
