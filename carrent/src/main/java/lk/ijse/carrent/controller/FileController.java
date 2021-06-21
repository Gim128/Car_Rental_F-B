package lk.ijse.carrent.controller;

import lk.ijse.carrent.util.StandardResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    private static final String UPLOADED_FOLDER = "E:\\evo4\\car-rent_frontEnd\\asserts\\img\\upload";

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveFile(@RequestPart("myFile") MultipartFile myFile) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(UPLOADED_FOLDER + "/uploads");
            uploadsDir.mkdir();
            File toFile = new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename());
            myFile.transferTo(toFile);
            System.out.println(toFile.getAbsolutePath());
            String filePath = toFile.getAbsolutePath();
            return new ResponseEntity(new StandardResponce("201", "Done", filePath), HttpStatus.CREATED);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}