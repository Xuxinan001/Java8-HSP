package Data;

public class Boy {
    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }
}
