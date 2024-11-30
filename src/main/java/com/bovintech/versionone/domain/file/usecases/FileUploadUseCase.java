package com.bovintech.versionone.domain.file.usecases;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class FileUploadUseCase {

    private final Cloudinary cloudinary;
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5 MB

    public String execute(MultipartFile file) {
        try {
            String fileOriginalName = file.getOriginalFilename();

            // Validación de tamaño máximo
            if (file.getSize() > MAX_FILE_SIZE) {
                return "El archivo excede el tamaño máximo permitido de 5MB";
            }

            // Validación de extensión
            if (!fileOriginalName.endsWith(".jpg") &&
                    !fileOriginalName.endsWith(".jpeg") &&
                    !fileOriginalName.endsWith(".webp") &&
                    !fileOriginalName.endsWith(".png")) {
                return "Solo se permiten imágenes con extensiones .jpg, .jpeg, .webp o .png";
            }

            // Generar un nombre de archivo único
            String fileName = UUID.randomUUID().toString();

            // Subir el archivo a Cloudinary
            Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap(
                            "public_id", fileName,
                                    "folder", "bovintech"));

            // Obtener la URL segura de la imagen cargada
            return (String) uploadResult.get("secure_url");

        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo: " + e.getMessage(), e);
        }
    }
}