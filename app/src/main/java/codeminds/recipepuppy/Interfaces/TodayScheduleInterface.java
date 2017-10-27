package codeminds.recipepuppy.Interfaces;


import codeminds.recipepuppy.models.RecipePojo;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by allam on 19/1/17.
 */

public interface TodayScheduleInterface {
    @GET("/api/")
    public void getSchedule(@Query("i") String integr, Callback<RecipePojo> response);


}
