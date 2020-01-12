package beers;

import java.sql.Blob;

public class Beer {
    private int id;
    private String name;
    private float Price;
    private int Stock;
    private float alcohol;
    private int brewerId;
    private int categoryId;
    private int version;
    private Blob image;
}
