package com.epam.engx.cleancode.naming.task5;

import com.epam.engx.cleancode.naming.task5.predicates.FileExtensionPredicate;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidDirectoryException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidFileTypeException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.PropertyUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public final class FileManager {

    private static final String[] IMAGE_SUPPORTED_EXTENSIONS = {"jpg", "png"};
    private static final String[] DOCUMENT_SUPPORTED_EXTENSIONS = {"pdf", "doc"};

    private final String basePath = PropertyUtil.loadProperty("basePath");

    public File getFile(String fileName) {
        validateFileType(fileName);
        final String dirPath = basePath + File.separator;
        return Paths.get(dirPath, fileName).toFile();
    }

    public List<String> getImageNames() {
        return getFilesByExtensions(basePath, IMAGE_SUPPORTED_EXTENSIONS);
    }

    public List<String> getDocumentNames() {
        return getFilesByExtensions(basePath, DOCUMENT_SUPPORTED_EXTENSIONS);
    }

    private void validateFileType(String fileName) {
        if (isInvalidFileType(fileName)) {
            throw new InvalidFileTypeException("File type not Supported: " + fileName);
        }
    }

    private boolean isInvalidFileType(String fileName) {
        return isInvalidImage(fileName) && isInvalidDocument(fileName);
    }

    private boolean isInvalidImage(String fileName) {
        FileExtensionPredicate extensionPredicate = new FileExtensionPredicate(IMAGE_SUPPORTED_EXTENSIONS);
        return !extensionPredicate.test(fileName);
    }

    private boolean isInvalidDocument(String fileName) {
        FileExtensionPredicate extensionPredicate = new FileExtensionPredicate(DOCUMENT_SUPPORTED_EXTENSIONS);
        return !extensionPredicate.test(fileName);
    }

    private List<String> getFilesByExtensions(String directoryPath, String[] allowedExtensions) {
        final FileExtensionPredicate pred = new FileExtensionPredicate(allowedExtensions);
        return Arrays.asList(createDirectory(directoryPath).list(getFilenameFilterByFileExtensionPredicate(pred)));
    }

    private FilenameFilter getFilenameFilterByFileExtensionPredicate(final FileExtensionPredicate predicate) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File directory, String string) {
                return predicate.test(string);
            }
        };
    }

    private File createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        validateDirectory(directory);
        return directory;
    }

    private void validateDirectory(File directory) {
        if (isNotDirectory(directory)) {
            throw new InvalidDirectoryException("Invalid directory found: " + directory.getAbsolutePath());
        }
    }

    private boolean isNotDirectory(File dir) {
        return !dir.isDirectory();
    }

}