package ch.zhaw.easyTax.taxConsultant.model;

public enum Popularity {

    HIGH(100),
    MEDIUM(50),
    LOW(20);

    private int levelOfPop;

    Popularity(int level) {
        this.levelOfPop = level;
    }

    public int getLevelOfPop() {
        return levelOfPop;
    }
}
