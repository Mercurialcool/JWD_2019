package by.vasiliuk.project.pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class PoolConfigurator {
 public static final  PoolConfigurator configurator = new PoolConfigurator();
 private static final String CONFIG_PROPERTIES = "config.properties";
  private  Properties properties = new Properties();
  public PoolConfigurator() {
   InputStream input;

   try {
    input = this.getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES);
    properties.load(input);
   } catch (IOException e){
    //fata
    throw new RuntimeException("Properties file not found", e);
   }
  }
public static PoolConfigurator getConfigurator() {
   return configurator;
}
 public Properties getProperties() {
  return properties;
 }
}
