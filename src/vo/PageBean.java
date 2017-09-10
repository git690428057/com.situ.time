package vo;

import java.io.Serializable;
import java.util.List;

import POJO.Student;

public class PageBean implements Serializable {
private Integer pageIndex;
private Integer totalPage;
private Integer pageSize;
private Integer totalCount;
private List<Student> list;
public Integer getPageIndex() {
	return pageIndex;
}
public void setPageIndex(Integer pageIndex) {
	this.pageIndex = pageIndex;
}
public Integer getTotalPage() {
	return totalPage;
}
public void setTotalPage(Integer totalPage) {
	this.totalPage = totalPage;
}
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
public Integer getTotalCount() {
	return totalCount;
}
public void setTotalCount(Integer totalCount) {
	this.totalCount = totalCount;
}
public List<Student> getList() {
	return list;
}
public void setList(List<Student> list) {
	this.list = list;
}
@Override
public String toString() {
	return "PageBean [pageIndex=" + pageIndex + ", totalPage=" + totalPage + ", pageSize=" + pageSize + ", totalCount="
			+ totalCount + ", list=" + list + "]";
}
public PageBean(Integer pageIndex, Integer totalPage, Integer pageSize, Integer totalCount, List<Student> list) {
	super();
	this.pageIndex = pageIndex;
	this.totalPage = totalPage;
	this.pageSize = pageSize;
	this.totalCount = totalCount;
	this.list = list;
}
public PageBean() {
}

}
