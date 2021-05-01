package kpp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.Semaphore;
@Service
public class CopyService {
    @Autowired
    CopyRepository copyRepository;
    Semaphore semaphore = new Semaphore(1);

    public Copy dbCopyFind(Copy copy){
        Copy temp= new Copy();
        try {
            semaphore.acquire();
            return copyRepository.findCopyByContent1AndContent2AndContent3(copy.getContent1(), copy.getContent2(), copy.getContent3());
        } catch (InterruptedException e) {
            System.out.println("Semaphore error corrupted");
            return null;
        }
        finally {
            semaphore.release();
        }
        //if(bdCopy==null) return null;
    }

    public void dbCopySave(Copy copy){
        try {
            semaphore.acquire();
            copyRepository.save(copy);
        } catch (InterruptedException e) {
            System.out.println("Semaphore error corrupted");
        }
        finally {
            semaphore.release();
        }
        //if(temp==null)return null;
    }
}

