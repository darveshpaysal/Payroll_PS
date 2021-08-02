 call mvn -f  ../../ppsapi/pom.xml clean install 
 if errorlevel 1 goto :error
 goto :success

 :error
 @echo Build Failed 
 pause
 
 :success

