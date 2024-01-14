package ru.fedotov.SpringWebMVC.service;

import ru.fedotov.SpringWebMVC.model.ProductDetail;
import ru.fedotov.SpringWebMVC.model.Receipt;
import ru.fedotov.SpringWebMVC.model.ReceiptStory;

import java.util.List;

public interface ReceiptService {

    List<Receipt> getAllChecks();
    Long getMaxCheckId();
    Receipt saveReceipt(Receipt receipt);

    ReceiptStory saveReceiptStory(ReceiptStory receiptStory);

    List<ReceiptStory> getAllReceiptStory();

    List<ReceiptStory> getAllReceiptsById(long id);


}
