@echo off
setlocal

REM %~dp0 = directory of this script (always absolute, ends with \)
set DIR=%~dp0

java -jar "%DIR%target\timetabler.jar" %*

endlocal
