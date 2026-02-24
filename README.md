# TimeTabler
Weekly timetable creator.

Provides GUI to add events to a timetable, exports to PDF using Typst.

![examplepdf.jpg](examplepdf.jpg)

Multiple timetables are not yet supported. The application will always open the timetable saved at
`timetables/Timetable.json`, creating a new, blank timetable at this location if no such file
exists. Renaming a timetable will save it under its new name, however the application does not yet
provide an option to open it.

## Build Instructions
Requires Java 21+

Firstly, clone the repo.

On Linux/MacOS:
```bash
mvn clean package
./mvnw package
chmod +x timetabler install.sh
./install.sh
```

On Windows:
```bash
mvn clean package
mvnw.cmd package
```
Then run `install.bat`.

I have not tested the build on Windows and probably won't ever get around to it. If you find issues
then absolutely feel free to make a PR.