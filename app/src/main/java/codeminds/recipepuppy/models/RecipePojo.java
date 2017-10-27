package codeminds.recipepuppy.models;

import java.util.ArrayList;

/**
 * Created by allam on 27/10/17.
 */

public class RecipePojo {

    private String title;

    private ArrayList<Results> results;

    private String href;

    private String version;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public ArrayList<Results> getResults ()
    {
        return results;
    }

    public void setResults (ArrayList<Results> results)
    {
        this.results = results;
    }

    public String getHref ()
    {
        return href;
    }

    public void setHref (String href)
    {
        this.href = href;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", results = "+results+", href = "+href+", version = "+version+"]";
    }
}
