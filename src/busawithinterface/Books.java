package busawithinterface;
 
public class Books {
    
static private int PRINTTHIS=1;
static private int NOPRINTTHIS =0;

    private String author;
    private String title;
    private String genre;
    private String price;
    private String publish_date;
    private String description;
    private int chackAddToList =PRINTTHIS;
    
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public String getPrice() {
        return price;
    }
    public String getPublish_date() {
        return publish_date;
    }
    public String getDescription() {
        return description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Books() {
    }

    public Books(String author, String title, String genre, String price, String publish_date, String description) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publish_date = publish_date;
        this.description = description;
    }

    public  void PrintFile(String node, String textFromNode){
        if (node.equals("author")) this.author=textFromNode;
        else if (node.equals("title")) this.title=(textFromNode);
        else if (node.equals("genre")) this.genre=(textFromNode);
        else if (node.equals("price")) this.price=(textFromNode);
        else if (node.equals("publish_date")) this.publish_date=(textFromNode);
        else if (node.equals("description")) this.description=(textFromNode);
    }

    public void addToList(){
        if(chackAddToList==PRINTTHIS)
            BusaWithInterface.oBooks.add(this);
        else return;
    }
    
    public void chackFind(String lookForThis){
        this.chackAddToList=NOPRINTTHIS;
        if((this.author.contains(lookForThis))||(this.title.contains(lookForThis))||(this.genre.contains(lookForThis))||(this.price.contains(lookForThis))||
                (this.publish_date.contains(lookForThis))||(this.author.contains(description)))
            this.chackAddToList=PRINTTHIS;
    }   
    
    @Override
    public String toString() {
        return "Books{" + "author=" + author + ", title=" + title + ", genre=" + genre + ", price=" + price + ", publish_date=" + publish_date + ", description=" + description + '}';
    }
 
}
