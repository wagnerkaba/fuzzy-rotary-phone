# ERRO NO HEROKU POR CAUSA DO ENCODING

O heroku estava dando o seguinte erro:

```

-----> Building on the Heroku-20 stack
-----> Using buildpack: heroku/java
-----> Java app detected
-----> Installing JDK 11... done
-----> Executing Maven
       $ ./mvnw -DskipTests clean dependency:list install
       [INFO] Scanning for projects...
       [INFO] Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.8.0/maven-compiler-plugin-3.8.0.pom
       [INFO] Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.8.0/maven-compiler-plugin-3.8.0.pom (12 kB at 40 kB/s)
       [INFO] Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/32/maven-plugins-32.pom
       [INFO] Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/32/maven-plugins-32.pom (11 kB at 396 kB/s)
       [INFO] Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/32/maven-parent-32.pom
       [INFO] Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/32/maven-parent-32.pom (43 kB at 1.1 MB/s)
       [INFO] Downloading from central: https://repo.maven.apache.org/maven2/org/apache/apache/20/apache-20.pom
       [INFO] Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/apache/20/apache-20.pom (16 kB at 660 kB/s)
       [INFO] Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.8.0/maven-compiler-plugin-3.8.0.jar
       [INFO] Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.8.0/maven-compiler-plugin-3.8.0.jar (62 kB at 2.0 MB/s)
       [INFO] 
       [INFO] --------------------------< com.example:demo >--------------------------
       [INFO] Building demo 0.0.1-SNAPSHOT
       [INFO] --------------------------------[ jar ]---------------------------------
       [INFO] 
       [INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ demo ---
       [INFO] 
       [INFO] --- maven-dependency-plugin:3.1.2:list (default-cli) @ demo ---
       [INFO] 
       [INFO] --- maven-resources-plugin:3.2.0:resources (default-resources) @ demo ---
       [INFO] Using 'UTF-8' encoding to copy filtered resources.
       [INFO] Using 'UTF-8' encoding to copy filtered properties files.
       [INFO] Copying 2 resources
       [INFO] ------------------------------------------------------------------------
       [INFO] BUILD FAILURE
       [INFO] ------------------------------------------------------------------------
       [INFO] Total time:  3.350 s
       [INFO] Finished at: 2021-12-20T17:38:18Z
       [INFO] ------------------------------------------------------------------------
       [ERROR] Failed to execute goal org.apache.maven.plugins:maven-resources-plugin:3.2.0:resources (default-resources) on project demo: Input length = 1 -> [Help 1]
       [ERROR] 
       [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
       [ERROR] Re-run Maven using the -X switch to enable full debug logging.
       [ERROR] 
       [ERROR] For more information about the errors and possible solutions, please read the following articles:
       [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
 !     ERROR: Failed to build app with Maven
       We're sorry this build is failing! If you can't find the issue in application code,
       please submit a ticket so we can help: https://help.heroku.com/
 !     Push rejected, failed to compile Java app.
 !     Push failed
```

Descobri que o erro era por causa do encoding do arquivo `application.properties`, o qual estava com encoding **ANSI.** Para corrigir o erro, mudei o encoding para **UTF-8**

