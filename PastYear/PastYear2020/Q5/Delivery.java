package PastYear2020.Q5;

public class Delivery {

    protected final static double[] RANGE = {5.0, 15.0, 30.0};
    protected final static double[] VALUE = {2.8, 5.2, 7.0, 8.6};
    protected final String SENDER;
    protected final String RECIPIENT;
    protected final double WEIGHT;

    Delivery(String sender, String recipient, double weight) {
        this.SENDER = sender;
        this.RECIPIENT = recipient;
        this.WEIGHT = weight;
    }

    protected double totalCost() {
        double totalCost = 0;
        double tmp = this.WEIGHT;
        
        for(int i = 0; i < RANGE.length; i++){
            totalCost += ((tmp / RANGE[i] > 1) ? RANGE[i] : (tmp % RANGE[i])) * VALUE[i];
            tmp -= RANGE[i];
            
            if (tmp < 0)
                break;
        }
        
        if (tmp > 0)
            totalCost += tmp * VALUE[3];
        
        return totalCost;
    }
    
    @Override
    public String toString(){
        return String.format("From : %s To : %s\nWeight of package : %.2f\nShipping Cost : %.2f\n",
                this.SENDER, this.RECIPIENT, this.WEIGHT, this.totalCost());
    }
}
