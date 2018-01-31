package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Notice;

public interface NoticeDao {
    List<Notice> findAll(Map<String,Object> params);
    int countAll();
}















