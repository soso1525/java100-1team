package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Notice;

public interface NoticeDao {
    List<Notice> findAll(Map<String,Object> params);
    int insert(Notice notice);
    int scrap(Notice notice);
    int countAll();
    Notice findByNo(int no);
    int updateViewCount(int no);
    int update(Notice notice);
    int delete(int no);
}















