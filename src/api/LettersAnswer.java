package api;

public enum LettersAnswer {
    A(1), B(2), C(3), D(4), E(5);


    private int number;
    private String data;



    LettersAnswer(int number) {
        this.number = number;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNumber() {
        return number;
    }

    public String getData() {
        return data;
    }

}
