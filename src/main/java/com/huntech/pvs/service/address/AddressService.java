package com.huntech.pvs.service.address;


import com.huntech.pvs.model.address.AddressCity;
import com.huntech.pvs.model.address.AddressProvince;
import com.huntech.pvs.model.address.AddressTown;

import java.util.List;

public interface AddressService {
    List<AddressProvince> getProvince(String code);
    List<AddressCity> getCity(String provinceCode);
    List<AddressTown> getTown(String cityCode);
}
