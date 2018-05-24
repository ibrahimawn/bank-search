package com.example.demo.service;

import com.example.demo.domain.BankDetails;
import com.example.demo.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private static final Logger LOG = LoggerFactory.getLogger(BankService.class);

    private final BankRepository bankRepository;

    BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Optional<BankDetails> findByIfsc(String ifsc) {
        Page<Object[]> result = bankRepository.findByIfsc(ifsc, new PageRequest(0, 1));

        List<Object[]> content = result.getContent();
        if (content.isEmpty()) {
            return Optional.ofNullable(null);
        }
        return Optional.ofNullable(mapBankDetails(content.get(0)));
    }

    private static BankDetails mapBankDetails(Object[] record) {
        if (0 == record.length) {
            return null;
        }
        return new BankDetails((String) record[0], (String) record[1], (String) record[2], (String) record[3],
                (String) record[4], (String) record[5], (String) record[6]);
    }
}
