package com.huntech.pvs.dao.address;

import com.huntech.pvs.model.address.AddressCity;
import com.huntech.pvs.model.address.AddressCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressCityMapper {
    int countByExample(AddressCityExample example);

    int deleteByExample(AddressCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressCity record);

    int insertSelective(AddressCity record);

    List<AddressCity> selectByExample(AddressCityExample example);

    AddressCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddressCity record, @Param("example") AddressCityExample example);

    int updateByExample(@Param("record") AddressCity record, @Param("example") AddressCityExample example);

    int updateByPrimaryKeySelective(AddressCity record);

    int updateByPrimaryKey(AddressCity record);
}