package com.example.demo.components;

import com.example.demo.models.*;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.example.demo.repositories.*;

import javax.xml.crypto.Data;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    FileRepository fileRepository;

    public DataLoader(){};
    @Override
    public void run(ApplicationArguments args) throws Exception {
        User calum = new User("Calum");
        User saad = new User("Saad");
        User david = new User("David");

        Folder cFolder = new Folder("Calum's Folder", calum);
        Folder sFolder = new Folder("Saad's Folder", saad);
        Folder hFolder = new Folder("Another Folder", saad);

        File diary = new File("Diary", ".txt", 10, cFolder);
        File classNotes = new File("Classnotes", ".pdf", 20, sFolder);
        File selfie = new File("Selfie", ".jpg", 200, cFolder);

        userRepository.save(calum);
        userRepository.save(saad);
        userRepository.save(david);
        folderRepository.save(cFolder);
        folderRepository.save(sFolder);
        folderRepository.save(hFolder);
        fileRepository.save(diary);
        fileRepository.save(classNotes);
        fileRepository.save(selfie);


    }
}
