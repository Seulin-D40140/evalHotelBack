package fr.fms.Web;


import fr.fms.Service.HotelServiceImpl;
import fr.fms.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PictureControler
{
    private final HotelServiceImpl hotelService;
    @Autowired
    public PictureControler (HotelServiceImpl hotelService)
    {
        this.hotelService = hotelService;
    }

    @GetMapping(path = "photo/{id}")
    public ResponseEntity<?> getphoto (@PathVariable("id") Long id) throws IOException
    {
        byte[] file = null;
        try
        {
            Hotel hotel = hotelService.getHotelByid(id).get();
            if(hotel.getImgName() == null)
            {
                hotel.setImgName("default.png");
            }

            File imgFile = new File(System.getProperty("user.home") + "/Pictures/hotels/" + hotel.getImgName());
            BufferedImage image = ImageIO.read(imgFile);
            int minWidth = 400;
            int minHeight = 400;
            int maxWidth = 500;
            int maxHeight = 500;
            int width = image.getWidth();
            int height = image.getHeight();

            if (width > maxWidth || height > maxHeight || width < minWidth || height < minHeight) {
                float aspectRatio = (float) width / height;
                if (aspectRatio > 1) {
                    width = maxWidth;
                    height = (int) (maxWidth / aspectRatio);
                } else {
                    height = maxHeight;
                    width = (int) (maxHeight * aspectRatio);
                }

                BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = resizedImage.createGraphics();
                g.drawImage(image, 0, 0, width, height, null);
                g.dispose();

                // Convertir l'image redimensionnée en tableau d'octets
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(resizedImage, "png", baos);
                file = baos.toByteArray();

            } else {
                // Si l'image est déjà dans les dimensions spécifiées, la lire directement en tableau d'octets
                file = Files.readAllBytes(imgFile.toPath());
            }
        }
        catch (Exception e)
        {
            System.out.println("erreur getphoto");
        }
        return ResponseEntity.ok().body(file);
    }

    @PostMapping(path = "/photo/{id}")
    public ResponseEntity<?> uploadPhoto (MultipartFile file , @PathVariable Long id ) {
        try
        {
            Hotel hotel = hotelService.getHotelByid(id).get();
            hotel.setImgName(file.getOriginalFilename());
            Files.write(Paths.get(System.getProperty("user.home") + "/Pictures/Hotels/" + hotel.getImgName()), file.getBytes());
            hotelService.saveHotel(hotel);
        }
        catch (Exception e)
        {
            System.out.println("error upload photo");
        }
        return ResponseEntity.ok().build();
    }
}

