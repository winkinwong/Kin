package dev.application.global;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Pager<T> {
    // 每页最多的数据量
    private Long size = 10L;
    // 当前页码
    private Long current;
    // 总页数
    private Long total;
    // 数据列表
    private List<T> datas = new LinkedList<>();
    private Map<String, Object> extras = new HashMap<>();

    public Long calOffset(Long pageNo) {
        if (pageNo == null || pageNo == 0) pageNo = 1L;

        this.setCurrent(pageNo);
        return (pageNo - 1) * size;
    }

    public void putExtra(String key, Object data) {
        this.extras.put(key, data);
    }

    public Map<String, Object> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, Object> extras) {
        this.extras = extras;
    }

    public void add(T data) {
        datas.add(data);
    }

    public Long getSize() {
        return size;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = (total % size == 0 ? total / size : total / size + 1);
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
