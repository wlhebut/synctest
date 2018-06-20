package com.huntech.pvs.dao.address;

import com.huntech.pvs.model.address.AddressProvince;
import com.huntech.pvs.model.address.AddressProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressProvinceMapper {
    int countByExample(AddressProvinceExample example);

    int deleteByExample(AddressProvinceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressProvince record);

    int insertSelective(AddressProvince record);

    List<AddressProvince> selectByExample(AddressProvinceExample example);

    AddressProvince selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddressProvince record, @Param("example") AddressProvinceExample example);

    int updateByExample(@Param("record") AddressProvince record, @Param("example") AddressProvinceExample example);

    int updateByPrimaryKeySelective(AddressProvince record);

    int updateByPrimaryKey(AddressProvince record);
}