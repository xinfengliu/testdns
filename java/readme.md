## how to build testdns.jar 

### Install jdk 
```shell
sudo dnf install java-1.8.0-openjdk-devel-1:1.8.0.302.b08-0.el8_4.x86_64
```

### Compiling
```shell
mkdir ./classes
javac com/lxf/testdns/*.java -d ./classes
```

### Prepare manifest
Create a new file `META-INF/MANIFEST.MF`, put the following content in it.  
```
Main-Class: com.lxf.testdns.Main
```

### Packaging
```shell
jar cvfm testdns.jar META-INF/MANIFEST.MF -C classes/ .
```


## Run
```shell
java -jar testdns.jar [hostname to test]
```
