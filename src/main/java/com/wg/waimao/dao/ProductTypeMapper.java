package com.wg.waimao.dao;

import com.wg.waimao.entity.ProductType;
import java.util.List;

public interface ProductTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_type
     *
     * @mbggenerated
     */
    int insert(ProductType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_type
     *
     * @mbggenerated
     */
    List<ProductType> selectAll();
}