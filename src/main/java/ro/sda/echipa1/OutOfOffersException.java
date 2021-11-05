package ro.sda.echipa1;

public class OutOfOffersException extends RuntimeException {

    public OutOfOffersException(){
        super("Out of offers!");
    }
}
