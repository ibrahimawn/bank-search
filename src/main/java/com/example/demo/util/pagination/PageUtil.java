package com.example.demo.util.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Utility class for {@link Page} related functions
 *
 * @author Mohamed Ibrahim
 */
public final class PageUtil {

    /**
     * This method will convert original {@link Page} result to {@code <T>} type
     *
     * @param content      Content to be relpaced in original page result
     * @param originalPage Original page
     * @param <T>          Type of expected page result
     */
    public static <T> Page<T> convertPage(List<T> content, Page<Object[]> originalPage) {
        return new PageImpl<>(content, new PageRequest(originalPage.getNumber(), originalPage.getSize(), originalPage.getSort()), originalPage.getTotalElements());
    }
}
