package org.ecommerce.sbecom.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        String originalFileName = file.getOriginalFilename();


        String randomId = UUID.randomUUID().toString();
        assert originalFileName != null;
        String fileName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));

        String base = System.getProperty("user.dir");
        String filePath = base + File.separator + path + File.separator + fileName;

        File folder = new File(base + File.separator + path);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (!created) {
                throw new IOException("Could not create upload directory: " + folder.getAbsolutePath());
            }
        }

        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }

}
