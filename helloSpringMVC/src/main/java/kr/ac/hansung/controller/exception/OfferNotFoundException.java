package kr.ac.hansung.controller.exception;

public class OfferNotFoundException extends RuntimeException {
    private int offerId;
    public OfferNotFoundException(int id) {
        this.offerId = id;
    }
    public int getOfferId() {
        return offerId;
    }

}
