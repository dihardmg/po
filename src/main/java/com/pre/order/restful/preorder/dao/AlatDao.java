package com.pre.order.restful.preorder.dao;

import com.pre.order.restful.preorder.entity.Alat;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Added by     : com.didikhariyanto@gmail.com
 * Since        : 5/9/18
 * Time         : 11:17 AM
 */
@Repository
public interface AlatDao extends PagingAndSortingRepository<Alat, String> {
}
