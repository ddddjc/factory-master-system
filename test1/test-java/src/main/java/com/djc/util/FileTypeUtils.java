package com.djc.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileTypeUtils {

    /**
     * 判断MultipartFile对象的文件类型
     *
     * @param file MultipartFile对象
     * @return 文件类型字符串，可能的值为 "image", "video", "other"
     */
    public static String getFileType(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        String extension = filename.substring(filename.lastIndexOf(".") + 1);

        if (isImageFile(extension)) {
            return "image";
        } else if (isVideoFile(extension, file.getBytes())) {
            return "video";
        } else {
            return "other";
        }
    }

    /**
     * 判断文件扩展名是否为图片格式
     *
     * @param extension 文件扩展名
     * @return true表示为图片格式，false表示不是图片格式
     */
    private static boolean isImageFile(String extension) {
        return "jpg".equalsIgnoreCase(extension) || "jpeg".equalsIgnoreCase(extension)
                || "png".equalsIgnoreCase(extension) || "gif".equalsIgnoreCase(extension);
    }

    /**
     * 判断文件扩展名和内容是否为视频格式
     *
     * @param extension 文件扩展名
     * @param content   文件内容
     * @return true表示为视频格式，false表示不是视频格式
     */
    private static boolean isVideoFile(String extension, byte[] content) {
        if (!"mp4".equalsIgnoreCase(extension)) {
            return false;
        }
        else return true;
    }
}