package codeminds.recipepuppy.models;

/**
 * Created by allam on 27/10/17.
 */

public class Results {
    private String ingredients;

    private String title;

    private String thumbnail;

    private String href;

    public String getIngredients ()
    {
        return ingredients;
    }

    public void setIngredients (String ingredients)
    {
        this.ingredients = ingredients;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getThumbnail ()
    {
        return thumbnail;
    }

    public void setThumbnail (String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getHref ()
    {
        return href;
    }

    public void setHref (String href)
    {
        this.href = href;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ingredients = "+ingredients+", title = "+title+", thumbnail = "+thumbnail+", href = "+href+"]";
    }
}
