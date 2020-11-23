package models;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class Album extends LitePalSupport {

    @Column(unique = true, defaultValue = "unknown")
    private String name;

    @Column(index = true)
    private float price;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


  //  private List<Song> songs = new ArrayList<>();

    // generated getters and setters.

}