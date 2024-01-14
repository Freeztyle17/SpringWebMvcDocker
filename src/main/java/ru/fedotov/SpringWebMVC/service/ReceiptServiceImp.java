package ru.fedotov.SpringWebMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fedotov.SpringWebMVC.model.ProductDetail;
import ru.fedotov.SpringWebMVC.model.Receipt;
import ru.fedotov.SpringWebMVC.model.ReceiptStory;
import ru.fedotov.SpringWebMVC.repository.ReceiptRepository;
import ru.fedotov.SpringWebMVC.repository.ReceiptStoryRepository;

import java.util.List;

@Service
public class ReceiptServiceImp implements ReceiptService {
    @Autowired
    ReceiptRepository receiptRepository;

    @Autowired
    ReceiptStoryRepository rsr;

    @Override
    public List<Receipt> getAllChecks() {
        return receiptRepository.findAll();
    }


    public Long getMaxCheckId(){
        Long max = 0L;
        List<Receipt> alo = getAllChecks();
        for(int i=0; i<alo.size(); i++){
           max =  alo.get(i).getId();
        }
        return max;
    }

    @Override
    public Receipt saveReceipt(Receipt receipt) {
       return receiptRepository.save(receipt);
    }

    @Override
    public ReceiptStory saveReceiptStory(ReceiptStory receiptStory) {
        return rsr.save(receiptStory);
    }

    @Override
    public List<ReceiptStory> getAllReceiptStory() {
        return rsr.findAll();
    }

    @Override
    public List<ReceiptStory> getAllReceiptsById(long id) {
        return rsr.findAll().stream().filter(receiptStory -> receiptStory.getReceipt_id() == id).toList();
    }

}
