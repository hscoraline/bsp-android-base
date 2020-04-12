# Base project

This is Android base project for development (Includes a sample feature)

##Usage

Clone or download and open project with Android Studio

##Note

-Actively use constraint layouts to limit nesting of too many layouts, affecting the smoothness of the UI

-Replace the API base url in the build.grade (app) file and build the corresponding version

-Use Databinding to restrict findViewById and manually set Data on the UI

-Use Navigation for each feature, if there are many features need the same screen, create an abstract base fragment class for that screen

-Use Room when it is necessary to save local data

-Use ListAdaper instead of RecyclerView.Adapter to use DiffUtil's diff calculation feature, if data is broken down by page, use PagedListAdapter

-Use Databinding for handle Click action: Instead of implement onClickListener, create an interface called "handler" for each screen that has click action.

-Use sdp instead of dp dimensions

-Use ViewPager2 instead of Viewpager (It use with RecyclerView adapter)
