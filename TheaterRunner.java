import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {


// 2D array storing file names for images and corresponding sounds 
String [][] DataFiles = {{"Chicago.png", "ChicagoStorm.wav"},
                         {"IceCreamCone.png", "Yum.wav"},
                         {"Ocean.jpg", "OceanWave.wav"},
                         {"Track.jpg", "RaceStart.wav"}};

// 2D array storing descriptive words for each scene
String [][] Text = {{"Windy", "Populated" , "Dense"},
                    {"Delicious", "Sweet", "Cold"},
                    {"Beautiful", "Relaxing","Calm"},
                     {"Lanes", "Stripes","Numbers"}};

// Creating an instance of MyNarrative to handle the narrative   
MyNarrative scene = new MyNarrative(DataFiles,Text);

// Calls the method to draw the scene
scene.drawScene();   
    
// Plays the created scenes using the Theater library  
Theater.playScenes(scene);


    
    
  }
}