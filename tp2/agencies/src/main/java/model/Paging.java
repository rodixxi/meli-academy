package model;

public class Paging {

    private Integer limit;
    private Integer offset;
    private Integer total;

    public Paging(Integer limit, Integer offset, Integer total) {
        this.limit = limit;
        this.offset = offset;
        this.total = total;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
