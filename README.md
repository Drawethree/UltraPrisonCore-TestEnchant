# UltraPrisonCore-TestEnchant
Example of creating Custom Enchants for UltraPrisonCore v1.1.24 and above.
You need to add the UltraPrisonCore.jar into your classpath!

## Common Issues

### Q: Maven has some build errors linked with annotation proccessors. 
A: Please add ``` <compilerArgument>-proc:none</compilerArgument>``` into your ```<configuration>``` section of maven-compiler-plugin in pom.xml
