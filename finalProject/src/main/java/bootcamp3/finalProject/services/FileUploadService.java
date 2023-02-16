package bootcamp3.finalProject.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {

    public boolean uploadAvatar(MultipartFile file){
       try {


        if(file.getContentType().equals("image/jpeg")|| file.getContentType().equals("image/png")){
         byte bytes[] = file.getBytes();
         Path path = Paths.get("avatar.jpg");
            Files.write(path,bytes);
         }
       }catch (Exception e){
           e.printStackTrace();
       }
       return true;
    }
}
