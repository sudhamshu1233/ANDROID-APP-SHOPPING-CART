package com.example.recycler_view;

public class Book
{
    private String Title,Category,Description;
    private int Thumbnail,Id,Price;

    //setters

    public Book(String title, String category, String description, int thumbnail,int id,int price)
    {
        Title = title;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
        Id = id;
        Price = price;
    }
    // getters
    public String getTitle()
    {
        return Title;
    }

    public String getCategory()
    {
        return Category;
    }

    public String getDescription()
    {
        return Description;
    }

    public int getThumbnail()
    {
        return Thumbnail;
    }

    public int getId(){
        return Id;
    }

    public int getPrice()
    {
        return Price;
    }
}
