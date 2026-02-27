# TimeTabler
Weekly timetable creator.

Provides GUI to add events to a timetable, exports to PDF using Typst.

![examplepdf.jpg](examplepdf.jpg)

## Build Instructions
Requires Java 21+

Firstly, clone the repo.

On Linux/MacOS:
```bash
chmod +x mvnw timetabler install.sh
./mvnw package
./install.sh
```

On Windows:
```bash
mvnw.cmd package
```
Then run `install.bat`.

I have not tested the build on Windows and probably won't ever get around to it. If you find issues
then absolutely feel free to make a PR.

Once it is installed, execute with `timetabler` command!