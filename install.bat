@echo off
set APP_NAME=timetabler
set INSTALL_DIR=%USERPROFILE%\AppData\Local\Programs\%APP_NAME%

echo Installing %APP_NAME%...

mkdir "%INSTALL_DIR%"
copy timetable.bat "%INSTALL_DIR%\" >nul
copy timetable.jar "%INSTALL_DIR%\" >nul


setx PATH "%PATH%;%INSTALL_DIR%"

echo Installation complete.
pause