import org.code.theater.*;
import org.code.media.*;


/*
 * MyNarrative class represents a series of scenes with images, sounds, and text descriptions.
 * It handles displaying the scenes, applying filters to the images, and showing descriptive text based on conditions.
 */
public class MyNarrative extends Scene {

// 2D arrays storing data file names and descriptive words
String[][] DataFiles;
String [][] Text;



/*
 * Constructor for MyNarrative class.
 * Initializes the DataFiles and Text arrays with values provided from TheaterRunner. 
 * DataFiles A 2D array containing file names of images and sounds.
 * Text 2D array contains descriptive words for each scene.
*/  
public MyNarrative(String [][] DataFiles, String[][] Text){
this.DataFiles = DataFiles;
this.Text = Text;  
}


/*
* Calls methods to draw each scene in the narrative.
* Each scene is represented by an image, text, and audio.
*/  
public void drawScene(){

drawChicago();
drawIceCream();
drawOcean();
drawTrack();
}


/*
* Draws the Chicago scene with an image, descriptive text, and sound.
* - Displays an image of Chicago.
* - Text descriptions are displayed in red, and their case depends on word length.
* - Plays the corresponding sound file.
* - Applies a blue color filter effect to the image.
*/
public void drawChicago(){

ImageFilter ChicagoImage = new ImageFilter (DataFiles[0][0]);
drawImage(ChicagoImage,0,0,getWidth()); 
setTextColor("black");
drawText("This is Chicago. It is ", 10, 20);
drawText("Description letters will be uppercase if:",5, 320); 
 drawText("title length > 6 and description length > 6", 5, 340);
drawText("if not, then description will be lowercase" ,5 , 360);
int x = 20;
  
 // Iterate through the text array for Chicago scene and display the descriptions
  for(int i =0; i < 3; i++){
    setTextColor("red");
     x = x + 20;
      
     // Check word length condition to decide on uppercase or lowercase text
     if( (Text[0][i].length() > 6) && (DataFiles[0][0].length() > 10) ){
         drawText(Text[0][i].toUpperCase(),10,x);
         drawText(Text[0][i].length() + " (word count)",150,x);
         playSound(DataFiles[0][1]);
         pause(2);
         }

     else {
         drawText(Text[0][i].toLowerCase(),10,x);
         drawText(Text[0][i].length() + " (word count)",150,x);
         playSound(DataFiles[0][1]);
         pause(2);
        }
  }

// Applies a blue filter effect repeatedly 
for (int y = 0; y < 5; y++){
  ChicagoImage.getAllBlue(50);
  drawImage(ChicagoImage,0,0,getWidth()); 
  pause(2);
   }
}

 /*
  * Draws the Ice Cream scene with an image, text, and sound.
  * - Displays an image of an ice cream cone.
  * - Text descriptions are in blue and are displayed in lowercase.
  * - Plays the corresponding sound file.
  * - Applies a filter that removes the red color from the image.
  */
 public void drawIceCream(){
 ImageFilter IceCreamImage = new ImageFilter (DataFiles[1][0]);
 clear("white");
 drawImage(IceCreamImage,0,0,getWidth()); 
 setTextColor("red"); 
 drawText("This is Mint Chip IceCream. It is ", 10, 20); 

int x = 20;

  // Iterate through the text for Ice Cream scene and display descriptions  
  for(int i =0; i < 3; i++){
  setTextColor("blue");
  x = x + 20;
  drawText(Text[1][i].toLowerCase(),10,x);
  drawText(Text[1][i].length() + " (word count)",150,x);
  playSound(DataFiles[1][1]);
  pause(3);
}   

// Removes red color from the image
IceCreamImage.zeroRed();
drawImage(IceCreamImage,0,0,getWidth()); 
pause(2);
}

  /*
  * Draws the Ocean scene with an image, text, and sound.
  * - Displays an image of the ocean.
  * - Text descriptions are in red, with case depending on word length.
  * - Plays the corresponding sound file.
  * - Applies a filter that removes green color from the image.
  */
 public void drawOcean(){
 ImageFilter OceanImage = new ImageFilter (DataFiles[2][0]);
 clear("white");
 drawImage(OceanImage,0,0,getWidth()); 
 
  // Set text color to purple and display important information.
  setTextColor("purple"); 
 drawText("This is the Ocean. It is ", 10, 20); 
  drawText("Description letters will be uppercase if:",5, 320); 
  drawText("title length > 6 and description length > 6", 5, 340);
  drawText("if not, then description will be lowercase" ,5 , 360);
 int x = 20;

  // Iterate through the text for Ocean scene and display descriptions
  for(int i =0; i < 3; i++){
  setTextColor("red");
  x = x + 20;

     // Check word length condition to decide on uppercase or lowercase text
     if( (Text[2][i].length() > 6) && (DataFiles[2][0].length() > 10) ){
         drawText(Text[2][i].toUpperCase(),10,x);
         drawText(Text[2][i].length() + " (word count)",150,x);
         playSound(DataFiles[2][1]);
         pause(2);
         }

     else {
         drawText(Text[2][i].toLowerCase(),10,x);
         drawText(Text[2][i].length() + " (word count)",150,x);
         playSound(DataFiles[2][1]);
         pause(2);
        }
}
OceanImage.zeroGreen();
drawImage(OceanImage,0,0,getWidth()); 
pause(2);
}

/*
  * Draws the Track scene with an image, text, and sound.
  * - Displays an image of a running track.
  * - Generates a random number (1-10) to determine which filter effect is applied.
  * - Text descriptions are in uppercase and displayed in aqua color.
  * - Plays the corresponding sound file.
  * - Applies either a zeroBlue filter (if random number > 5) or adjusts contrast.
  */
 public void drawTrack(){
 ImageFilter TrackImage = new ImageFilter (DataFiles[3][0]);
 clear("white");
 int randomNumber = (int)(Math.random() * 10) +1;
 drawImage(TrackImage,0,0,getWidth()); 
 setTextColor("aqua"); 
 drawText("This is a track . It has ", 10, 20); 
 drawText("Random Number (1-10) = " + randomNumber,5, 320); 
 drawText("if number is > 5, zeroBlue ", 5, 340);
 drawText("else AdjustContrast filter" ,5 , 360);
 int x = 20;
for(int i =0; i < 3; i++){
  setTextColor("aqua");
  x = x + 20;
  drawText(Text[3][i].toUpperCase(),10,x);
  drawText(Text[3][i].length() + " (word count)",150,x);
  playSound(DataFiles[3][1]);
  pause(3);
}

if (randomNumber > 5) TrackImage.zeroBlue();
else TrackImage.adjustContrast(randomNumber);


drawImage(TrackImage,0,0,getWidth()); 
pause(2);
}
  

}