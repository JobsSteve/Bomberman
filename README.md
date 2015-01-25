Multiplayer Bomberman
=========

This project is coded in 4 days for company internal competition.

We used [libGDX](http://libgdx.badlogicgames.com) for OpenGL ES on Android, [libgdx stagebuilder](https://github.com/peakgames/libgdx-stagebuilder) which is opensource project, and AppWarp (appwarp.shephertz.com) for multiplayer server

Running Project
------

Add App Warp Client dependency to your local maven repository by running below command

```java
mvn install:install-file -Dfile=multiplayer-client-1.5.2.jar -DgroupId=com.shephertz.app42.gaming -DartifactId=multiplayer-client -Dversion=1.5.2 -Dpackaging=jar
```

After then, you can open the project by IntelliJ or Eclipse and run BombermanDesktop
If you want to run on device, connect your device and run below command
```java
mvn clean install -Pandroid
```

![Lobby Screen](https://raw.githubusercontent.com/firstthumb/Bomberman/mvn_repo/screenshots/1.png "Lobby Screen")
![Waiting Game Start](https://raw.githubusercontent.com/firstthumb/Bomberman/mvn_repo/screenshots/2.png "Waiting Game Start")
![Game Screen](https://raw.githubusercontent.com/firstthumb/Bomberman/mvn_repo/screenshots/3.png "Game Screen")
![Game Controller Selection](https://raw.githubusercontent.com/firstthumb/Bomberman/mvn_repo/screenshots/4.png "Game Controller Selection")
