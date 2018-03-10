package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Member;
import java100.app.domain.Notice;

public interface NoticeService {
    List<Notice> list(int pageNo, int pageSize, Map<String, Object> options);
    List<Notice> writerList(Member loginUser);
    Notice get(int no);
    int add(Notice notice);
    int update(Notice notice);
    int delete(int no);
    int getTotalCount();
}





