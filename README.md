# vertx-multipart-body-handler

This is the implementation of BodyHandler in Vert.x for http multipart form file upload.

The default implementation of BodyHandler in vert.x saves the uploaded files to the upload directory, and in the next pipeline handler, the uploaded files can be read from the upload directory. But it could come to performance bottleneck for some other cases.

This MultipartBodyHandler handles the byte array of upload files directly without saving them to the upload directory. This MultipartBodyHandler saves the byte array of upload files into Memory in context, and in the next pipeline routing context handler, the byte array of upload files can be retrieved from the routing context.

Let's see the usage of this MultipartBodyHandler in a verticle:

```
router.post(uri).handler(MultipartBodyHandler.create().setMergeFormAttributes(true));
router.post(uri).handler(routingContext -> {
    request = routingContext.request();
    response = request.response();

    // multipart form binary data.
    // handle upload files from memory in routing context.   
    Set<FileUpload> fileUploadSet = routingContext.fileUploads();
    for(FileUpload fileUpload : fileUploadSet) {
        String fieldName = fileUpload.name();
        
        // get byte array of the uploaded file from memory.
        byte[] uploadData = (MultipartFileUploadImpl)fileUpload).getData();

        ...
    }

    // multipart form text data.
    MultiMap formAttributes = request.formAttributes();
});

```
