import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus{



/*
* Constructor that initializes an ImageFilter object using the provided filename.
* filename The name of the image file to be loaded.
*/  
public ImageFilter (String filename){

super(filename);
}

  

  /*
  *  This is the image filter that I have created and is not from this unit.
  * Enhances the blue component of each pixel while reducing red and green.
  *  ColorNumber The amount by which blue is increased and red/green are decreased.
  */
  public void getAllBlue(int ColorNumber) {
  Pixel [][] pixels = getPixelsFromImage();
  for (int row = 0; row < pixels.length; row++){
    for(int col = 0; col< pixels[row].length; col++){

      
      int red = pixels[row][col].getRed() - ColorNumber;
      int green = pixels[row][col].getGreen() - ColorNumber;
      int blue = pixels[row][col].getBlue() + ColorNumber;
      
      pixels[row][col].setRed(red);
      pixels[row][col].setGreen(green);
      pixels[row][col].setBlue(blue);
      
    }
  }
}


 /**
  * This image filter is from this unit and is located in Unit 5 lesson 8 level 3D.
  * Adjusts the contrast of the image by multiplying each color component by a given factor.
  * Ensures that color values remain within the valid range (0-255).
  *  multiply the factor by which each color component is multiplied.
  */
  public void adjustContrast(int multiplier) {
       Pixel[][] pixels = getImagePixels();
     for (int row = 0; row < pixels.length; row++) {
        for (int col = 0; col < pixels[row].length; col++) {
            Pixel pixel = pixels[row][col];
           
            int newRed = pixel.getRed() * multiplier;
            int newGreen = pixel.getGreen() * multiplier;
            int newBlue = pixel.getBlue() * multiplier;
           
           
            newRed = Math.min(255, Math.max(0, newRed));
            newGreen = Math.min(255, Math.max(0, newGreen));
            newBlue = Math.min(255, Math.max(0, newBlue));
           
            pixel.setRed(newRed);
            pixel.setGreen(newGreen);
            pixel.setBlue(newBlue);   

        }

    }
  }
  
 /*
  * I got this image filter from Unit 5 Lesson 6 - Level 7C.
  * Removes all green color from the image by setting the green component of each pixel to 0.
  * This makes the image appear with only red and blue tones.
  */
 public void zeroGreen() {
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        currentPixel.setGreen(0);
      }
    }
  }
/*
 *I got this image filter from Unit 5 Lesson 6 - Level 7B.
 * Removes all blue color from the image by setting the blue component of each pixel to 0.
 * This results in an image composed only of red and green tones.
 */
  public void zeroBlue() {
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        currentPixel.setBlue(0);
      }
    }
  }



/*
* I got this image filter from Unit 5 Lesson 6 - Level 7A.
* Removes all red color from the image by setting the red component of each pixel to 0.
* This makes the image appear with only green and blue tones.
*/ 
public void zeroRed() {
   for (int row = 0; row < pixels.length; row++) {
  for (int col = 0; col < pixels[0].length; col++) {
     Pixel currentPixel = pixels[row][col];

     currentPixel.setRed(0);
  }
 }
  }


  

}


