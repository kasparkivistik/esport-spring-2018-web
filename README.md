* To run in development mode, run `gradle :web:bootRun -Dspring.profiles.active=dev`.
* To build a JAR file, run `gradle :web:bootRepackage -Dspring.profiles.active=dev`. The resulting JAR file will not
  contain any config files, those need to be in `./config/` folder. This is required to allow changing the configuration
  without having to rebuild.