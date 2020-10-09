package com.gost.hash.fileserver.fileserver.controller;

import org.bouncycastle.jcajce.provider.digest.GOST3411;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.MessageDigest;

@RestController
public class FileController {
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("file")
    public byte[] getFileHash(@RequestParam("file") MultipartFile file) throws IOException {
        MessageDigest messageDigest = new GOST3411.Digest2012_256();
        return messageDigest.digest(file.getBytes());
    }
}
