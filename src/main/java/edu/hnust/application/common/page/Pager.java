package edu.hnust.application.common.page;

public class Pager {
    Integer currentPage = 1;    
    Long totalPages;    
    Long totalRecords;    
    Long totalRows;    
    Integer pageLimit = 20;
    
    public Pager() {
    }
    
    public Pager(Integer currentPage, Integer pageLimit) {
        if (null != currentPage) {
            this.currentPage = currentPage;
        }
        if (null != pageLimit) {
            this.pageLimit = pageLimit;
        }
    }
    
    public Integer getCurrentPage() {
        return currentPage;
    }
    
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    
    public Long getTotalPages() {
        return totalPages;
    }
    
    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }
    
    public Long getTotalRecords() {
        return totalRecords;
    }
    
    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
        this.totalPages = (totalRecords + pageLimit - 1) / pageLimit;
    }
    
    public Long getTotalRows() {
        return totalRows;
    }
    
    public void setTotalRows(Long totalRows) {
        this.totalRows = totalRows;
    }
    
    public Integer getPageLimit() {
        return pageLimit;
    }
    
    public void setPageLimit(Integer pageLimit) {
        this.pageLimit = pageLimit;
    }
    
    @Override
    public String toString() {
        return "Pager [currentPage=" + currentPage + ", totalPages=" + totalPages + ", totalRecords=" + totalRecords + ", totalRows=" + totalRows + ", pageLimit=" + pageLimit + "]";
    }
}