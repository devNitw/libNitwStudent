# Library App For NitW.
## The app is made at Devathon 1.0 for Problem Statement A1.

### Demo Video **[here](https://github.com/devNitw/libNitwStudent/blob/main/2020-10-03-16-30-41_2Cer98sM.compressed.mp4?raw=true)**

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

## App Flow

On Launching the app and logging in, the student is taken to the Home page where all the courses he is enrolled in are listed.

![Home Page](https://github.com/devNitw/libNitwStudent/blob/main/Home.jpeg?raw=true)

Swiping sideways or clicking on the bottom menu icons takes the student to the various features of the app.

The library feature allows the student to browse through all the books streamwise.

![Library](https://github.com/devNitw/libNitwStudent/blob/main/Library.jpeg?raw=true)

The student can have a preview of any course by clicking on the syllabus button on the corresponding course card.

![Books](https://github.com/devNitw/libNitwStudent/blob/main/Syllabus.jpeg?raw=true)

Clicking on the card itself opens that course and all the books and material associated with tht course are listed.

![Syllabus](https://github.com/devNitw/libNitwStudent/blob/main/BooksInSomeCourse.jpeg?raw=true)

The student can download books to his device, although he can only access the offline books through the app.

![Offline View](https://github.com/devNitw/libNitwStudent/blob/main/OfflineFiles.jpeg?raw=true)

The app also provides an Extended Reading feature through with the student can access various academic magazines, articles, journals etc online.

![Extended Reading](https://github.com/devNitw/libNitwStudent/blob/main/ExtendedReading.jpeg?raw=true)

Swiping up/down on this Extended Reading page aloows the user to browse various papers.

![Transition](https://github.com/devNitw/libNitwStudent/blob/main/ViewPagerTransition.jpeg?raw=true)

The side navigation menu allows the user to modify his profile, adjust the app settings or contact the developers to provide feedback.

![Side Navigation Menu](https://github.com/devNitw/libNitwStudent/blob/main/SideNavigationMenu.jpeg?raw=true) ![Contact Us](https://github.com/devNitw/libNitwStudent/blob/main/ContactUs.jpeg?raw=true)

The librarian can upload books along with their details. 

![Select File](https://github.com/devNitw/libNitwStudent/blob/main/LibrarianUploadForm.jpeg?raw=true) ![File Selected](https://github.com/devNitw/libNitwStudent/blob/main/AfterLibrarianUploads.jpeg?raw=true) ![Uploaded](https://github.com/devNitw/libNitwStudent/blob/main/FileUploaded.jpeg?raw=true)

