# Worttrainer

## Overview

This application is a vocabulary trainer for children just learning the language. 
It focuses on image recognition; The correct word has to be typed in to progres in the program. 
The trainer tells the user how many correct and incorrect guesses happened.

When executing the application, the user is first prompted with entering the path to a save file.
This also happens when the user never started the application before.
When first starting a game as well as when no custom save file has ever been specified,
this step can be skipped with a simple press on the Enter-key without any input.

When entering no input while in the training program, the program will close, again askinhg
for a location to save the progress. If nothing is specified, the progress will be saved
to the standard location (being the folder the application is running in).

When stuck at a specific word during the program, the application will stay at that 
word until guessed correctly.

## Documentation

Sources I used for tasks I did not know on the top of my head. 
Useful for those who want to implement an application with gradle and JSON
and don't know where to start.

Automated Gradle-Tasks in GitHub via Actions: 
- <https://docs.gradle.org/current/userguide/github-actions.html>

JSON in Java: 
- Usage: <https://www.baeldung.com/java-org-json>
- Package versions: <https://mvnrepository.com/artifact/org.json/json>
- Saving JSON to file (WARNING: Source is about json-simple, not json): <https://crunchify.com/how-to-write-json-object-to-file-in-java/>
- Reading JSON to file (WARNING: Initialisation of InputStream has to be changed with `FileInputStream()`): <https://kodejava.org/how-do-i-read-json-file-using-json-java-org-json-library/>
