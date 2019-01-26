package mykidong.vertx.multipart;


import io.vertx.core.http.HttpServerFileUpload;
import io.vertx.ext.web.FileUpload;

public class MultipartFileUploadImpl implements FileUpload {
    private final String uploadedFileName;
    private final HttpServerFileUpload upload;
    private final byte[] data;

    public MultipartFileUploadImpl(String uploadedFileName, HttpServerFileUpload upload, byte[] data) {
        this.uploadedFileName = uploadedFileName;
        this.upload = upload;
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public String name() {
        return this.upload.name();
    }

    public String uploadedFileName() {
        return this.uploadedFileName;
    }

    public String fileName() {
        return this.upload.filename();
    }

    public long size() {
        return this.upload.size();
    }

    public String contentType() {
        return this.upload.contentType();
    }

    public String contentTransferEncoding() {
        return this.upload.contentTransferEncoding();
    }

    public String charSet() {
        return this.upload.charset();
    }
}

