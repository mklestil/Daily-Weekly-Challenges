package at.mklestil.renameimages.model;

import at.mklestil.renameimages.view.MainView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RenameModelTest {
    private RenameModel model;
    private File tempDir;

    @BeforeEach
    void setUp() throws IOException{
        model = new RenameModel();
        tempDir = new File(System.getProperty("java.io.tmpdir"), "testFiles");
        tempDir.mkdir();
    }

    @AfterEach
    void tearDown() {
        for (File file : tempDir.listFiles()) {
            file.delete();
        }
        tempDir.delete();
    }

    @Test
    void testRenameFiles() throws IOException {
        // Arrange
        File file1 = new File(tempDir, "old1.png");
        File file2 = new File(tempDir, "old2.png");
        file1.createNewFile();
        file2.createNewFile();
        List<File> fileList = Arrays.asList(file1, file2);

        // Act
        model.renamedFiles(fileList, "renamed");

        // Assert
        File expected1 = new File(tempDir, "renamed1.png");
        File expected2 = new File(tempDir, "renamed2.png");

        assertTrue(expected1.exists());
        assertTrue(expected2.exists());
        assertFalse(file1.exists());
        assertFalse(file2.exists());
    }

}