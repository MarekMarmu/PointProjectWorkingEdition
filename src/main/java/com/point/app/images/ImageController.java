package com.point.app.images;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;

    @PostMapping
    public void uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
            imageService.saveImage(file);
            log.error("pennys");
    }

    @Deprecated(since = "2024", forRemoval = true)
    @PostMapping("/upload")
    public String handleFileUpload(@RequestPart("image") MultipartFile file, Model model) throws IOException {

        if (!file.isEmpty()) {
                imageService.saveImage(file);
                model.addAttribute("message", "File uploaded successfully");

        } else {
            model.addAttribute("message", "Please select a file to upload");
        }
        return "upload";
    }

    @GetMapping(value = "/{imageId}", produces = MediaType.IMAGE_PNG_VALUE)
    public Resource downloadImage(@PathVariable Long imageId){

        byte[] imageData = imageService.downloadImage(imageId);

        return new ByteArrayResource(imageData);
    }
}

