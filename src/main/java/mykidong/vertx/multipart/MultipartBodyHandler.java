package mykidong.vertx.multipart;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;


public interface MultipartBodyHandler extends Handler<RoutingContext> {

    long DEFAULT_BODY_LIMIT = -1;

    String DEFAULT_UPLOADS_DIRECTORY = "file-uploads";

    boolean DEFAULT_MERGE_FORM_ATTRIBUTES = true;

    boolean DEFAULT_DELETE_UPLOADED_FILES_ON_END = false;

    boolean DEFAULT_PREALLOCATE_BODY_BUFFER = false;

    static MultipartBodyHandler create() {
        return new MultipartBodyHandlerImpl();
    }

    static MultipartBodyHandler create(boolean handleFileUploads) {
        return new MultipartBodyHandlerImpl(handleFileUploads);
    }

    static MultipartBodyHandler create(String uploadDirectory) {
        return new MultipartBodyHandlerImpl(uploadDirectory);
    }

    MultipartBodyHandler setHandleFileUploads(boolean handleFileUploads);

    MultipartBodyHandler setBodyLimit(long bodyLimit);

    MultipartBodyHandler setUploadsDirectory(String uploadsDirectory);

    MultipartBodyHandler setMergeFormAttributes(boolean mergeFormAttributes);

    MultipartBodyHandler setDeleteUploadedFilesOnEnd(boolean deleteUploadedFilesOnEnd);

    MultipartBodyHandler setPreallocateBodyBuffer(boolean isPreallocateBodyBuffer);
}