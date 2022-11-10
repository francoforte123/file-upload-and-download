package fileuploadanddownload.Controller;

import fileuploadanddownload.Service.FileStorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/download")
public class DownloadController {

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/download")
    public @ResponseBody byte[] download(@RequestParam String fileName, Long id, HttpServletResponse httpServletResponse) throws IOException {
        System.out.println("Downloading " + id);
        String extension = FilenameUtils.getExtension(fileName);
        switch (extension) {
            case "gif":
                httpServletResponse.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
            case "jpeg":
            case "jpg":
                httpServletResponse.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case "png":
                httpServletResponse.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
        }
        return fileStorageService.download(fileName);
    }
}
