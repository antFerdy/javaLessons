
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean( name = "stockserverbean")
@RequestScoped
public  class StockServerBean implements Serializable {
    ArrayList<String>str = new ArrayList<String>();
    private String ticker;
    
    
    public StockServerBean() {
        str.add("AAPL");
        str.add("AMZN");
        str.add("GMCR");
        str.add("FFIV");
        str.add("NFLX");
    }
    
    

    public Double getQuote() {
   
        if(str.contains(getTicker())) {
            return Math.random()*1000;
        }
        else {
            return null;
        }
        
    }

    /**
     * @return the ticker
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * @param ticker the ticker to set
     */
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
    
    
    
}
