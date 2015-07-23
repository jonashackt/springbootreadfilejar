# springbootreadfilejar
Demo project for reading Files from within Spring Boot Fat-jar with Java NIO.2

### Wait, what??!
There is an [Issue] with loading Files inside of a SpringBoot Fatjar with Java NIO.2 Files and especially Paths.get()-Methode, which is needed to use Files. [Oracle] has something for ya.

### HowTo
Run it inside of eclipse (after mvn eclipse:eclipse) and firering a GET to 

```sh
localhost:8080/files
```
(e.g. with [Postman]) should work (giving something like "File reading successfull"). Inside your IDE, the Path will look something like this:

```sh
jar:file:/C:/dev/temp/springbootreadfilejar/target/springbootreadfilejar-0.0.1-SNAPSHOT.jar!/files/homepage-feature-projects.png
```


Then, run it with something like
```sh
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar springbootreadfilejar-0.0.1-SNAPSHOT.jar
```
and create a remote-debug-configuration in eclipse, when you´re inside the project.

Then run your debugger. Firering to the url again - does it work?

Now the Path is magically looking like

```sh
jar:file:/C:/dev/temp/springbootreadfilejar/target/springbootreadfilejar-0.0.1-SNAPSHOT.jar!/files/homepage-feature-projects.png
```

[Issue]:http://stackoverflow.com/questions/25032716/getting-filesystemnotfoundexception-from-zipfilesystemprovider-when-creating-a-p
[Oracle]:http://docs.oracle.com/javase/7/docs/technotes/guides/io/fsp/zipfilesystemprovider.html
[Postman]:https://www.getpostman.com/
