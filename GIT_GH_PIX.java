import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GIT_GH_PIX {
    public static void main(String[] args) throws IOException {

        // Load the image
        BufferedImage inputImage = null;
        inputImage = ImageIO.read(new File("/Users/ohenmaao/Downloads/Flag_of_Ghana.svg.png"));


        // Pixelate the image
        int pixelSize = 20;
        BufferedImage outputImage = pixelateImage(inputImage, pixelSize);

        // Save the output image
        ImageIO.write(outputImage, "png", new File("/Users/ohenmaao/Desktop/Flag_of_Ghana_Pixel.svg.png"));
    }

    public static BufferedImage pixelateImage(BufferedImage originalImage, int pixelSize) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage pixelatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = pixelatedImage.createGraphics();
        g2.drawImage(originalImage, 0, 0, null);
        g2.dispose();

        for (int y = 0; y < height; y += pixelSize) {
            for (int x = 0; x < width; x += pixelSize) {
                int rgb = pixelatedImage.getRGB(x, y);
                for (int y2 = y; y2 < y + pixelSize && y2 < height; y2++) {
                    for (int x2 = x; x2 < x + pixelSize && x2 < width; x2++) {
                        pixelatedImage.setRGB(x2, y2, rgb);
                    }
                }
            }
        }
        return pixelatedImage;
    }
}

