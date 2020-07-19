package lyh.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.servlet.http.HttpServletRequest;

@Setter
@Getter
@ToString
public class Page {
    private String searchText;//搜索
    private String sortOrder;//排序的方式
    private Integer pageSize;//每页数量
    private Integer pageNumber;//当前第几页

    private Page(){}

    public static Page parse(HttpServletRequest req){
        Page page = new Page();
        page.searchText = req.getParameter("searchText");
        page.sortOrder = req.getParameter("sortOrder");
        page.pageSize = Integer.parseInt(req.getParameter("pageSize"));
        page.pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
        return page;
    }
}
