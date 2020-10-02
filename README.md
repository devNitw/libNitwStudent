# Library App For NitW.
## The app is made at Devathon 1.0 for Problem Statement A1.
Lib makes it easy for the students as well as librarian to go through the digital section of the library without physically going to the institute library.
It insures that the data is updated frequently to get seemless access to the available content.
Major feature of the app includes 
- Specific login for nitw students.
- An Inbuilt Pdf reader.
- Proper management and access to database, segregated by Courses and Streams.
- Maintaining a local database for downloaded files for easy offline access.
- A global search to get the required content.
- A reading tab to get the daily magazines and newspapers on fingertips.
- A different login for librarian.
- Librarian has access to the database and can add or remove a file on authority.
- The database management makes sure that nothing is duplicated on the database and thus preventing the app from spam usage.


The app Follows best practices to make it a professional app.
- Uses MVVM pattern to keep UI seperated from the repository and making it easy to work on specific part without thinking about its effect on other components.
- Uses Room for query and data access with firebase as backend.
- Uses View binding to link Ui to the models.
