
package inventory;

public class Product {
    private String title;
    private String productID;
    private String type;
    private String genre;
    private int copies;
    private String console;
    
    public Product(String ID, String _title, String _type, String _genre, int _copies)
    {
        productID = ID;
        title = _title;
        type = _type;
        genre = _genre;
        copies = _copies;
    }
    
    public Product(String ID, String _title, String _type, String _console, String _genre, int _copies)
    {
        productID = ID;
        title = _title;
        type = _type;
        console = _console;
        genre = _genre;
        copies = _copies;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
    
    public Product()
    {
        productID = "0";
        title = "";
        type = "";
        genre = "";
        copies = 0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getProductID()
    {
        return productID;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setProductID(String ID)
    {
        productID = ID;
    }
    
    public void setTitle(String _title)
    {
        title = _title;
    }
}