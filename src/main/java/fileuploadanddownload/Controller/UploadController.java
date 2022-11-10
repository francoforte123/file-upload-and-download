package fileuploadanddownload.Controller;

import fileuploadanddownload.Service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class UploadController {

    @Autowired
    FileStorageService fileStorageService;

    @PostMapping("/upload")
    public void upload(@RequestParam MultipartFile file, HttpServletResponse httpServletResponse) throws IOException, MissingServletRequestPartException {
        httpServletResponse.setHeader("Content-Disposition", "attacchment; filename=\"d3f64f7c-7c19-4ab9-90a3-297dc15089a1.jpg\"");
        fileStorageService.upload(file);
    }
}
