### how to build testdns.jar 

Install jdk (on lxf-vmw):
sudo dnf install java-1.8.0-openjdk-devel-1:1.8.0.302.b08-0.el8_4.x86_64

compiling:
mkdir ./classes
javac com/lxf/testdns/*.java -d ./classes

Prepare manifest:
```
cat META-INF/MANIFEST.MF 
Main-Class: com.lxf.testdns.Main
```

packaging:
jar cvfm testdns.jar META-INF/MANIFEST.MF -C classes/ .


Run:
java -jar testdns.jar [hostname to test]
