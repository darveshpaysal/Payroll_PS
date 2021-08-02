 call ppsbase.bat 
 if errorlevel 1 goto :error
 
 call ppsapi.bat 
 if errorlevel 1 goto :error
 goto : eof

 :error
 @echo Build Failed 
 pause

