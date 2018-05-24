package com.example.demo.util.pagination;

import com.example.demo.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Wraps list of Pageable data and adds page, max, total_records, total_pages etc for pagination
 *
 * @author Mohamed Ibrahim
 */
public class PaginatedListWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("page")
    private int page;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("records")
    private int records;

    @JsonProperty("total_records")
    private long totalRecords;

    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("data")
    private List<? extends Pageable> data;

    private PaginatedListWrapper(final Page<? extends Pageable> pageResult) {
        page = pageResult.getNumber();
        limit = pageResult.getSize();
        records = pageResult.getNumberOfElements();
        totalRecords = pageResult.getTotalElements();
        totalPages = pageResult.getTotalPages();
        data = pageResult.getContent();
    }

    public static PaginatedListWrapper of(final Page<? extends Pageable> pageResult) {
        return new PaginatedListWrapper(pageResult);
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }

    public int getRecords() {
        return records;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<? extends Pageable> getData() {
        return data;
    }
}
