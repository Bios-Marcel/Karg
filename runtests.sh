printf "Running tests for native build"
./gradlew -b native-build.gradle tests
printf "\nRunning tests for JVM build"
./gradlew -b jvm-build.gradle tests