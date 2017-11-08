package edu.hnust.dto;

import java.util.List;

/**
 * 分页数据和记录数
 * @author zhengshaokang
 *
 * @param <T>
 */
public class ReturnPageData<T> {
	
	private List<T> collection;
	private Long collectionCount;
	
	public List<T> getCollection() {
		return collection;
	}
	public void setCollection(List<T> collection) {
		this.collection = collection;
	}
	public Long getCollectionCount() {
		return collectionCount;
	}
	public void setCollectionCount(Long collectionCount) {
		this.collectionCount = collectionCount;
	}
	@Override
	public String toString() {
		return "ReturnPageData [collection=" + collection
				+ ", collectionCount=" + collectionCount + "]";
	}
}
