package indi.zhzl.myblognext.service.impl;

import indi.zhzl.myblognext.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


@Service
public class UploadServiceImpl implements UploadService {

    @Value("${upload-path:'/static/upload'}")
    private String uploadBasePath;

    @Override
    public String upload(MultipartFile file) throws IOException {
        String uploadPath = getUploadPath();
        String uploadFileName = getUploadFileName();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File dest = new File(path.getAbsolutePath(), uploadBasePath + "/" + uploadPath);
        if (!dest.exists()) {
            dest.mkdirs();
        }
        File upload = new File(dest + "\\" + uploadFileName + suffixName);
        if (!upload.exists()) {
            upload.createNewFile();
        }
        file.transferTo(upload);
        return uploadBasePath + "/" + uploadPath + "/" + uploadFileName + suffixName;
    }

    public String getUploadPath() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd", Locale.CHINA);
        return now.format(formatter);
    }

    public String getUploadFileName() {
        long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        Random random = new Random();
        int rand = random.nextInt(1000) + 1000;
        return second + "" + rand;
    }
}
